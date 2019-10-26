package net.coolsimulations.SurvivalPlus.core.util;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;

public class SurvivalPlusEventHandler {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event)
    {
        if (event.getModID().equals(SPReference.MOD_ID))
        {
            //SurvivalPlusConfig.syncConfig(false);
        }
    }
	
	@SubscribeEvent
	public void onplayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		CompoundNBT entityData = player.getPersistentData();
		
		AdvancementManager manager = player.getServer().getAdvancementManager();
		Advancement install = manager.getAdvancement(new ResourceLocation(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));
		
		boolean isDone = false;
		
		if(install !=null && player.getAdvancements().getProgress(install).hasProgress()) {
			isDone = true;
		}
		
		if(!entityData.getBoolean("sp.firstJoin") && !isDone) {
			
			entityData.putBoolean("sp.firstJoin", true);
		
			if(!player.world.isRemote) {
        		
        		TranslationTextComponent installInfo = new TranslationTextComponent("advancements.sp.install.display1");
        		installInfo.getStyle().setColor(TextFormatting.GOLD);
        		installInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("advancements.sp.install.display2")));
            	installInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
				player.sendMessage(installInfo);
				
				TranslationTextComponent installTextureInfo = new TranslationTextComponent("sp.install_texture.display");
				installTextureInfo.getStyle().setColor(TextFormatting.YELLOW);
				installTextureInfo.getStyle().setBold(true);
				installTextureInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("sp.update.display2")));
				installTextureInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/texture-packs/survivalplus"));
				player.sendMessage(installTextureInfo);

        	}
		}
		
		if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck.get() == false) {
        	player.sendMessage(SurvivalPlusUpdateHandler.updateInfo);
        	player.sendMessage(SurvivalPlusUpdateHandler.updateVersionInfo);
        }
    }
	
	@SubscribeEvent
	public void villagerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		
		if(event.getType() == VillagerProfession.BUTCHER) {
			trades.get(3).add(new BasicTrade(2, new ItemStack(SPItems.beef_pie, 4), 16, 20));
		}
		
		if(event.getType() == VillagerProfession.FARMER) {
			trades.get(1).add(new BasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 2)); //temp till forge pull request #6142 is resolved
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.raw_onion, 13), new ItemStack(Items.EMERALD), 16, 5, 0.05F));
		}
		
		if(event.getType() == VillagerProfession.ARMORER) {
			trades.get(2).add(new BasicTrade(6, new ItemStack(SPItems.bronze_chestplate), 12, 5, 0.2F));
		}
		
		if(event.getType() == VillagerProfession.ARMORER  || event.getType() == VillagerProfession.WEAPONSMITH) {
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.bronze_ingot, 12), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.titanium_ingot, 18), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		}
		
	}
	
	@SubscribeEvent
	public void villagerTrades(WandererTradesEvent event) {
		List<ITrade> trades = (List<ITrade>) event.getGenericTrades();
		
		trades.add(new BasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 20));		
	}
	
	@SubscribeEvent
	public void campireEvent(PlayerInteractEvent.RightClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		BlockState state = event.getWorld().getBlockState(event.getPos());
		
		PlayerEntity entityplayer = event.getPlayer();
		
		if(block == Blocks.CAMPFIRE) {
			ItemStack itemStackIn = entityplayer.getHeldItem(event.getHand());
		    	Item item = itemStackIn.getItem();
		    	if(state.get(CampfireBlock.LIT) && item == Items.BUCKET  && !entityplayer.abilities.isCreativeMode) {
		    		event.getWorld().setBlockState(event.getPos(), state.with(CampfireBlock.LIT, false));
		    		if (event.getWorld().isRemote()) {
						for (int i = 0; i < 20; ++i) {
							CampfireBlock.func_220098_a(event.getWorld(), event.getPos(), (Boolean) state.get(CampfireBlock.SIGNAL_FIRE),true);
						}
					} else {
						event.getWorld().playSound((PlayerEntity) null, event.getPos(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					}
		    		if(itemStackIn.getCount() == 1) {
		        		if (ItemStack.areItemStacksEqual(entityplayer.getHeldItemOffhand(), itemStackIn))
		        		{
		        			entityplayer.setHeldItem(Hand.OFF_HAND, new ItemStack(SPItems.charcoal_bucket));
		        		}
		        		else
		        		{
		        			entityplayer.setHeldItem(Hand.MAIN_HAND, new ItemStack(SPItems.charcoal_bucket));
		       			}
		        	} else  if(itemStackIn.getCount() >= 2){
		        		itemStackIn.shrink(1);
		        		boolean flag = entityplayer.inventory.addItemStackToInventory(new ItemStack(SPItems.charcoal_bucket));
		        		if(!flag) {
		        			entityplayer.dropItem(new ItemStack(SPItems.charcoal_bucket), false);
		        		}		
		        	}
		    	}
		}
	}
	
	/**@SubscribeEvent
    public static <T extends IForgeRegistryEntry<T>> void registerRecipes(RegistryEvent.Register<T> event)
    {
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		final RecipeManager recipeManager = event.getServer().getRecipeManager();
		
		if(!SPConfig.enableSponge.get()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "sponge"));
		}
		
		if(SPCompatibilityManager.isIc2Loaded()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "bronze_ingot_alt2"));
		}
        
    }**/

}
