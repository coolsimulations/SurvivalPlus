package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class SurvivalPlusArmor {

	public static final DeferredRegister<Item> ITEMS_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_RUBBER_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_BAMBOO_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);

	private static final RegistryObject<Item> bronze_helmet = ITEMS_ARMOR.register("bronze_helmet", () -> new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> bronze_chestplate = ITEMS_ARMOR.register("bronze_chestplate", () -> new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> bronze_leggings = ITEMS_ARMOR.register("bronze_leggings", () -> new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> bronze_boots = ITEMS_ARMOR.register("bronze_boots", () -> new SPItemArmor(SPArmorMaterial.bronzeArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> stone_helmet = ITEMS_ARMOR.register("stone_helmet", () -> new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> stone_chestplate = ITEMS_ARMOR.register("stone_chestplate", () -> new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> stone_leggings = ITEMS_ARMOR.register("stone_leggings", () -> new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> stone_boots = ITEMS_ARMOR.register("stone_boots", () -> new SPItemArmor(SPArmorMaterial.stoneArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> titanium_helmet = ITEMS_ARMOR.register("titanium_helmet", () -> new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> titanium_chestplate = ITEMS_ARMOR.register("titanium_chestplate", () -> new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> titanium_leggings = ITEMS_ARMOR.register("titanium_leggings", () -> new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> titanium_boots = ITEMS_ARMOR.register("titanium_boots", () -> new SPItemArmor(SPArmorMaterial.titaniumArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> oak_helmet = ITEMS_ARMOR.register("oak_helmet", () -> new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> oak_chestplate = ITEMS_ARMOR.register("oak_chestplate", () -> new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> oak_leggings = ITEMS_ARMOR.register("oak_leggings", () -> new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> oak_boots = ITEMS_ARMOR.register("oak_boots", () -> new SPItemArmor(SPArmorMaterial.oakArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> spruce_helmet = ITEMS_ARMOR.register("spruce_helmet", () -> new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> spruce_chestplate = ITEMS_ARMOR.register("spruce_chestplate", () -> new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> spruce_leggings = ITEMS_ARMOR.register("spruce_leggings", () -> new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> spruce_boots = ITEMS_ARMOR.register("spruce_boots", () -> new SPItemArmor(SPArmorMaterial.spruceArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> birch_helmet = ITEMS_ARMOR.register("birch_helmet", () -> new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> birch_chestplate = ITEMS_ARMOR.register("birch_chestplate", () -> new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> birch_leggings = ITEMS_ARMOR.register("birch_leggings", () -> new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> birch_boots = ITEMS_ARMOR.register("birch_boots", () -> new SPItemArmor(SPArmorMaterial.birchArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> jungle_helmet = ITEMS_ARMOR.register("jungle_helmet", () -> new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> jungle_chestplate = ITEMS_ARMOR.register("jungle_chestplate", () -> new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> jungle_leggings = ITEMS_ARMOR.register("jungle_leggings", () -> new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> jungle_boots = ITEMS_ARMOR.register("jungle_boots", () -> new SPItemArmor(SPArmorMaterial.jungleArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> acacia_helmet = ITEMS_ARMOR.register("acacia_helmet", () -> new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> acacia_chestplate = ITEMS_ARMOR.register("acacia_chestplate", () -> new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> acacia_leggings = ITEMS_ARMOR.register("acacia_leggings", () -> new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> acacia_boots = ITEMS_ARMOR.register("acacia_boots", () -> new SPItemArmor(SPArmorMaterial.acaciaArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> dark_oak_helmet = ITEMS_ARMOR.register("dark_oak_helmet", () -> new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> dark_oak_chestplate = ITEMS_ARMOR.register("dark_oak_chestplate", () -> new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> dark_oak_leggings = ITEMS_ARMOR.register("dark_oak_leggings", () -> new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> dark_oak_boots = ITEMS_ARMOR.register("dark_oak_boots", () -> new SPItemArmor(SPArmorMaterial.darkOakArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> crimson_helmet = ITEMS_ARMOR.register("crimson_helmet", () -> new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> crimson_chestplate = ITEMS_ARMOR.register("crimson_chestplate", () -> new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> crimson_leggings = ITEMS_ARMOR.register("crimson_leggings", () -> new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> crimson_boots = ITEMS_ARMOR.register("crimson_boots", () -> new SPItemArmor(SPArmorMaterial.crimsonArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> warped_helmet = ITEMS_ARMOR.register("warped_helmet", () -> new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> warped_chestplate = ITEMS_ARMOR.register("warped_chestplate", () -> new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> warped_leggings = ITEMS_ARMOR.register("warped_leggings", () -> new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> warped_boots = ITEMS_ARMOR.register("warped_boots", () -> new SPItemArmor(SPArmorMaterial.warpedArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> mangrove_helmet = ITEMS_ARMOR.register("mangrove_helmet", () -> new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> mangrove_chestplate = ITEMS_ARMOR.register("mangrove_chestplate", () -> new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> mangrove_leggings = ITEMS_ARMOR.register("mangrove_leggings", () -> new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> mangrove_boots = ITEMS_ARMOR.register("mangrove_boots", () -> new SPItemArmor(SPArmorMaterial.mangroveArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> rubber_helmet = ITEMS_RUBBER_ARMOR.register("rubber_helmet", () -> new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> rubber_chestplate = ITEMS_RUBBER_ARMOR.register("rubber_chestplate", () -> new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> rubber_leggings = ITEMS_RUBBER_ARMOR.register("rubber_leggings", () -> new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> rubber_boots = ITEMS_RUBBER_ARMOR.register("rubber_boots", () -> new SPItemArmor(SPArmorMaterial.rubberArmorMaterial, Type.BOOTS));

	private static final RegistryObject<Item> bamboo_helmet = ITEMS_BAMBOO_ARMOR.register("bamboo_helmet", () -> new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> bamboo_chestplate = ITEMS_BAMBOO_ARMOR.register("bamboo_chestplate", () -> new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> bamboo_leggings = ITEMS_BAMBOO_ARMOR.register("bamboo_leggings", () -> new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> bamboo_boots = ITEMS_BAMBOO_ARMOR.register("bamboo_boots", () -> new SPItemArmor(SPArmorMaterial.bambooArmorMaterial, Type.BOOTS));

	public static void init(){

		SPItems.bronze = NonNullList.create();
		SPItems.bronze.add(0, new ItemStack(bronze_helmet.get()));
		SPItems.bronze.add(1, new ItemStack(bronze_chestplate.get()));
		SPItems.bronze.add(2, new ItemStack(bronze_leggings.get()));
		SPItems.bronze.add(3, new ItemStack(bronze_boots.get()));

		SPItems.stone = NonNullList.create();
		SPItems.stone.add(0, new ItemStack(stone_helmet.get()));
		SPItems.stone.add(1, new ItemStack(stone_chestplate.get()));
		SPItems.stone.add(2, new ItemStack(stone_leggings.get()));
		SPItems.stone.add(3, new ItemStack(stone_boots.get()));

		SPItems.titanium = NonNullList.create();
		SPItems.titanium.add(0, new ItemStack(titanium_helmet.get()));
		SPItems.titanium.add(1, new ItemStack(titanium_chestplate.get()));
		SPItems.titanium.add(2, new ItemStack(titanium_leggings.get()));
		SPItems.titanium.add(3, new ItemStack(titanium_boots.get()));

		SPItems.oak = NonNullList.create();
		SPItems.oak.add(0, new ItemStack(oak_helmet.get()));
		SPItems.oak.add(1, new ItemStack(oak_chestplate.get()));
		SPItems.oak.add(2, new ItemStack(oak_leggings.get()));
		SPItems.oak.add(3, new ItemStack(oak_boots.get()));

		SPItems.spruce = NonNullList.create();
		SPItems.spruce.add(0, new ItemStack(spruce_helmet.get()));
		SPItems.spruce.add(1, new ItemStack(spruce_chestplate.get()));
		SPItems.spruce.add(2, new ItemStack(spruce_leggings.get()));
		SPItems.spruce.add(3, new ItemStack(spruce_boots.get()));

		SPItems.birch = NonNullList.create();
		SPItems.birch.add(0, new ItemStack(birch_helmet.get()));
		SPItems.birch.add(1, new ItemStack(birch_chestplate.get()));
		SPItems.birch.add(2, new ItemStack(birch_leggings.get()));
		SPItems.birch.add(3, new ItemStack(birch_boots.get()));

		SPItems.jungle = NonNullList.create();
		SPItems.jungle.add(0, new ItemStack(jungle_helmet.get()));
		SPItems.jungle.add(1, new ItemStack(jungle_chestplate.get()));
		SPItems.jungle.add(2, new ItemStack(jungle_leggings.get()));
		SPItems.jungle.add(3, new ItemStack(jungle_boots.get()));

		SPItems.acacia = NonNullList.create();
		SPItems.acacia.add(0, new ItemStack(acacia_helmet.get()));
		SPItems.acacia.add(1, new ItemStack(acacia_chestplate.get()));
		SPItems.acacia.add(2, new ItemStack(acacia_leggings.get()));
		SPItems.acacia.add(3, new ItemStack(acacia_boots.get()));

		SPItems.dark_oak = NonNullList.create();
		SPItems.dark_oak.add(0, new ItemStack(dark_oak_helmet.get()));
		SPItems.dark_oak.add(1, new ItemStack(dark_oak_chestplate.get()));
		SPItems.dark_oak.add(2, new ItemStack(dark_oak_leggings.get()));
		SPItems.dark_oak.add(3, new ItemStack(dark_oak_boots.get()));

		SPItems.crimson = NonNullList.create();
		SPItems.crimson.add(0, new ItemStack(crimson_helmet.get()));
		SPItems.crimson.add(1, new ItemStack(crimson_chestplate.get()));
		SPItems.crimson.add(2, new ItemStack(crimson_leggings.get()));
		SPItems.crimson.add(3, new ItemStack(crimson_boots.get()));

		SPItems.warped = NonNullList.create();
		SPItems.warped.add(0, new ItemStack(warped_helmet.get()));
		SPItems.warped.add(1, new ItemStack(warped_chestplate.get()));
		SPItems.warped.add(2, new ItemStack(warped_leggings.get()));
		SPItems.warped.add(3, new ItemStack(warped_boots.get()));

		SPItems.mangrove = NonNullList.create();
		SPItems.mangrove.add(0, new ItemStack(mangrove_helmet.get()));
		SPItems.mangrove.add(1, new ItemStack(mangrove_chestplate.get()));
		SPItems.mangrove.add(2, new ItemStack(mangrove_leggings.get()));
		SPItems.mangrove.add(3, new ItemStack(mangrove_boots.get()));

		if (SPCompatibilityManager.isIc2Loaded()) {

			SPItems.rubber = NonNullList.create();
			SPItems.rubber.add(0, new ItemStack(rubber_helmet.get()));
			SPItems.rubber.add(1, new ItemStack(rubber_chestplate.get()));
			SPItems.rubber.add(2, new ItemStack(rubber_leggings.get()));
			SPItems.rubber.add(3, new ItemStack(rubber_boots.get()));

		}

		if (SPCompatibilityManager.isBambooModsLoaded()) {

			SPItems.bamboo = NonNullList.create();
			SPItems.bamboo.add(0, new ItemStack(bamboo_helmet.get()));
			SPItems.bamboo.add(1, new ItemStack(bamboo_chestplate.get()));
			SPItems.bamboo.add(2, new ItemStack(bamboo_leggings.get()));
			SPItems.bamboo.add(3, new ItemStack(bamboo_boots.get()));
		}

	}

}
