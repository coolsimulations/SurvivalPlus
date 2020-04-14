package net.coolsimulations.SurvivalPlus.core.util;

import java.util.UUID;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.core.SurvivalPlus;
import net.coolsimulations.SurvivalPlus.core.config.SurvivalPlusConfig;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusArmor;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusBlocks;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusFood;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusItems;
import net.coolsimulations.SurvivalPlus.core.init.SurvivalPlusTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.items.ItemHandlerHelper;
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
        		
        	}
		}
		
		if(SurvivalPlusUpdateHandler.isOld == true && SPConfig.disableUpdateCheck == false) {
        	player.sendMessage(SurvivalPlusUpdateHandler.updateInfo);
        	player.sendMessage(SurvivalPlusUpdateHandler.updateVersionInfo);
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
		
		if(!SPConfig.enableSponge) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "sponge"));
		}
		
		if(SPCompatibilityManager.isIc2Loaded()) {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "bronze_ingot_alt2"));
		} else {
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt1"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt2"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt3"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt4"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt5"));
			modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "campfire_rubber_alt6"));
		}
		
		if(SPCompatibilityManager.isBopLoaded()) {
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BOP_MODID + ":" + "white_dye_from_lily_of_the_valley"));
			modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BOP_MODID + ":" + "white_dye_from_white_anemone"));
			if(!SPConfig.enableReplaceBOPRecipe) {
				modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "terrestrial_artifact"));
				modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "terrestrial_artifact_ore_gc"));
			} else {
				modRegistry.remove(new ResourceLocation(SPCompatibilityManager.BOP_MODID + ":" + "terrestrial_artifact"));
				modRegistry.remove(new ResourceLocation(SPReference.MOD_ID + ":" + "terrestrial_artifact_gc"));
			}
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
	public void coolsimChat(ServerChatEvent event) {
		
		TextComponentTranslation coolsim = new TextComponentTranslation("sp.coolsim.creator");
		coolsim.getStyle().setColor(TextFormatting.GOLD);
		
		if(event.getUsername().equals("coolsim")) {
			if(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(event.getUsername()) != null)
				event.setComponent(new TextComponentString(coolsim.getFormattedText() + " <" + FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(event.getUsername()).getDisplayName().getFormattedText() + "> " + event.getMessage()));
		}
	}
	
	@SubscribeEvent
	public void coolsimReceivedChat(ClientChatReceivedEvent event) {
		
		TextComponentTranslation coolsim = new TextComponentTranslation("sp.coolsim.creator");
		coolsim.getStyle().setColor(TextFormatting.GOLD);
		
		TextComponentTranslation playerJoined = new TextComponentTranslation("multiplayer.player.joined", new Object[] {"coolsim"});
		playerJoined.getStyle().setColor(TextFormatting.YELLOW);
		
		TextComponentTranslation playerLeft = new TextComponentTranslation("multiplayer.player.left", new Object[] {"coolsim"});
		playerLeft.getStyle().setColor(TextFormatting.YELLOW);
		
		TextComponentTranslation coolsimJoined = new TextComponentTranslation("sp.coolsim.joined");
		coolsimJoined.getStyle().setColor(TextFormatting.YELLOW);
		
		TextComponentTranslation coolsimLeft = new TextComponentTranslation("sp.coolsim.left");
		coolsimLeft.getStyle().setColor(TextFormatting.YELLOW);
		
		if(event.getMessage().getFormattedText().equals(playerJoined.getFormattedText())) {
			event.setMessage(coolsimJoined);
		}
		
		if(event.getMessage().getFormattedText().equals(playerLeft.getFormattedText())) {
			event.setMessage(coolsimLeft);
		}
		
		if(event.getMessage().getUnformattedText().startsWith("[coolsim]")) {
			event.setMessage(new TextComponentString(event.getMessage().getFormattedText().replaceFirst("\\[", coolsim.getFormattedText() + " [")));
		}
	}

	@SubscribeEvent
	public void coolsimDeath(LivingDeathEvent event) {

		if(event.getEntity() instanceof EntityPlayer && event.getEntity().getDisplayName().getUnformattedText().equals("coolsim") && event.getSource().getTrueSource() instanceof EntityPlayer) {

			EntityPlayerMP attacker = (EntityPlayerMP) event.getSource().getTrueSource();
			ItemStack coolsimHead = getcoolsimHead();

			if(coolsimHead != null) {
				ItemHandlerHelper.giveItemToPlayer(attacker, coolsimHead);
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
}
