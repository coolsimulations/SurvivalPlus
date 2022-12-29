package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SPItems {
	
	/**
	 * These are the normal Items referred to in SurvivalPlusItems
	 */
	public static final RegistryObject<Item> tin_ingot = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "tin_ingot"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_ingot = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_ingot"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_nugget = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_nugget"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_ingot = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_ingot"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_nugget = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_nugget"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> onion_seeds = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "onion_seeds"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> charcoal_bucket = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "charcoal_bucket"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> paper_cup = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "paper_cup"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> raw_tin = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "raw_tin"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> raw_titanium = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "raw_titanium"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ruby_shard = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ruby_shard"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pearl = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pearl"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> topaz_shard = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "topaz_shard"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sapphire_shard = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sapphire_shard"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> spinel_shard = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "spinel_shard"), ForgeRegistries.ITEMS);
	
	/**
	 * These are the special block items referred to in SurvivalPlusItems
	 */
	public static final RegistryObject<Item> gem_staff = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "gem_staff"), ForgeRegistries.ITEMS);
	
	/**
	 * These are the IndustrialCraft 2, SimpleGrinders and Silent Mechanisms Items referred to in SurvivalPlusItems
	 */
	public static final RegistryObject<Item> titanium_dust = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_dust"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_dense_plate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_dense_plate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> tin_dust = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "tin_dust"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_chunks = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_chunks"), ForgeRegistries.ITEMS);
	
	/**
	 * These are the food Items referred to in SurvivalPlusFood
	 */
	public static final RegistryObject<Item> apple_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "apple_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> beef_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "beef_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pork_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pork_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> chicken_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "chicken_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mutton_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mutton_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> rabbit_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "rabbit_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> vegetable_pie = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "vegetable_pie"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> raw_onion = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "raw_onion"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> onion_soup = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "onion_soup"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fried_egg = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fried_egg"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> roast_carrot = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "roast_carrot"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cheese = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cheese"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cheese_bread = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cheese_bread"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> melted_cheese_bread = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "melted_cheese_bread"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cupcake = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cupcake"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cheese_cupcake = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cheese_cupcake"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sponge_cupcake = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sponge_cupcake"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> baked_apple = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "baked_apple"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fried_onion = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fried_onion"), ForgeRegistries.ITEMS);
	
	/**
	 * These are the tool Items referred to in SurvivalPlusTools along with the corresponding ToolMaterial
	 */
	public static final RegistryObject<Item> bronze_pickaxe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_pickaxe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_axe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_axe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_shovel = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_shovel"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_hoe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_hoe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_sword = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_sword"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_shears = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_shears"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_shield = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_shield"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_pickaxe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_pickaxe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_axe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_axe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_shovel = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_shovel"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_hoe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_hoe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_sword = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_sword"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_shears = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_shears"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_shield = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_shield"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_lumberaxe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_lumberaxe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_lumberaxe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_lumberaxe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> desh_lumberaxe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "desh_lumberaxe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> steel_lumberaxe = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "steel_lumberaxe"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_knife = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_knife"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_mattock = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_mattock"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_saw = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_saw"), ForgeRegistries.ITEMS);
	
	/**
	 * These are the armor Items referred to in SurvivalPlusArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> bronze_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bronze_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bronze_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial bronzeArmorMaterial;
	public static NonNullList<ItemStack> bronze;
	public static final RegistryObject<Item> stone_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "stone_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> stone_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "stone_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> stone_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "stone_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> stone_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "stone_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial stoneArmorMaterial;
	public static NonNullList<ItemStack> stone;
	public static final RegistryObject<Item> titanium_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> titanium_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "titanium_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial titaniumArmorMaterial;
	public static NonNullList<ItemStack> titanium;
	public static final RegistryObject<Item> oak_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "oak_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> oak_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "oak_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> oak_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "oak_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> oak_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "oak_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial oakArmorMaterial;
	public static NonNullList<ItemStack> oak;
	public static final RegistryObject<Item> spruce_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "spruce_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> spruce_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "spruce_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> spruce_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "spruce_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> spruce_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "spruce_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial spruceArmorMaterial;
	public static NonNullList<ItemStack> spruce;
	public static final RegistryObject<Item> birch_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "birch_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> birch_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "birch_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> birch_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "birch_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> birch_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "birch_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial birchArmorMaterial;
	public static NonNullList<ItemStack> birch;
	public static final RegistryObject<Item> jungle_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jungle_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> jungle_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jungle_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> jungle_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jungle_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> jungle_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jungle_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial jungleArmorMaterial;
	public static NonNullList<ItemStack> jungle;
	public static final RegistryObject<Item> acacia_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "acacia_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> acacia_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "acacia_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> acacia_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "acacia_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> acacia_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "acacia_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial acaciaArmorMaterial;
	public static NonNullList<ItemStack> acacia;
	public static final RegistryObject<Item> dark_oak_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dark_oak_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> dark_oak_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dark_oak_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> dark_oak_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dark_oak_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> dark_oak_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dark_oak_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial darkOakArmorMaterial;
	public static NonNullList<ItemStack> dark_oak;
	public static final RegistryObject<Item> crimson_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "crimson_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> crimson_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "crimson_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> crimson_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "crimson_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> crimson_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "crimson_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial crimsonArmorMaterial;
	public static NonNullList<ItemStack> crimson;
	public static final RegistryObject<Item> warped_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "warped_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> warped_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "warped_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> warped_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "warped_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> warped_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "warped_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial warpedArmorMaterial;
	public static NonNullList<ItemStack> warped;
	public static final RegistryObject<Item> mangrove_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mangrove_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mangrove_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mangrove_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mangrove_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mangrove_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mangrove_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mangrove_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial mangroveArmorMaterial;
	public static NonNullList<ItemStack> mangrove;
	
	/**
	 * These are the bamboo armor Items referred to in SurvivalPlusArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> bamboo_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bamboo_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bamboo_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bamboo_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bamboo_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bamboo_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> bamboo_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "bamboo_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial bambooArmorMaterial;
	public static NonNullList<ItemStack> bamboo;
	
	/**
	 * These are the Traverse armor Items referred to in TraverseArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> fir_helmet_traverse = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_helmet_traverse"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fir_chestplate_traverse = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_chestplate_traverse"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fir_leggings_traverse = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_leggings_traverse"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fir_boots_traverse = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_boots_traverse"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial firTraverseArmorMaterial;
	public static NonNullList<ItemStack> fir_traverse;
	
	/**
	 * These are the rubber armor Items referred to in SurvivalPlusArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> rubber_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "rubber_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> rubber_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "rubber_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> rubber_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "rubber_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> rubber_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "rubber_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial rubberArmorMaterial;
	public static NonNullList<ItemStack> rubber;

	/**
	 * These are the Biomes O' Plenty armor Items referred to in BOPArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> cherry_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cherry_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cherry_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cherry_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial cherryArmorMaterial;
	public static NonNullList<ItemStack> cherry;
	public static final RegistryObject<Item> dead_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dead_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> dead_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dead_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> dead_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dead_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> dead_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "dead_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial deadArmorMaterial;
	public static NonNullList<ItemStack> dead;
	public static final RegistryObject<Item> ebony_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ebony_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ebony_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ebony_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial ebonyArmorMaterial;
	public static NonNullList<ItemStack> ebony;
	public static final RegistryObject<Item> ethereal_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ethereal_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ethereal_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ethereal_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ethereal_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ethereal_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ethereal_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ethereal_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial etherealArmorMaterial;
	public static NonNullList<ItemStack> ethereal;
	public static final RegistryObject<Item> eucalyptus_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "eucalyptus_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> eucalyptus_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "eucalyptus_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> eucalyptus_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "eucalyptus_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> eucalyptus_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "eucalyptus_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial eucalyptusArmorMaterial;
	public static NonNullList<ItemStack> eucalyptus;
	public static final RegistryObject<Item> fir_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fir_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fir_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> fir_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "fir_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial firArmorMaterial;
	public static NonNullList<ItemStack> fir;
	public static final RegistryObject<Item> hellbark_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "hellbark_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> hellbark_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "hellbark_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> hellbark_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "hellbark_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> hellbark_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "hellbark_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial hellbarkArmorMaterial;
	public static NonNullList<ItemStack> hellbark;
	public static final RegistryObject<Item> jacaranda_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jacaranda_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> jacaranda_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jacaranda_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> jacaranda_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jacaranda_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> jacaranda_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "jacaranda_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial jacarandaArmorMaterial;
	public static NonNullList<ItemStack> jacaranda;
	public static final RegistryObject<Item> magic_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "magic_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> magic_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "magic_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> magic_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "magic_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> magic_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "magic_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial magicArmorMaterial;
	public static NonNullList<ItemStack> magic;
	public static final RegistryObject<Item> mahogany_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahogany_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahogany_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahogany_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial mahoganyArmorMaterial;
	public static NonNullList<ItemStack> mahogany;
	public static final RegistryObject<Item> palm_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> palm_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> palm_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> palm_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial palmArmorMaterial;
	public static NonNullList<ItemStack> palm;
	public static final RegistryObject<Item> pine_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pine_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pine_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pine_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial pineArmorMaterial;
	public static NonNullList<ItemStack> pine;
	public static final RegistryObject<Item> redwood_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "redwood_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> redwood_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "redwood_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> redwood_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "redwood_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> redwood_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "redwood_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial redwoodArmorMaterial;
	public static NonNullList<ItemStack> redwood;
	public static final RegistryObject<Item> sacred_oak_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sacred_oak_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sacred_oak_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sacred_oak_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sacred_oak_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sacred_oak_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sacred_oak_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sacred_oak_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial sacredOakArmorMaterial;
	public static NonNullList<ItemStack> sacred_oak;
	public static final RegistryObject<Item> umbran_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "umbran_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> umbran_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "umbran_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> umbran_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "umbran_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> umbran_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "umbran_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial umbranArmorMaterial;
	public static NonNullList<ItemStack> umbran;
	public static final RegistryObject<Item> willow_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> willow_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> willow_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> willow_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial willowArmorMaterial;
	public static NonNullList<ItemStack> willow;
	
	/**
	 * These are the Forestry armor Items referred to in ForestryArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> desert_acacia_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "desert_acacia_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> desert_acacia_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "desert_acacia_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> desert_acacia_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "desert_acacia_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> desert_acacia_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "desert_acacia_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial desertAcaciaArmorMaterial;
	public static NonNullList<ItemStack> desert_acacia;
	public static final RegistryObject<Item> balsa_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "balsa_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> balsa_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "balsa_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> balsa_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "balsa_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> balsa_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "balsa_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial balsaArmorMaterial;
	public static NonNullList<ItemStack> balsa;
	public static final RegistryObject<Item> baobab_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "baobab_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> baobab_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "baobab_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> baobab_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "baobab_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> baobab_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "baobab_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial baobabArmorMaterial;
	public static NonNullList<ItemStack> baobab;
	public static final RegistryObject<Item> cherry_helmet_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_helmet_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cherry_chestplate_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_chestplate_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cherry_leggings_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_leggings_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cherry_boots_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cherry_boots_forestry"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial cherryForestryArmorMaterial;
	public static NonNullList<ItemStack> cherry_forestry;
	public static final RegistryObject<Item> chestnut_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "chestnut_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> chestnut_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "chestnut_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> chestnut_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "chestnut_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> chestnut_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "chestnut_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial chestnutArmorMaterial;
	public static NonNullList<ItemStack> chestnut;
	public static final RegistryObject<Item> citrus_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "citrus_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> citrus_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "citrus_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> citrus_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "citrus_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> citrus_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "citrus_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial citrusArmorMaterial;
	public static NonNullList<ItemStack> citrus;
	public static final RegistryObject<Item> cocobolo_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cocobolo_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cocobolo_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cocobolo_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cocobolo_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cocobolo_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> cocobolo_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "cocobolo_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial cocoboloArmorMaterial;
	public static NonNullList<ItemStack> cocobolo;
	public static final RegistryObject<Item> ebony_helmet_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_helmet_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ebony_chestplate_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_chestplate_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ebony_leggings_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_leggings_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ebony_boots_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ebony_boots_forestry"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial ebonyForestryArmorMaterial;
	public static NonNullList<ItemStack> ebony_forestry;
	public static final RegistryObject<Item> giant_sequoia_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "giant_sequoia_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> giant_sequoia_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "giant_sequoia_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> giant_sequoia_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "giant_sequoia_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> giant_sequoia_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "giant_sequoia_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial giantSequoiaArmorMaterial;
	public static NonNullList<ItemStack> giant_sequoia;
	public static final RegistryObject<Item> greenheart_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "greenheart_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> greenheart_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "greenheart_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> greenheart_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "greenheart_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> greenheart_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "greenheart_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial greenheartArmorMaterial;
	public static NonNullList<ItemStack> greenheart;
	public static final RegistryObject<Item> ipe_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ipe_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ipe_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ipe_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ipe_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ipe_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> ipe_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "ipe_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial ipeArmorMaterial;
	public static NonNullList<ItemStack> ipe;
	public static final RegistryObject<Item> kapok_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "kapok_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> kapok_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "kapok_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> kapok_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "kapok_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> kapok_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "kapok_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial kapokArmorMaterial;
	public static NonNullList<ItemStack> kapok;
	public static final RegistryObject<Item> larch_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "larch_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> larch_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "larch_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> larch_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "larch_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> larch_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "larch_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial larchArmorMaterial;
	public static NonNullList<ItemStack> larch;
	public static final RegistryObject<Item> lime_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "lime_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> lime_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "lime_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> lime_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "lime_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> lime_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "lime_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial limeArmorMaterial;
	public static NonNullList<ItemStack> lime;
	public static final RegistryObject<Item> mahoe_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahoe_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahoe_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahoe_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahoe_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahoe_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahoe_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahoe_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial mahoeArmorMaterial;
	public static NonNullList<ItemStack> mahoe;
	public static final RegistryObject<Item> mahogany_helmet_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_helmet_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahogany_chestplate_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_chestplate_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahogany_leggings_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_leggings_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> mahogany_boots_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "mahogany_boots_forestry"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial mahoganyForestryArmorMaterial;
	public static NonNullList<ItemStack> mahogany_forestry;
	public static final RegistryObject<Item> maple_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "maple_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> maple_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "maple_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> maple_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "maple_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> maple_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "maple_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial mapleArmorMaterial;
	public static NonNullList<ItemStack> maple;
	public static final RegistryObject<Item> padauk_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "padauk_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> padauk_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "padauk_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> padauk_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "padauk_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> padauk_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "padauk_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial padaukArmorMaterial;
	public static NonNullList<ItemStack> padauk;
	public static final RegistryObject<Item> palm_helmet_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_helmet_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> palm_chestplate_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_chestplate_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> palm_leggings_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_leggings_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> palm_boots_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "palm_boots_forestry"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial palmForestryArmorMaterial;
	public static NonNullList<ItemStack> palm_forestry;
	public static final RegistryObject<Item> papaya_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "papaya_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> papaya_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "papaya_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> papaya_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "papaya_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> papaya_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "papaya_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial papayaArmorMaterial;
	public static NonNullList<ItemStack> papaya;
	public static final RegistryObject<Item> pine_helmet_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_helmet_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pine_chestplate_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_chestplate_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pine_leggings_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_leggings_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> pine_boots_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "pine_boots_forestry"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial pineForestryArmorMaterial;
	public static NonNullList<ItemStack> pine_forestry;
	public static final RegistryObject<Item> plum_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "plum_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> plum_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "plum_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> plum_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "plum_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> plum_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "plum_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial plumArmorMaterial;
	public static NonNullList<ItemStack> plum;
	public static final RegistryObject<Item> poplar_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "poplar_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> poplar_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "poplar_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> poplar_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "poplar_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> poplar_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "poplar_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial poplarArmorMaterial;
	public static NonNullList<ItemStack> poplar;
	public static final RegistryObject<Item> sequoia_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sequoia_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sequoia_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sequoia_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sequoia_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sequoia_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> sequoia_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "sequoia_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial sequoiaArmorMaterial;
	public static NonNullList<ItemStack> sequoia;
	public static final RegistryObject<Item> teak_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "teak_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> teak_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "teak_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> teak_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "teak_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> teak_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "teak_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial teakArmorMaterial;
	public static NonNullList<ItemStack> teak;
	public static final RegistryObject<Item> walnut_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "walnut_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> walnut_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "walnut_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> walnut_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "walnut_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> walnut_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "walnut_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial walnutArmorMaterial;
	public static NonNullList<ItemStack> walnut;
	public static final RegistryObject<Item> wenge_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "wenge_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> wenge_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "wenge_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> wenge_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "wenge_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> wenge_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "wenge_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial wengeArmorMaterial;
	public static NonNullList<ItemStack> wenge;
	public static final RegistryObject<Item> willow_helmet_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_helmet_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> willow_chestplate_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_chestplate_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> willow_leggings_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_leggings_forestry"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> willow_boots_forestry = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "willow_boots_forestry"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial willowForestryArmorMaterial;
	public static NonNullList<ItemStack> willow_forestry;
	public static final RegistryObject<Item> zebrawood_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "zebrawood_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> zebrawood_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "zebrawood_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> zebrawood_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "zebrawood_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> zebrawood_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "zebrawood_boots"), ForgeRegistries.ITEMS);
	//public static final RegistryObject<Item>Armor.ArmorMaterial zebrawoodArmorMaterial;
	public static NonNullList<ItemStack> zebrawood;
	
	/**
	 * These are the Aether armor Items referred to in AetherArmor along with the corresponding ArmorMaterial and Armor ItemStack List
	 */
	public static final RegistryObject<Item> skyroot_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "skyroot_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> skyroot_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "skyroot_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> skyroot_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "skyroot_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> skyroot_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "skyroot_boots"), ForgeRegistries.ITEMS);
	//public static ItemArmor.ArmorMaterial skyrootArmorMaterial;
	public static NonNullList<ItemStack> skyroot;
	public static final RegistryObject<Item> golden_oak_helmet = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "golden_oak_helmet"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> golden_oak_chestplate = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "golden_oak_chestplate"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> golden_oak_leggings = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "golden_oak_leggings"), ForgeRegistries.ITEMS);
	public static final RegistryObject<Item> golden_oak_boots = RegistryObject.create(new ResourceLocation(SPReference.MOD_ID, "golden_oak_boots"), ForgeRegistries.ITEMS);
	//public static ItemArmor.ArmorMaterial goldenOakArmorMaterial;
	public static NonNullList<ItemStack> golden_oak;
	
}