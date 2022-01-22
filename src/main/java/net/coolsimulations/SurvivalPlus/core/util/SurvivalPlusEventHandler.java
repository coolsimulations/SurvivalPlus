package net.coolsimulations.SurvivalPlus.core.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.compat.RainbowComponent;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.coolsimulations.SurvivalPlus.core.recipes.SPShieldRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class SurvivalPlusEventHandler {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event)
	{
		if (event.getModID().equals(SPReference.MOD_ID))
		{
			SurvivalPlusConfig.syncConfig(false);
		}
	}

	@SubscribeEvent
	public void onplayerLogin(PlayerLoggedInEvent event)
	{
		EntityPlayerMP player = (EntityPlayerMP) event.player;
		NBTTagCompound entityData = player.getEntityData();

		AdvancementManager manager = player.getServer().getAdvancementManager();
		Advancement install = manager.getAdvancement(new ResourceLocation(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));

		boolean isDone = false;

		Timer timer = new Timer();

		if(install !=null && player.getAdvancements().getProgress(install).hasProgress()) {
			isDone = true;
		}

		if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks) {

			entityData.setBoolean("sp.firstJoin", true); 

			if(!player.world.isRemote) {

				TextComponentTranslation installInfo = new TextComponentTranslation("advancements.sp.install.display1");
				installInfo.getStyle().setColor(TextFormatting.GOLD);
				installInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentTranslation("advancements.sp.install.display2")));
				installInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus"));
				player.sendMessage(installInfo);

				TextComponentTranslation discord = new TextComponentTranslation("sp.discord.display1");
				discord.getStyle().setColor(TextFormatting.DARK_GREEN);
				discord.getStyle().setBold(true);

				for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {
					String name = I18n.translateToLocal(SPReference.MOD_ADDON_NAMES.get(i));

					TextComponentString formatted = new TextComponentString(name);
					formatted.getStyle().setColor(TextFormatting.BLUE);
					formatted.getStyle().setBold(true);

					TextComponentString gap = new TextComponentString(", ");
					gap.getStyle().setColor(TextFormatting.WHITE);

					discord.appendSibling(formatted);
					if(i + 1 != SPReference.MOD_ADDON_NAMES.size()) {
						discord.appendSibling(gap);
					}
				}
				discord.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentTranslation("sp.discord.display2")));
				discord.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/7DDsHfQ"));

				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						player.sendMessage(discord);
					}
				}, 30000);
			}
		}

		if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck == false) {
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
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		SurvivalPlusItems.registerItems(event.getRegistry());
		SurvivalPlusFood.registerItems(event.getRegistry());
		SurvivalPlusArmor.registerItems(event.getRegistry());
		SurvivalPlusTools.registerItems(event.getRegistry());
		SurvivalPlusOreDict.PreInit();
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		SurvivalPlusBlocks.registerBlocks(event.getRegistry());

	}

	@SubscribeEvent
	public void tripWireBreak(BreakEvent event) {

		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		IBlockState state = event.getWorld().getBlockState(event.getPos());

		EntityPlayer entityplayer = event.getPlayer();

		if (block instanceof BlockTripWire && !event.getWorld().isRemote && !entityplayer.getHeldItemMainhand().isEmpty() && entityplayer.getHeldItemMainhand().getItem() instanceof ItemShears && entityplayer.getHeldItemMainhand().getItem() != Items.SHEARS) {
			event.getWorld().setBlockState(event.getPos(), state.withProperty(BlockTripWire.DISARMED, Boolean.valueOf(true)), 4);
		}
	}

	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event)
	{
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();

		event.getRegistry().register(new SPShieldRecipes.Decoration().setRegistryName(SPReference.MOD_ID, "SPShieldDecoration"));

		if(!SPConfig.enableSponge) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "sponge"));
		}

		if(!SPCompatibilityManager.isIc2Loaded()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt1"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt2"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt3"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt4"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt5"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt6"));
		}
	}

	@SubscribeEvent
	public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		IBlockState state = event.getWorld().getBlockState(event.getPos());

		EntityPlayer entityplayer = event.getEntityPlayer();
		ItemStack itemStackIn = entityplayer.getHeldItem(event.getHand());
		Item item = itemStackIn.getItem();

		if(block == Blocks.CAKE) {
			
			if((entityplayer.getHeldItemMainhand().getItem() == SPItems.paper_cup || entityplayer.getHeldItemOffhand().getItem() == SPItems.paper_cup) || entityplayer.getHeldItemMainhand().getItem() == SPItems.cupcake || entityplayer.getHeldItemOffhand().getItem() == SPItems.cupcake) {
				event.setCanceled(true);
			}
			
			if(entityplayer.getHeldItem(event.getHand()).getItem() == SPItems.paper_cup) {

				if(!event.getWorld().isRemote) {

					int i = ((Integer)state.getValue(BlockCake.BITES)).intValue();

					if (i < 6)
					{
						event.getWorld().setBlockState(event.getPos(), state.withProperty(BlockCake.BITES, Integer.valueOf(i + 1)), 3);
					}
					else
					{
						event.getWorld().setBlockToAir(event.getPos());
					}

					if(!entityplayer.capabilities.isCreativeMode) {
						if(itemStackIn.getCount() == 1) {
							if (ItemStack.areItemStacksEqual(entityplayer.getHeldItemOffhand(), itemStackIn))
							{
								entityplayer.setHeldItem(EnumHand.OFF_HAND, new ItemStack(SPItems.cupcake));
							}
							else
							{
								entityplayer.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(SPItems.cupcake));
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
	public void onModelRegistry(ModelRegistryEvent event)
	{
		for(Item item : SurvivalPlus.ITEMS) {
			SurvivalPlusItems.registerRenders();
		}

		for(Item item : SurvivalPlus.ITEMS_FOOD) {
			SurvivalPlusFood.registerRenders();
		}

		for(Item item : SurvivalPlus.ITEMS_ARMOR) {
			SurvivalPlusArmor.registerRenders();
		}

		for(Item item : SurvivalPlus.ITEMS_TOOLS) {
			SurvivalPlusTools.registerRenders();
		}

		for(Block block : SurvivalPlus.BLOCKS) {
			SurvivalPlusBlocks.registerRenders();
		}
	}

	@SubscribeEvent
	public void coolsimDisplayName(PlayerEvent.NameFormat event) {
		
		if(event.getEntityPlayer().getPersistentID().equals(UUID.fromString("a07ca1b4-b0c5-4cbf-bf5f-2d9acf0603d2"))) {

			TextComponentString alpaca = new TextComponentString(new RainbowComponent(event.getUsername()).getText());

			if(event.getEntityPlayer().getTeam() == null) {
				event.setDisplayname(alpaca.getText());
			} else if(event.getEntityPlayer().getTeam() instanceof ScorePlayerTeam) {
				if(((ScorePlayerTeam) event.getEntityPlayer().getTeam()).getColor() == TextFormatting.RESET)
					event.setDisplayname(alpaca.getText());
			}
		}
	}

	@SubscribeEvent
	public void coolsimChat(ServerChatEvent event) {

		TextComponentTranslation coolsim = new TextComponentTranslation("sp.coolsim.creator");
		coolsim.getStyle().setColor(TextFormatting.GOLD);

		if(event.getPlayer().getPersistentID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412"))) {
			if(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(event.getUsername()) != null)
				event.setComponent(new TextComponentString(coolsim.getFormattedText() + " <" + FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(event.getUsername()).getDisplayName().getFormattedText() + "> " + event.getMessage()));
		}
	}

	@SubscribeEvent
	public void coolsimReceivedChat(ClientChatReceivedEvent event) {

		TextComponentTranslation coolsim = new TextComponentTranslation("sp.coolsim.creator");
		coolsim.getStyle().setColor(TextFormatting.GOLD);

		TextComponentTranslation playerJoined = new TextComponentTranslation("multiplayer.player.joined", new Object[] {"coolsim"});

		TextComponentTranslation playerLeft = new TextComponentTranslation("multiplayer.player.left", new Object[] {"coolsim"});
		
		String coolsimFormatted = "coolsim";
		
		if(event.getMessage().getFormattedText().contains("coolsim")) {
			int index = event.getMessage().getFormattedText().indexOf("coolsim");
			try {
				coolsimFormatted = event.getMessage().getFormattedText().substring(index - 2, index + 9);
			} catch(Exception e) {

			}
		}
		
		TextComponentTranslation coolsimJoined = new TextComponentTranslation("sp.coolsim.joined", new Object[] {coolsimFormatted});
		coolsimJoined.getStyle().setColor(TextFormatting.YELLOW);
		
		TextComponentTranslation coolsimLeft = new TextComponentTranslation("sp.coolsim.left", new Object[] {coolsimFormatted});
		coolsimLeft.getStyle().setColor(TextFormatting.YELLOW);

		if(replaceFormattingCodes(event.getMessage()).equals(playerJoined.getUnformattedText())) {
			event.setMessage(coolsimJoined);
		}

		if(replaceFormattingCodes(event.getMessage()).equals(playerLeft.getUnformattedText())) {
			event.setMessage(coolsimLeft);
		}

		if(replaceFormattingCodes(event.getMessage()).startsWith("[coolsim]")) {
			event.setMessage(new TextComponentString(event.getMessage().getFormattedText().replaceFirst("\\[", coolsim.getFormattedText() + " [")));
		}
	}

	@SubscribeEvent
	public void coolsimDeath(LivingDeathEvent event) {

		if(event.getEntity() instanceof EntityPlayer && event.getEntity().getPersistentID().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && event.getSource().getTrueSource() instanceof EntityPlayer) {

			EntityPlayerMP attacker = (EntityPlayerMP) event.getSource().getTrueSource();
			ItemStack coolsimHead = getcoolsimHead();

			if(coolsimHead != null) {
				dropItem(coolsimHead, attacker);
			} else {
				TextComponentTranslation error = new TextComponentTranslation("sp.coolsim.error");
				error.getStyle().setColor(TextFormatting.RED);
				attacker.sendMessage(error);
			}
		}

	}

	public static ItemStack getcoolsimHead()
	{
		String texture = "eyJ0aW1lc3RhbXAiOjE1NzYxMTM5OTc5ODUsInByb2ZpbGVJZCI6IjU0NDgxMjU3N2I2ZDRjOGU4YWFjY2E2Zjg2NGUxNDEyIiwicHJvZmlsZU5hbWUiOiJjb29sc2ltIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdmMDkwM2QxOGMyZTE4YmQzYzBiMDk5YmIzZGFkNmVjYTQ2ZDBjMzdkZjJkM2FlMjljYzAwOWYwN2I5OTM3NmYifX19";
		String id = new UUID(texture.hashCode(), texture.hashCode()).toString();

		ItemStack playerhead = new ItemStack(Items.SKULL, 1, 3);

		TextComponentTranslation headName = new TextComponentTranslation("item.skull.player.name", new Object[] {"coolsim"});
		headName.getStyle().setItalic(true);
		NBTTagCompound skullOwner = new NBTTagCompound();
		skullOwner.setString("Id", id);
		NBTTagCompound properties = new NBTTagCompound();
		NBTTagList textures = new NBTTagList();
		NBTTagCompound tex = new NBTTagCompound();
		tex.setString("Value", texture);
		textures.appendTag(tex);
		properties.setTag("textures", textures);
		skullOwner.setTag("Properties", properties);
		playerhead.setTagInfo("SkullOwner", skullOwner);
		playerhead.setStackDisplayName(headName.getFormattedText());

		return playerhead;
	}

	public static void dropItem(ItemStack stack, EntityPlayer player) {

		boolean bl = player.inventory.addItemStackToInventory(stack);
		EntityItem itemEntity;
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			itemEntity = player.dropItem(stack, false);
			if (itemEntity != null) {
				itemEntity.makeFakeItem();
			}

			player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((player.getRNG().nextFloat() - player.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
			player.inventoryContainer.detectAndSendChanges();
		} else {
			itemEntity = player.dropItem(stack, false);
			if (itemEntity != null) {
				itemEntity.setNoPickupDelay();
				itemEntity.setOwner(player.getName());
			}
		}
	}

	public static String replaceFormattingCodes(ITextComponent component) {

		String text = component.getUnformattedText();

		if(text.contains("§")) {
			
			for(int i = 0; i <= StringUtils.countMatches(text, "§"); i++) {
				text = text.substring(0, text.indexOf("§")) + text.substring(text.indexOf("§") + 2);
			}
		}

		return text;
	}
}
