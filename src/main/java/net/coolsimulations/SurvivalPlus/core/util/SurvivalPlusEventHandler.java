package net.coolsimulations.SurvivalPlus.core.util;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.TripWireBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.RegistryEvent.MissingMappings;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

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

		Timer timer = new Timer();

		if(install !=null && player.getAdvancements().getProgress(install).hasProgress()) {
			isDone = true;
		}

		if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks.get()) {

			entityData.putBoolean("sp.firstJoin", true);

			if(!player.world.isRemote) {

				TranslationTextComponent installInfo = new TranslationTextComponent("advancements.sp.install.display1");
				installInfo.getStyle().setColor(TextFormatting.GOLD);
				installInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("advancements.sp.install.display2")));
				installInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
				player.sendMessage(installInfo);

				TranslationTextComponent discord = new TranslationTextComponent("sp.discord.display1");
				discord.getStyle().setColor(TextFormatting.DARK_GREEN);
				discord.getStyle().setBold(true);

				for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {
					String name = LanguageMap.getInstance().translateKey(SPReference.MOD_ADDON_NAMES.get(i));

					StringTextComponent formatted = new StringTextComponent(name);
					formatted.getStyle().setColor(TextFormatting.BLUE);
					formatted.getStyle().setBold(true);

					StringTextComponent gap = new StringTextComponent(", ");
					gap.getStyle().setColor(TextFormatting.WHITE);

					discord.appendSibling(formatted);
					if(i + 1 != SPReference.MOD_ADDON_NAMES.size()) {
						discord.appendSibling(gap);
					}
				}
				discord.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("sp.discord.display2")));
				discord.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/7DDsHfQ"));

				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						player.sendMessage(discord);
					}
				}, 30000);
			}
		}

		if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck.get() == false) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					player.sendMessage(SurvivalPlusUpdateHandler.updateInfo);
					player.sendMessage(SurvivalPlusUpdateHandler.updateVersionInfo);
				}
			}, 15000);
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
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.raw_onion, 6), new ItemStack(Items.EMERALD), 16, 5, 0.05F));
		}

		if(event.getType() == VillagerProfession.ARMORER) {
			trades.get(2).add(new BasicTrade(3, new ItemStack(SPItems.bronze_chestplate), 12, 5, 0.2F));
		}

		if(event.getType() == VillagerProfession.ARMORER  || event.getType() == VillagerProfession.WEAPONSMITH) {
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.bronze_ingot, 3), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
			trades.get(2).add(new BasicTrade(new ItemStack(SPItems.titanium_ingot, 3), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		}

	}

	@SubscribeEvent
	public void villagerTrades(WandererTradesEvent event) {
		List<ITrade> trades = (List<ITrade>) event.getGenericTrades();

		trades.add(new BasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 20));		
	}

	@SubscribeEvent
	public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		BlockState state = event.getWorld().getBlockState(event.getPos());

		PlayerEntity entityplayer = event.getPlayer();
		ItemStack itemStackIn = entityplayer.getHeldItem(event.getHand());
		Item item = itemStackIn.getItem();

		if(block instanceof CampfireBlock) {
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

		if(block == Blocks.PUMPKIN) {

			if (item instanceof ShearsItem && item != Items.SHEARS) {
				if (!event.getWorld().isRemote) {
					Direction direction = event.getFace();
					Direction direction1 = direction.getAxis() == Direction.Axis.Y ? entityplayer.getHorizontalFacing().getOpposite() : direction;
					event.getWorld().playSound((PlayerEntity)null, event.getPos(), SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					event.getWorld().setBlockState(event.getPos(), Blocks.CARVED_PUMPKIN.getDefaultState().with(CarvedPumpkinBlock.FACING, direction1), 11);
					ItemEntity itementity = new ItemEntity(event.getWorld(), (double)event.getPos().getX() + 0.5D + (double)direction1.getXOffset() * 0.65D, (double)event.getPos().getY() + 0.1D, (double)event.getPos().getZ() + 0.5D + (double)direction1.getZOffset() * 0.65D, new ItemStack(Items.PUMPKIN_SEEDS, 4));
					itementity.setMotion(0.05D * (double)direction1.getXOffset() + event.getWorld().rand.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction1.getZOffset() + event.getWorld().rand.nextDouble() * 0.02D);
					event.getWorld().addEntity(itementity);
					itemStackIn.damageItem(1, entityplayer, (livingentity) -> {
						livingentity.sendBreakAnimation(event.getHand());
					});
				}
			}
		}

		if(block == Blocks.CAKE) {

			if((entityplayer.getHeldItemMainhand().getItem() == SPItems.paper_cup || entityplayer.getHeldItemOffhand().getItem() == SPItems.paper_cup) || entityplayer.getHeldItemMainhand().getItem() == SPItems.cupcake || entityplayer.getHeldItemOffhand().getItem() == SPItems.cupcake) {
				event.setCanceled(true);
			}

			if(entityplayer.getHeldItem(event.getHand()).getItem() == SPItems.paper_cup) {

				if(!event.getWorld().isRemote) {

					int bites = (Integer)state.get(CakeBlock.BITES);

					if (bites < 6) {
						event.getWorld().setBlockState(event.getPos(), (BlockState)state.with(CakeBlock.BITES, bites + 1), 3);
					} else {
						event.getWorld().removeBlock(event.getPos(), false);
					}

					if(!entityplayer.isCreative()) {
						if(itemStackIn.getCount() == 1) {
							if (ItemStack.areItemStacksEqual(entityplayer.getHeldItemOffhand(), itemStackIn))
							{
								entityplayer.setHeldItem(Hand.OFF_HAND, new ItemStack(SPItems.cupcake));
							}
							else
							{
								entityplayer.setHeldItem(Hand.MAIN_HAND, new ItemStack(SPItems.cupcake));
							}
						} else  if(itemStackIn.getCount() >= 2){
							itemStackIn.shrink(1);
							boolean flag = entityplayer.inventory.addItemStackToInventory(new ItemStack(SPItems.cupcake));
							if(!flag) {
								entityplayer.dropItem(new ItemStack(SPItems.cupcake), false);
							}
						}
					}
				}
			}
		}

	}

	@SubscribeEvent
	public void tripWireBreak(BreakEvent event) {

		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		BlockState state = event.getWorld().getBlockState(event.getPos());

		PlayerEntity entityplayer = event.getPlayer();

		if (block instanceof TripWireBlock && !event.getWorld().isRemote() && !entityplayer.getHeldItemMainhand().isEmpty() && entityplayer.getHeldItemMainhand().getItem() instanceof ShearsItem && entityplayer.getHeldItemMainhand().getItem() != Items.SHEARS) {
			event.getWorld().setBlockState(event.getPos(), state.with(TripWireBlock.DISARMED, Boolean.valueOf(true)), 4);
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

				if(SPCompatibilityManager.isHammerTimeLoaded()) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxediamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxegold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxeiron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxestone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemaxewood"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerdiamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammergold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammeriron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerstone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemhammerwood"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshoveldiamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelgold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshoveliron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelstone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemshovelwood"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklediamond"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklegold"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsickleiron"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklestone"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.HAMMER_TIME_MODID + ":" + "itemsicklewood"));
		}

    }**/

	@SubscribeEvent
	public void coolsimChat(ServerChatEvent event) {

		TranslationTextComponent coolsim = new TranslationTextComponent("sp.coolsim.creator");
		coolsim.getStyle().setColor(TextFormatting.GOLD);

		if(event.getPlayer().getUniqueID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			if(ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayerByUsername(event.getUsername()) != null)
				event.setComponent(new StringTextComponent(coolsim.getFormattedText() + " <" + ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayerByUsername(event.getUsername()).getDisplayName().getFormattedText() + "> " + event.getMessage()));
		}
	}

	@SubscribeEvent
	public void coolsimReceivedChat(ClientChatReceivedEvent event) {

		TranslationTextComponent coolsim = new TranslationTextComponent("sp.coolsim.creator");
		coolsim.getStyle().setColor(TextFormatting.GOLD);

		String coolsimFormatted = "coolsim";

		if(event.getMessage().getFormattedText().contains("coolsim")) {
			int index = event.getMessage().getFormattedText().indexOf("coolsim");
			try {
				coolsimFormatted = event.getMessage().getFormattedText().substring(index - 2, index + 9);
				if(StringUtils.countMatches(coolsimFormatted, "§") != 2) {
					coolsimFormatted = "coolsim";
				}
			} catch(Exception e) {
				
			}
		}
		
		TranslationTextComponent playerJoined = new TranslationTextComponent("multiplayer.player.joined", new Object[] {coolsimFormatted});
		playerJoined.getStyle().setColor(TextFormatting.YELLOW);

		TranslationTextComponent playerLeft = new TranslationTextComponent("multiplayer.player.left", new Object[] {coolsimFormatted});
		playerLeft.getStyle().setColor(TextFormatting.YELLOW);

		TranslationTextComponent coolsimJoined = new TranslationTextComponent("sp.coolsim.joined", new Object[] {coolsimFormatted});
		coolsimJoined.getStyle().setColor(TextFormatting.YELLOW);

		TranslationTextComponent coolsimLeft = new TranslationTextComponent("sp.coolsim.left", new Object[] {coolsimFormatted});
		coolsimLeft.getStyle().setColor(TextFormatting.YELLOW);

		if(replaceFormattingCodes(event.getMessage()).equals(replaceFormattingCodes(playerJoined))) {
			event.setMessage(coolsimJoined);
		}

		if(replaceFormattingCodes(event.getMessage()).equals(replaceFormattingCodes(playerLeft))) {
			event.setMessage(coolsimLeft);
		}

		if(replaceFormattingCodes(event.getMessage()).startsWith("[coolsim]")) {
			event.setMessage(new StringTextComponent(event.getMessage().getFormattedText().replaceFirst("\\[", coolsim.getFormattedText() + " [")));
		}
	}

	@SubscribeEvent
	public void coolsimDeath(LivingDeathEvent event) {

		if(event.getEntity() instanceof ServerPlayerEntity && event.getEntity().getUniqueID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && event.getSource().getTrueSource() instanceof ServerPlayerEntity) {

			ServerPlayerEntity attacker = (ServerPlayerEntity) event.getSource().getTrueSource();
			ItemStack coolsimHead = getcoolsimHead();

			if(coolsimHead != null) {
				dropItem(coolsimHead, attacker);
			} else {
				TranslationTextComponent error = new TranslationTextComponent("sp.coolsim.error");
				error.getStyle().setColor(TextFormatting.RED);
				attacker.sendMessage(error);
			}
		}

	}

	public static ItemStack getcoolsimHead()
	{
		String texture = "eyJ0aW1lc3RhbXAiOjE1NzYxMTM5OTc5ODUsInByb2ZpbGVJZCI6IjU0NDgxMjU3N2I2ZDRjOGU4YWFjY2E2Zjg2NGUxNDEyIiwicHJvZmlsZU5hbWUiOiJjb29sc2ltIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdmMDkwM2QxOGMyZTE4YmQzYzBiMDk5YmIzZGFkNmVjYTQ2ZDBjMzdkZjJkM2FlMjljYzAwOWYwN2I5OTM3NmYifX19";
		String id = new UUID(texture.hashCode(), texture.hashCode()).toString();

		ItemStack playerhead = new ItemStack(Items.PLAYER_HEAD);

		TranslationTextComponent headName = new TranslationTextComponent("block.minecraft.player_head.named", new Object[] {"coolsim"});
		headName.getStyle().setItalic(true);
		CompoundNBT skullOwner = new CompoundNBT();
		skullOwner.putString("Id", id);
		CompoundNBT properties = new CompoundNBT();
		ListNBT textures = new ListNBT();
		CompoundNBT tex = new CompoundNBT();
		tex.putString("Value", texture);
		textures.add(tex);
		properties.put("textures", textures);
		skullOwner.put("Properties", properties);
		playerhead.setTagInfo("SkullOwner", skullOwner);
		playerhead.setDisplayName(headName);

		return playerhead;
	}

	public static void dropItem(ItemStack stack, PlayerEntity player) {

		boolean bl = player.inventory.addItemStackToInventory(stack);
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			ItemEntity itementity1 = player.dropItem(stack, false);
			if (itementity1 != null) {
				itementity1.makeFakeItem();
			}

			player.world.playSound((PlayerEntity)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((player.getRNG().nextFloat() - player.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
			player.container.detectAndSendChanges();
		} else {
			ItemEntity itementity = player.dropItem(stack, false);
			if (itementity != null) {
				itementity.setNoPickupDelay();
				itementity.setOwnerId(player.getUniqueID());
			}
		}

	}

	public static String replaceFormattingCodes(ITextComponent component) {

		String text = component.getFormattedText();

		if(text.contains("§")) {

			for(int i = 0; i <= StringUtils.countMatches(text, "§"); i++) {
				text = text.substring(0, text.indexOf("§")) + text.substring(text.indexOf("§") + 2);
			}
		}

		return text;
	}
}
