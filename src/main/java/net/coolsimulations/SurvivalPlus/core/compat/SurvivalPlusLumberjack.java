package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPItemTier;
import net.doubledoordev.lumberjack.LumberjackConfig;
import net.doubledoordev.lumberjack.util.EventHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusLumberjack {
	
	public static final DeferredRegister<Item> ITEMS_LUMBERJACK = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> bronze_lumberaxe = ITEMS_LUMBERJACK.register("bronze_lumberaxe", () -> new SPItemLumberAxe(SPItemTier.bronzeToolMaterial));
	private static final RegistryObject<Item> titanium_lumberaxe = ITEMS_LUMBERJACK.register("titanium_lumberaxe", () -> new SPItemLumberAxe(SPItemTier.titaniumToolMaterial));
	
	public static void registerEventHandler() {
		
		MinecraftForge.EVENT_BUS.register(new SurvivalPlusLumberjack.SPEventHandler());
	}
	
	public static class SPItemLumberAxe extends AxeItem {

		public SPItemLumberAxe(Tier itemTier) {
			super(itemTier, itemTier.getAttackDamageBonus(), itemTier.getSpeed(), new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
		}
		
		@Override
	    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
	    {
	        return stack != ItemStack.EMPTY && worldIn != null && (Material.LEAVES.equals(state.getMaterial()) || super.mineBlock(stack, worldIn, state, pos, entityLiving));
	    }
	}
	
	public static class SPEventHandler extends EventHandler {
		
		// Keeps track of the chopped blocks across multiple ticks, until there is no more left. Then gets cleared.
	    private HashMultimap<UUID, BlockPos> pointMap = HashMultimap.create();
	    // Keeps track of what blocks to chop next tick.
	    private HashMultimap<UUID, BlockPos> nextMap = HashMultimap.create();

	    /*
	     * To avoid the server lagging to death for large tries.
	     */
	    @SubscribeEvent
	    public void tickEvent(TickEvent.PlayerTickEvent event)
	    {
	        if (event.phase != TickEvent.Phase.START) return;
	        if (event.side != LogicalSide.SERVER) return;

	        final UUID uuid = event.player.getUUID();

	        // If there are no blocks to chop, return
	        if (!nextMap.containsKey(uuid) || nextMap.get(uuid).isEmpty()) return;

	        // Immutable and not an iterator because breakEvent can modify this list!
	        int i = 0;
	        for (BlockPos point : ImmutableSet.copyOf(nextMap.get(uuid)))
	        {
	            // This indirectly causes breakEvent to be invoked
	            ((ServerPlayer) event.player).gameMode.destroyBlock(point);
	            // Remove the current point
	            nextMap.remove(uuid, point);
	            if (i++ > LumberjackConfig.GENERAL.tickLimit.get()) break;
	        }
	        // If more blocks then the total limit have been chopped, clear out the next list, thereby breaking the chain
	        if (pointMap.get(uuid).size() > LumberjackConfig.GENERAL.totalLimit.get()) nextMap.removeAll(uuid);
	        // If the next map does not reference this player anymore, we can get rid of the old data
	        if (!nextMap.containsKey(uuid) || !nextMap.get(uuid).isEmpty()) pointMap.removeAll(uuid);
	    }

	    @SubscribeEvent
	    public void breakEvent(BlockEvent.BreakEvent event)
	    {
	        final Player player = event.getPlayer();
	        if (player == null) return;
	        final UUID uuid = player.getUUID();
	        final BlockState state = event.getState();
	        // Only interact if wood or leaves
	        if (!(state.getMaterial() == Material.WOOD || (LumberjackConfig.GENERAL.leaves.get() && state.getMaterial() == Material.LEAVES)))
	            return;

	        // Only interact if  the item matches
	        ItemStack itemStack = player.getMainHandItem();
	        if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof SPItemLumberAxe)) return;

	        // We are chopping the current block, so save that info
	        pointMap.put(uuid, event.getPos());

	        // For each block in a 3x3x3 cube around this one
	        for (int offsetX = -1; offsetX <= 1; offsetX++)
	        {
	            for (int offsetZ = -1; offsetZ <= 1; offsetZ++)
	            {
	                for (int offsetY = -1; offsetY <= 1; offsetY++)
	                {
	                    BlockPos newPoint = event.getPos().offset(offsetX, offsetY, offsetZ);
	                    // Avoid doing the same block more then once
	                    if (nextMap.containsEntry(uuid, newPoint) || pointMap.containsEntry(uuid, newPoint)) continue;

	                    BlockState newBlockState = event.getLevel().getBlockState(newPoint);
	                    boolean isLeaves = LumberjackConfig.GENERAL.leaves.get() && newBlockState.getMaterial() == Material.LEAVES;

	                    // Mode 0: leaves or same blocktype
	                    // Mode 1: leaves or all wood
	                    if ((LumberjackConfig.GENERAL.mode.get() == 0 && (isLeaves || newBlockState.getBlock() == state.getBlock()))
	                            || LumberjackConfig.GENERAL.mode.get() == 1 && (isLeaves || newBlockState.getMaterial() == Material.WOOD))
	                        nextMap.put(uuid, newPoint); // Add the block for next tick
	                }
	            }
	        }
	    }
		
		
	}

}