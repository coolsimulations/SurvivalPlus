package net.coolsimulations.SurvivalPlus.core.init;

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
public class ForestryArmor {
	
	public static final DeferredRegister<Item> ITEMS_FORESTRY_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> desert_acacia_helmet = ITEMS_FORESTRY_ARMOR.register("desert_acacia_helmet", () -> new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> desert_acacia_chestplate = ITEMS_FORESTRY_ARMOR.register("desert_acacia_chestplate", () -> new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> desert_acacia_leggings = ITEMS_FORESTRY_ARMOR.register("desert_acacia_leggings", () -> new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> desert_acacia_boots = ITEMS_FORESTRY_ARMOR.register("desert_acacia_boots", () -> new SPItemArmor(SPArmorMaterial.desertAcaciaArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> balsa_helmet = ITEMS_FORESTRY_ARMOR.register("balsa_helmet", () -> new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> balsa_chestplate = ITEMS_FORESTRY_ARMOR.register("balsa_chestplate", () -> new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> balsa_leggings = ITEMS_FORESTRY_ARMOR.register("balsa_leggings", () -> new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> balsa_boots = ITEMS_FORESTRY_ARMOR.register("balsa_boots", () -> new SPItemArmor(SPArmorMaterial.balsaArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> baobab_helmet = ITEMS_FORESTRY_ARMOR.register("baobab_helmet", () -> new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> baobab_chestplate = ITEMS_FORESTRY_ARMOR.register("baobab_chestplate", () -> new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> baobab_leggings = ITEMS_FORESTRY_ARMOR.register("baobab_leggings", () -> new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> baobab_boots = ITEMS_FORESTRY_ARMOR.register("baobab_boots", () -> new SPItemArmor(SPArmorMaterial.baobabArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> cherry_helmet_forestry = ITEMS_FORESTRY_ARMOR.register("cherry_helmet_forestry", () -> new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> cherry_chestplate_forestry = ITEMS_FORESTRY_ARMOR.register("cherry_chestplate_forestry", () -> new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> cherry_leggings_forestry = ITEMS_FORESTRY_ARMOR.register("cherry_leggings_forestry", () -> new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> cherry_boots_forestry = ITEMS_FORESTRY_ARMOR.register("cherry_boots_forestry", () -> new SPItemArmor(SPArmorMaterial.cherryForestryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> chestnut_helmet = ITEMS_FORESTRY_ARMOR.register("chestnut_helmet", () -> new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> chestnut_chestplate = ITEMS_FORESTRY_ARMOR.register("chestnut_chestplate", () -> new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> chestnut_leggings = ITEMS_FORESTRY_ARMOR.register("chestnut_leggings", () -> new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> chestnut_boots = ITEMS_FORESTRY_ARMOR.register("chestnut_boots", () -> new SPItemArmor(SPArmorMaterial.chestnutArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> citrus_helmet = ITEMS_FORESTRY_ARMOR.register("citrus_helmet", () -> new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> citrus_chestplate = ITEMS_FORESTRY_ARMOR.register("citrus_chestplate", () -> new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> citrus_leggings = ITEMS_FORESTRY_ARMOR.register("citrus_leggings", () -> new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> citrus_boots = ITEMS_FORESTRY_ARMOR.register("citrus_boots", () -> new SPItemArmor(SPArmorMaterial.citrusArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> cocobolo_helmet = ITEMS_FORESTRY_ARMOR.register("cocobolo_helmet", () -> new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> cocobolo_chestplate = ITEMS_FORESTRY_ARMOR.register("cocobolo_chestplate", () -> new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> cocobolo_leggings = ITEMS_FORESTRY_ARMOR.register("cocobolo_leggings", () -> new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> cocobolo_boots = ITEMS_FORESTRY_ARMOR.register("cocobolo_boots", () -> new SPItemArmor(SPArmorMaterial.cocoboloArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> ebony_helmet_forestry = ITEMS_FORESTRY_ARMOR.register("ebony_helmet_forestry", () -> new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> ebony_chestplate_forestry = ITEMS_FORESTRY_ARMOR.register("ebony_chestplate_forestry", () -> new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> ebony_leggings_forestry = ITEMS_FORESTRY_ARMOR.register("ebony_leggings_forestry", () -> new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> ebony_boots_forestry = ITEMS_FORESTRY_ARMOR.register("ebony_boots_forestry", () -> new SPItemArmor(SPArmorMaterial.ebonyForestryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> giant_sequoia_helmet = ITEMS_FORESTRY_ARMOR.register("giant_sequoia_helmet", () -> new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> giant_sequoia_chestplate = ITEMS_FORESTRY_ARMOR.register("giant_sequoia_chestplate", () -> new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> giant_sequoia_leggings = ITEMS_FORESTRY_ARMOR.register("giant_sequoia_leggings", () -> new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> giant_sequoia_boots = ITEMS_FORESTRY_ARMOR.register("giant_sequoia_boots", () -> new SPItemArmor(SPArmorMaterial.giantSequoiaArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> greenheart_helmet = ITEMS_FORESTRY_ARMOR.register("greenheart_helmet", () -> new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> greenheart_chestplate = ITEMS_FORESTRY_ARMOR.register("greenheart_chestplate", () -> new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> greenheart_leggings = ITEMS_FORESTRY_ARMOR.register("greenheart_leggings", () -> new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> greenheart_boots = ITEMS_FORESTRY_ARMOR.register("greenheart_boots", () -> new SPItemArmor(SPArmorMaterial.greenheartArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> ipe_helmet = ITEMS_FORESTRY_ARMOR.register("ipe_helmet", () -> new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> ipe_chestplate = ITEMS_FORESTRY_ARMOR.register("ipe_chestplate", () -> new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> ipe_leggings = ITEMS_FORESTRY_ARMOR.register("ipe_leggings", () -> new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> ipe_boots = ITEMS_FORESTRY_ARMOR.register("ipe_boots", () -> new SPItemArmor(SPArmorMaterial.ipeArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> kapok_helmet = ITEMS_FORESTRY_ARMOR.register("kapok_helmet", () -> new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> kapok_chestplate = ITEMS_FORESTRY_ARMOR.register("kapok_chestplate", () -> new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> kapok_leggings = ITEMS_FORESTRY_ARMOR.register("kapok_leggings", () -> new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> kapok_boots = ITEMS_FORESTRY_ARMOR.register("kapok_boots", () -> new SPItemArmor(SPArmorMaterial.kapokArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> larch_helmet = ITEMS_FORESTRY_ARMOR.register("larch_helmet", () -> new SPItemArmor(SPArmorMaterial.larchArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> larch_chestplate = ITEMS_FORESTRY_ARMOR.register("larch_chestplate", () -> new SPItemArmor(SPArmorMaterial.larchArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> larch_leggings = ITEMS_FORESTRY_ARMOR.register("larch_leggings", () -> new SPItemArmor(SPArmorMaterial.larchArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> larch_boots = ITEMS_FORESTRY_ARMOR.register("larch_boots", () -> new SPItemArmor(SPArmorMaterial.larchArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> lime_helmet = ITEMS_FORESTRY_ARMOR.register("lime_helmet", () -> new SPItemArmor(SPArmorMaterial.limeArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> lime_chestplate = ITEMS_FORESTRY_ARMOR.register("lime_chestplate", () -> new SPItemArmor(SPArmorMaterial.limeArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> lime_leggings = ITEMS_FORESTRY_ARMOR.register("lime_leggings", () -> new SPItemArmor(SPArmorMaterial.limeArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> lime_boots = ITEMS_FORESTRY_ARMOR.register("lime_boots", () -> new SPItemArmor(SPArmorMaterial.limeArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> mahoe_helmet = ITEMS_FORESTRY_ARMOR.register("mahoe_helmet", () -> new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> mahoe_chestplate = ITEMS_FORESTRY_ARMOR.register("mahoe_chestplate", () -> new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> mahoe_leggings = ITEMS_FORESTRY_ARMOR.register("mahoe_leggings", () -> new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> mahoe_boots = ITEMS_FORESTRY_ARMOR.register("mahoe_boots", () -> new SPItemArmor(SPArmorMaterial.mahoeArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> mahogany_helmet_forestry = ITEMS_FORESTRY_ARMOR.register("mahogany_helmet_forestry", () -> new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> mahogany_chestplate_forestry = ITEMS_FORESTRY_ARMOR.register("mahogany_chestplate_forestry", () -> new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> mahogany_leggings_forestry = ITEMS_FORESTRY_ARMOR.register("mahogany_leggings_forestry", () -> new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> mahogany_boots_forestry = ITEMS_FORESTRY_ARMOR.register("mahogany_boots_forestry", () -> new SPItemArmor(SPArmorMaterial.mahoganyForestryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> maple_helmet = ITEMS_FORESTRY_ARMOR.register("maple_helmet", () -> new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> maple_chestplate = ITEMS_FORESTRY_ARMOR.register("maple_chestplate", () -> new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> maple_leggings = ITEMS_FORESTRY_ARMOR.register("maple_leggings", () -> new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> maple_boots = ITEMS_FORESTRY_ARMOR.register("maple_boots", () -> new SPItemArmor(SPArmorMaterial.mapleArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> padauk_helmet = ITEMS_FORESTRY_ARMOR.register("padauk_helmet", () -> new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> padauk_chestplate = ITEMS_FORESTRY_ARMOR.register("padauk_chestplate", () -> new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> padauk_leggings = ITEMS_FORESTRY_ARMOR.register("padauk_leggings", () -> new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> padauk_boots = ITEMS_FORESTRY_ARMOR.register("padauk_boots", () -> new SPItemArmor(SPArmorMaterial.padaukArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> palm_helmet_forestry = ITEMS_FORESTRY_ARMOR.register("palm_helmet_forestry", () -> new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> palm_chestplate_forestry = ITEMS_FORESTRY_ARMOR.register("palm_chestplate_forestry", () -> new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> palm_leggings_forestry = ITEMS_FORESTRY_ARMOR.register("palm_leggings_forestry", () -> new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> palm_boots_forestry = ITEMS_FORESTRY_ARMOR.register("palm_boots_forestry", () -> new SPItemArmor(SPArmorMaterial.palmForestryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> papaya_helmet = ITEMS_FORESTRY_ARMOR.register("papaya_helmet", () -> new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> papaya_chestplate = ITEMS_FORESTRY_ARMOR.register("papaya_chestplate", () -> new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> papaya_leggings = ITEMS_FORESTRY_ARMOR.register("papaya_leggings", () -> new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> papaya_boots = ITEMS_FORESTRY_ARMOR.register("papaya_boots", () -> new SPItemArmor(SPArmorMaterial.papayaArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> pine_helmet_forestry = ITEMS_FORESTRY_ARMOR.register("pine_helmet_forestry", () -> new SPItemArmor(SPArmorMaterial.pineForestryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> pine_chestplate_forestry = ITEMS_FORESTRY_ARMOR.register("pine_chestplate_forestry", () -> new SPItemArmor(SPArmorMaterial.pineForestryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> pine_leggings_forestry = ITEMS_FORESTRY_ARMOR.register("pine_leggings_forestry", () -> new SPItemArmor(SPArmorMaterial.pineForestryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> pine_boots_forestry = ITEMS_FORESTRY_ARMOR.register("pine_boots_forestry", () -> new SPItemArmor(SPArmorMaterial.pineForestryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> plum_helmet = ITEMS_FORESTRY_ARMOR.register("plum_helmet", () -> new SPItemArmor(SPArmorMaterial.plumArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> plum_chestplate = ITEMS_FORESTRY_ARMOR.register("plum_chestplate", () -> new SPItemArmor(SPArmorMaterial.plumArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> plum_leggings = ITEMS_FORESTRY_ARMOR.register("plum_leggings", () -> new SPItemArmor(SPArmorMaterial.plumArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> plum_boots = ITEMS_FORESTRY_ARMOR.register("plum_boots", () -> new SPItemArmor(SPArmorMaterial.plumArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> poplar_helmet = ITEMS_FORESTRY_ARMOR.register("poplar_helmet", () -> new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> poplar_chestplate = ITEMS_FORESTRY_ARMOR.register("poplar_chestplate", () -> new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> poplar_leggings = ITEMS_FORESTRY_ARMOR.register("poplar_leggings", () -> new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> poplar_boots = ITEMS_FORESTRY_ARMOR.register("poplar_boots", () -> new SPItemArmor(SPArmorMaterial.poplarArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> sequoia_helmet = ITEMS_FORESTRY_ARMOR.register("sequoia_helmet", () -> new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> sequoia_chestplate = ITEMS_FORESTRY_ARMOR.register("sequoia_chestplate", () -> new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> sequoia_leggings = ITEMS_FORESTRY_ARMOR.register("sequoia_leggings", () -> new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> sequoia_boots = ITEMS_FORESTRY_ARMOR.register("sequoia_boots", () -> new SPItemArmor(SPArmorMaterial.sequoiaArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> teak_helmet = ITEMS_FORESTRY_ARMOR.register("teak_helmet", () -> new SPItemArmor(SPArmorMaterial.teakArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> teak_chestplate = ITEMS_FORESTRY_ARMOR.register("teak_chestplate", () -> new SPItemArmor(SPArmorMaterial.teakArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> teak_leggings = ITEMS_FORESTRY_ARMOR.register("teak_leggings", () -> new SPItemArmor(SPArmorMaterial.teakArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> teak_boots = ITEMS_FORESTRY_ARMOR.register("teak_boots", () -> new SPItemArmor(SPArmorMaterial.teakArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> walnut_helmet = ITEMS_FORESTRY_ARMOR.register("walnut_helmet", () -> new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> walnut_chestplate = ITEMS_FORESTRY_ARMOR.register("walnut_chestplate", () -> new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> walnut_leggings = ITEMS_FORESTRY_ARMOR.register("walnut_leggings", () -> new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> walnut_boots = ITEMS_FORESTRY_ARMOR.register("walnut_boots", () -> new SPItemArmor(SPArmorMaterial.walnutArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> wenge_helmet = ITEMS_FORESTRY_ARMOR.register("wenge_helmet", () -> new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> wenge_chestplate = ITEMS_FORESTRY_ARMOR.register("wenge_chestplate", () -> new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> wenge_leggings = ITEMS_FORESTRY_ARMOR.register("wenge_leggings", () -> new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> wenge_boots = ITEMS_FORESTRY_ARMOR.register("wenge_boots", () -> new SPItemArmor(SPArmorMaterial.wengeArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> willow_helmet_forestry = ITEMS_FORESTRY_ARMOR.register("willow_helmet_forestry", () -> new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> willow_chestplate_forestry = ITEMS_FORESTRY_ARMOR.register("willow_chestplate_forestry", () -> new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> willow_leggings_forestry = ITEMS_FORESTRY_ARMOR.register("willow_leggings_forestry", () -> new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> willow_boots_forestry = ITEMS_FORESTRY_ARMOR.register("willow_boots_forestry", () -> new SPItemArmor(SPArmorMaterial.willowForestryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> zebrawood_helmet = ITEMS_FORESTRY_ARMOR.register("zebrawood_helmet", () -> new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> zebrawood_chestplate = ITEMS_FORESTRY_ARMOR.register("zebrawood_chestplate", () -> new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> zebrawood_leggings = ITEMS_FORESTRY_ARMOR.register("zebrawood_leggings", () -> new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> zebrawood_boots = ITEMS_FORESTRY_ARMOR.register("zebrawood_boots", () -> new SPItemArmor(SPArmorMaterial.zebrawoodArmorMaterial, Type.BOOTS));
	
	public static void init(){
		
		SPItems.desert_acacia = NonNullList.create();
		SPItems.desert_acacia.add(0, new ItemStack(desert_acacia_helmet.get()));
		SPItems.desert_acacia.add(1, new ItemStack(desert_acacia_chestplate.get()));
		SPItems.desert_acacia.add(2, new ItemStack(desert_acacia_leggings.get()));
		SPItems.desert_acacia.add(3, new ItemStack(desert_acacia_boots.get()));
		
		SPItems.balsa = NonNullList.create();
		SPItems.balsa.add(0, new ItemStack(balsa_helmet.get()));
		SPItems.balsa.add(1, new ItemStack(balsa_chestplate.get()));
		SPItems.balsa.add(2, new ItemStack(balsa_leggings.get()));
		SPItems.balsa.add(3, new ItemStack(balsa_boots.get()));
		
		SPItems.baobab = NonNullList.create();
		SPItems.baobab.add(0, new ItemStack(baobab_helmet.get()));
		SPItems.baobab.add(1, new ItemStack(baobab_chestplate.get()));
		SPItems.baobab.add(2, new ItemStack(baobab_leggings.get()));
		SPItems.baobab.add(3, new ItemStack(baobab_boots.get()));
		
		SPItems.cherry_forestry = NonNullList.create();
		SPItems.cherry_forestry.add(0, new ItemStack(cherry_helmet_forestry.get()));
		SPItems.cherry_forestry.add(1, new ItemStack(cherry_chestplate_forestry.get()));
		SPItems.cherry_forestry.add(2, new ItemStack(cherry_leggings_forestry.get()));
		SPItems.cherry_forestry.add(3, new ItemStack(cherry_boots_forestry.get()));
		
		SPItems.chestnut = NonNullList.create();
		SPItems.chestnut.add(0, new ItemStack(chestnut_helmet.get()));
		SPItems.chestnut.add(1, new ItemStack(chestnut_chestplate.get()));
		SPItems.chestnut.add(2, new ItemStack(chestnut_leggings.get()));
		SPItems.chestnut.add(3, new ItemStack(chestnut_boots.get()));
		
		SPItems.citrus = NonNullList.create();
		SPItems.citrus.add(0, new ItemStack(citrus_helmet.get()));
		SPItems.citrus.add(1, new ItemStack(citrus_chestplate.get()));
		SPItems.citrus.add(2, new ItemStack(citrus_leggings.get()));
		SPItems.citrus.add(3, new ItemStack(citrus_boots.get()));
		
		SPItems.cocobolo = NonNullList.create();
		SPItems.cocobolo.add(0, new ItemStack(cocobolo_helmet.get()));
		SPItems.cocobolo.add(1, new ItemStack(cocobolo_chestplate.get()));
		SPItems.cocobolo.add(2, new ItemStack(cocobolo_leggings.get()));
		SPItems.cocobolo.add(3, new ItemStack(cocobolo_boots.get()));
		
		SPItems.ebony_forestry = NonNullList.create();
		SPItems.ebony_forestry.add(0, new ItemStack(ebony_helmet_forestry.get()));
		SPItems.ebony_forestry.add(1, new ItemStack(ebony_chestplate_forestry.get()));
		SPItems.ebony_forestry.add(2, new ItemStack(ebony_leggings_forestry.get()));
		SPItems.ebony_forestry.add(3, new ItemStack(ebony_boots_forestry.get()));
		
		SPItems.giant_sequoia = NonNullList.create();
		SPItems.giant_sequoia.add(0, new ItemStack(giant_sequoia_helmet.get()));
		SPItems.giant_sequoia.add(1, new ItemStack(giant_sequoia_chestplate.get()));
		SPItems.giant_sequoia.add(2, new ItemStack(giant_sequoia_leggings.get()));
		SPItems.giant_sequoia.add(3, new ItemStack(giant_sequoia_boots.get()));
		
		SPItems.greenheart = NonNullList.create();
		SPItems.greenheart.add(0, new ItemStack(greenheart_helmet.get()));
		SPItems.greenheart.add(1, new ItemStack(greenheart_chestplate.get()));
		SPItems.greenheart.add(2, new ItemStack(greenheart_leggings.get()));
		SPItems.greenheart.add(3, new ItemStack(greenheart_boots.get()));
		
		SPItems.ipe = NonNullList.create();
		SPItems.ipe.add(0, new ItemStack(ipe_helmet.get()));
		SPItems.ipe.add(1, new ItemStack(ipe_chestplate.get()));
		SPItems.ipe.add(2, new ItemStack(ipe_leggings.get()));
		SPItems.ipe.add(3, new ItemStack(ipe_boots.get()));
		
		SPItems.kapok = NonNullList.create();
		SPItems.kapok.add(0, new ItemStack(kapok_helmet.get()));
		SPItems.kapok.add(1, new ItemStack(kapok_chestplate.get()));
		SPItems.kapok.add(2, new ItemStack(kapok_leggings.get()));
		SPItems.kapok.add(3, new ItemStack(kapok_boots.get()));
		
		SPItems.larch = NonNullList.create();
		SPItems.larch.add(0, new ItemStack(larch_helmet.get()));
		SPItems.larch.add(1, new ItemStack(larch_chestplate.get()));
		SPItems.larch.add(2, new ItemStack(larch_leggings.get()));
		SPItems.larch.add(3, new ItemStack(larch_boots.get()));
		
		SPItems.lime = NonNullList.create();
		SPItems.lime.add(0, new ItemStack(lime_helmet.get()));
		SPItems.lime.add(1, new ItemStack(lime_chestplate.get()));
		SPItems.lime.add(2, new ItemStack(lime_leggings.get()));
		SPItems.lime.add(3, new ItemStack(lime_boots.get()));
		
		SPItems.mahoe = NonNullList.create();
		SPItems.mahoe.add(0, new ItemStack(mahoe_helmet.get()));
		SPItems.mahoe.add(1, new ItemStack(mahoe_chestplate.get()));
		SPItems.mahoe.add(2, new ItemStack(mahoe_leggings.get()));
		SPItems.mahoe.add(3, new ItemStack(mahoe_boots.get()));
		
		SPItems.mahogany_forestry = NonNullList.create();
		SPItems.mahogany_forestry.add(0, new ItemStack(mahogany_helmet_forestry.get()));
		SPItems.mahogany_forestry.add(1, new ItemStack(mahogany_chestplate_forestry.get()));
		SPItems.mahogany_forestry.add(2, new ItemStack(mahogany_leggings_forestry.get()));
		SPItems.mahogany_forestry.add(3, new ItemStack(mahogany_boots_forestry.get()));
		
		SPItems.maple = NonNullList.create();
		SPItems.maple.add(0, new ItemStack(maple_helmet.get()));
		SPItems.maple.add(1, new ItemStack(maple_chestplate.get()));
		SPItems.maple.add(2, new ItemStack(maple_leggings.get()));
		SPItems.maple.add(3, new ItemStack(maple_boots.get()));
		
		SPItems.padauk = NonNullList.create();
		SPItems.padauk.add(0, new ItemStack(padauk_helmet.get()));
		SPItems.padauk.add(1, new ItemStack(padauk_chestplate.get()));
		SPItems.padauk.add(2, new ItemStack(padauk_leggings.get()));
		SPItems.padauk.add(3, new ItemStack(padauk_boots.get()));
		
		SPItems.palm_forestry = NonNullList.create();
		SPItems.palm_forestry.add(0, new ItemStack(palm_helmet_forestry.get()));
		SPItems.palm_forestry.add(1, new ItemStack(palm_chestplate_forestry.get()));
		SPItems.palm_forestry.add(2, new ItemStack(palm_leggings_forestry.get()));
		SPItems.palm_forestry.add(3, new ItemStack(palm_boots_forestry.get()));
		
		SPItems.papaya = NonNullList.create();
		SPItems.papaya.add(0, new ItemStack(papaya_helmet.get()));
		SPItems.papaya.add(1, new ItemStack(papaya_chestplate.get()));
		SPItems.papaya.add(2, new ItemStack(papaya_leggings.get()));
		SPItems.papaya.add(3, new ItemStack(papaya_boots.get()));
		
		SPItems.pine_forestry = NonNullList.create();
		SPItems.pine_forestry.add(0, new ItemStack(pine_helmet_forestry.get()));
		SPItems.pine_forestry.add(1, new ItemStack(pine_chestplate_forestry.get()));
		SPItems.pine_forestry.add(2, new ItemStack(pine_leggings_forestry.get()));
		SPItems.pine_forestry.add(3, new ItemStack(pine_boots_forestry.get()));
		
		SPItems.plum = NonNullList.create();
		SPItems.plum.add(0, new ItemStack(plum_helmet.get()));
		SPItems.plum.add(1, new ItemStack(plum_chestplate.get()));
		SPItems.plum.add(2, new ItemStack(plum_leggings.get()));
		SPItems.plum.add(3, new ItemStack(plum_boots.get()));
		
		SPItems.poplar = NonNullList.create();
		SPItems.poplar.add(0, new ItemStack(poplar_helmet.get()));
		SPItems.poplar.add(1, new ItemStack(poplar_chestplate.get()));
		SPItems.poplar.add(2, new ItemStack(poplar_leggings.get()));
		SPItems.poplar.add(3, new ItemStack(poplar_boots.get()));
		
		SPItems.sequoia = NonNullList.create();
		SPItems.sequoia.add(0, new ItemStack(sequoia_helmet.get()));
		SPItems.sequoia.add(1, new ItemStack(sequoia_chestplate.get()));
		SPItems.sequoia.add(2, new ItemStack(sequoia_leggings.get()));
		SPItems.sequoia.add(3, new ItemStack(sequoia_boots.get()));
		
		SPItems.teak = NonNullList.create();
		SPItems.teak.add(0, new ItemStack(teak_helmet.get()));
		SPItems.teak.add(1, new ItemStack(teak_chestplate.get()));
		SPItems.teak.add(2, new ItemStack(teak_leggings.get()));
		SPItems.teak.add(3, new ItemStack(teak_boots.get()));
		
		SPItems.walnut = NonNullList.create();
		SPItems.walnut.add(0, new ItemStack(walnut_helmet.get()));
		SPItems.walnut.add(1, new ItemStack(walnut_chestplate.get()));
		SPItems.walnut.add(2, new ItemStack(walnut_leggings.get()));
		SPItems.walnut.add(3, new ItemStack(walnut_boots.get()));
		
		SPItems.wenge = NonNullList.create();
		SPItems.wenge.add(0, new ItemStack(wenge_helmet.get()));
		SPItems.wenge.add(1, new ItemStack(wenge_chestplate.get()));
		SPItems.wenge.add(2, new ItemStack(wenge_leggings.get()));
		SPItems.wenge.add(3, new ItemStack(wenge_boots.get()));
		
		SPItems.willow_forestry = NonNullList.create();
		SPItems.willow_forestry.add(0, new ItemStack(willow_helmet_forestry.get()));
		SPItems.willow_forestry.add(1, new ItemStack(willow_chestplate_forestry.get()));
		SPItems.willow_forestry.add(2, new ItemStack(willow_leggings_forestry.get()));
		SPItems.willow_forestry.add(3, new ItemStack(willow_boots_forestry.get()));
		
		SPItems.zebrawood = NonNullList.create();
		SPItems.zebrawood.add(0, new ItemStack(zebrawood_helmet.get()));
		SPItems.zebrawood.add(1, new ItemStack(zebrawood_chestplate.get()));
		SPItems.zebrawood.add(2, new ItemStack(zebrawood_leggings.get()));
		SPItems.zebrawood.add(3, new ItemStack(zebrawood_boots.get()));
		
	}

}
