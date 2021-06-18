package net.coolsimulations.SurvivalPlus.core.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.events.EntityAccessor;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerDeathEvent;
import net.coolsimulations.SurvivalPlus.api.events.SPPlayerJoinEvent;
import net.coolsimulations.SurvivalPlus.api.recipes.SPBasicTrade;
import net.coolsimulations.SurvivalPlus.api.recipes.SPTradeRecipes;
import net.coolsimulations.SurvivalPlus.api.recipes.SPTradeRecipes.VillagerLevel;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import net.minecraft.village.VillagerProfession;

public class SurvivalPlusEventHandler {

	public static void init() {

		onplayerLogin();
		coolsimDeath();
	}

	public static void onplayerLogin()
	{
		SPPlayerJoinEvent.EVENT.register((player, server) -> {

			CompoundTag entityData = ((EntityAccessor) player).getPersistentData();

			ServerAdvancementLoader manager = server.getAdvancementManager();
			Advancement install = manager.get(new Identifier(SPReference.MOD_ID, SPReference.MOD_ID + "/install"));

			boolean isDone = false;

			Timer timer = new Timer();

			if(install !=null && player.getAdvancementTracker().getProgress(install).isAnyObtained()) {
				isDone = true;
			}

			if(!entityData.getBoolean("sp.firstJoin") && !isDone && !SPConfig.disableThanks) {

				entityData.putBoolean("sp.firstJoin", true);

				if(!player.world.isClient) {

					TranslatableText installInfo = new TranslatableText("advancements.sp.install.display1");
					installInfo.getStyle().setColor(Formatting.GOLD);
					installInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("advancements.sp.install.display2")));
					installInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/survivalplus-fabric"));
					player.sendMessage(installInfo);

					TranslatableText discord = new TranslatableText("sp.discord.display1");
					discord.getStyle().setColor(Formatting.DARK_GREEN);
					discord.getStyle().setBold(true);

					for(int i = 0; i < SPReference.MOD_ADDON_NAMES.size(); i++) {

						TranslatableText formatted = new TranslatableText(SPReference.MOD_ADDON_NAMES.get(i));
						formatted.getStyle().setColor(Formatting.BLUE);
						formatted.getStyle().setBold(true);

						LiteralText gap = new LiteralText(", ");
						gap.getStyle().setColor(Formatting.WHITE);

						discord.append(formatted);
						if(i + 1 != SPReference.MOD_ADDON_NAMES.size()) {
							discord.append(gap);
						}
					}
					discord.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("sp.discord.display2")));
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
			return ActionResult.PASS;
		});
	}

	public static void villagerTrades() {

		SPTradeRecipes.addBasicRecipe(VillagerProfession.BUTCHER, VillagerLevel.getIDByLevel(3), new SPBasicTrade(2, new ItemStack(SPItems.beef_pie, 4), 16, 20));

		SPTradeRecipes.addBasicRecipe(VillagerProfession.FARMER, VillagerLevel.getIDByLevel(1), new SPBasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 2));
		SPTradeRecipes.addBasicRecipe(VillagerProfession.FARMER, VillagerLevel.getIDByLevel(2), new SPBasicTrade(new ItemStack(SPItems.raw_onion, 13), new ItemStack(Items.EMERALD), 16, 5, 0.05F));

		SPTradeRecipes.addBasicRecipe(VillagerProfession.ARMORER, VillagerLevel.getIDByLevel(2), new SPBasicTrade(6, new ItemStack(SPItems.bronze_chestplate), 12, 5, 0.2F));

		SPTradeRecipes.addBasicRecipe(VillagerProfession.ARMORER, VillagerLevel.getIDByLevel(2), new SPBasicTrade(new ItemStack(SPItems.bronze_ingot, 12), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
		SPTradeRecipes.addBasicRecipe(VillagerProfession.WEAPONSMITH, VillagerLevel.getIDByLevel(2), new SPBasicTrade(new ItemStack(SPItems.bronze_ingot, 12), new ItemStack(Items.EMERALD), 12, 5, 0.05F));
		SPTradeRecipes.addBasicRecipe(VillagerProfession.ARMORER, VillagerLevel.getIDByLevel(2), new SPBasicTrade(new ItemStack(SPItems.titanium_ingot, 18), new ItemStack(Items.EMERALD), 12, 10, 0.05F));
		SPTradeRecipes.addBasicRecipe(VillagerProfession.WEAPONSMITH, VillagerLevel.getIDByLevel(2), new SPBasicTrade(new ItemStack(SPItems.titanium_ingot, 18), new ItemStack(Items.EMERALD), 12, 10, 0.05F));

		SPTradeRecipes.addWanderingBasicRecipe(new SPBasicTrade(1, new ItemStack(SPItems.onion_seeds, 4), 12, 20));
	}

	public static void coolsimDeath() {
		SPPlayerDeathEvent.EVENT.register((player, source) -> {

			if(player.getUuid().equals(UUID.fromString("54481257-7b6d-4c8e-8aac-ca6f864e1412")) && source.getAttacker() instanceof ServerPlayerEntity) {

				ServerPlayerEntity attacker = (ServerPlayerEntity) source.getAttacker();
				ItemStack coolsimHead = getcoolsimHead();

				if(coolsimHead != null) {
					dropItem(coolsimHead, attacker);
				} else {
					TranslatableText error = new TranslatableText("sp.coolsim.error");
					error.getStyle().setColor(Formatting.RED);
					attacker.sendMessage(error);
				}
			}

			return ActionResult.PASS;
		});

	}

	public static ItemStack getcoolsimHead()
	{
		String texture = "eyJ0aW1lc3RhbXAiOjE1NzYxMTM5OTc5ODUsInByb2ZpbGVJZCI6IjU0NDgxMjU3N2I2ZDRjOGU4YWFjY2E2Zjg2NGUxNDEyIiwicHJvZmlsZU5hbWUiOiJjb29sc2ltIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdmMDkwM2QxOGMyZTE4YmQzYzBiMDk5YmIzZGFkNmVjYTQ2ZDBjMzdkZjJkM2FlMjljYzAwOWYwN2I5OTM3NmYifX19";
		String id = new UUID(texture.hashCode(), texture.hashCode()).toString();

		ItemStack playerhead = new ItemStack(Items.PLAYER_HEAD);

		TranslatableText headName = new TranslatableText("block.minecraft.player_head.named", new Object[] {"coolsim"});
		headName.getStyle().setItalic(true);
		CompoundTag skullOwner = new CompoundTag();
		skullOwner.putString("Id", id);
		CompoundTag properties = new CompoundTag();
		ListTag textures = new ListTag();
		CompoundTag tex = new CompoundTag();
		tex.putString("Value", texture);
		textures.add(tex);
		properties.put("textures", textures);
		skullOwner.put("Properties", properties);
		playerhead.putSubTag("SkullOwner", skullOwner);
		playerhead.setCustomName(headName);

		return playerhead;
	}

	public static void dropItem(ItemStack stack, PlayerEntity player) {

		boolean bl = player.inventory.insertStack(stack);
		ItemEntity itemEntity;
		if (bl && stack.isEmpty()) {
			stack.setCount(1);
			itemEntity = player.dropItem(stack, false);
			if (itemEntity != null) {
				itemEntity.setDespawnImmediately();
			}

			player.world.playSound((PlayerEntity)null, player.x, player.y, player.z, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
			player.playerContainer.sendContentUpdates();
		} else {
			itemEntity = player.dropItem(stack, false);
			if (itemEntity != null) {
				itemEntity.resetPickupDelay();
				itemEntity.setOwner(player.getUuid());
			}
		}
	}
	
	public static String replaceFormattingCodes(Text message) {

		String text = message.asFormattedString();

		if(text.contains("§")) {
			System.out.println(text);
			for(int i = 0; i <= StringUtils.countMatches(text, "§"); i++) {
				text = text.substring(0, text.indexOf("§")) + text.substring(text.indexOf("§") + 2);
			}
		}

		return text;
	}


}
