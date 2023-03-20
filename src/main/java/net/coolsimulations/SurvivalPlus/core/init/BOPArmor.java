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
public class BOPArmor {
	
	public static final DeferredRegister<Item> ITEMS_BOP_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS_BOP_EXTRAS_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> cherry_helmet = ITEMS_BOP_ARMOR.register("cherry_helmet", () -> new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> cherry_chestplate = ITEMS_BOP_ARMOR.register("cherry_chestplate", () -> new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> cherry_leggings = ITEMS_BOP_ARMOR.register("cherry_leggings", () -> new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> cherry_boots = ITEMS_BOP_ARMOR.register("cherry_boots", () -> new SPItemArmor(SPArmorMaterial.cherryArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> dead_helmet = ITEMS_BOP_ARMOR.register("dead_helmet", () -> new SPItemArmor(SPArmorMaterial.deadArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> dead_chestplate = ITEMS_BOP_ARMOR.register("dead_chestplate", () -> new SPItemArmor(SPArmorMaterial.deadArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> dead_leggings = ITEMS_BOP_ARMOR.register("dead_leggings", () -> new SPItemArmor(SPArmorMaterial.deadArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> dead_boots = ITEMS_BOP_ARMOR.register("dead_boots", () -> new SPItemArmor(SPArmorMaterial.deadArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> fir_helmet = ITEMS_BOP_ARMOR.register("fir_helmet", () -> new SPItemArmor(SPArmorMaterial.firArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> fir_chestplate = ITEMS_BOP_ARMOR.register("fir_chestplate", () -> new SPItemArmor(SPArmorMaterial.firArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> fir_leggings = ITEMS_BOP_ARMOR.register("fir_leggings", () -> new SPItemArmor(SPArmorMaterial.firArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> fir_boots = ITEMS_BOP_ARMOR.register("fir_boots", () -> new SPItemArmor(SPArmorMaterial.firArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> hellbark_helmet = ITEMS_BOP_ARMOR.register("hellbark_helmet", () -> new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> hellbark_chestplate = ITEMS_BOP_ARMOR.register("hellbark_chestplate", () -> new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> hellbark_leggings = ITEMS_BOP_ARMOR.register("hellbark_leggings", () -> new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> hellbark_boots = ITEMS_BOP_ARMOR.register("hellbark_boots", () -> new SPItemArmor(SPArmorMaterial.hellbarkArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> jacaranda_helmet = ITEMS_BOP_ARMOR.register("jacaranda_helmet", () -> new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> jacaranda_chestplate = ITEMS_BOP_ARMOR.register("jacaranda_chestplate", () -> new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> jacaranda_leggings = ITEMS_BOP_ARMOR.register("jacaranda_leggings", () -> new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> jacaranda_boots = ITEMS_BOP_ARMOR.register("jacaranda_boots", () -> new SPItemArmor(SPArmorMaterial.jacarandaArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> magic_helmet = ITEMS_BOP_ARMOR.register("magic_helmet", () -> new SPItemArmor(SPArmorMaterial.magicArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> magic_chestplate = ITEMS_BOP_ARMOR.register("magic_chestplate", () -> new SPItemArmor(SPArmorMaterial.magicArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> magic_leggings = ITEMS_BOP_ARMOR.register("magic_leggings", () -> new SPItemArmor(SPArmorMaterial.magicArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> magic_boots = ITEMS_BOP_ARMOR.register("magic_boots", () -> new SPItemArmor(SPArmorMaterial.magicArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> mahogany_helmet = ITEMS_BOP_ARMOR.register("mahogany_helmet", () -> new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> mahogany_chestplate = ITEMS_BOP_ARMOR.register("mahogany_chestplate", () -> new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> mahogany_leggings = ITEMS_BOP_ARMOR.register("mahogany_leggings", () -> new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> mahogany_boots = ITEMS_BOP_ARMOR.register("mahogany_boots", () -> new SPItemArmor(SPArmorMaterial.mahoganyArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> palm_helmet = ITEMS_BOP_ARMOR.register("palm_helmet", () -> new SPItemArmor(SPArmorMaterial.palmArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> palm_chestplate = ITEMS_BOP_ARMOR.register("palm_chestplate", () -> new SPItemArmor(SPArmorMaterial.palmArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> palm_leggings = ITEMS_BOP_ARMOR.register("palm_leggings", () -> new SPItemArmor(SPArmorMaterial.palmArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> palm_boots = ITEMS_BOP_ARMOR.register("palm_boots", () -> new SPItemArmor(SPArmorMaterial.palmArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> redwood_helmet = ITEMS_BOP_ARMOR.register("redwood_helmet", () -> new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> redwood_chestplate = ITEMS_BOP_ARMOR.register("redwood_chestplate", () -> new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> redwood_leggings = ITEMS_BOP_ARMOR.register("redwood_leggings", () -> new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> redwood_boots = ITEMS_BOP_ARMOR.register("redwood_boots", () -> new SPItemArmor(SPArmorMaterial.redwoodArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> umbran_helmet = ITEMS_BOP_ARMOR.register("umbran_helmet", () -> new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> umbran_chestplate = ITEMS_BOP_ARMOR.register("umbran_chestplate", () -> new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> umbran_leggings = ITEMS_BOP_ARMOR.register("umbran_leggings", () -> new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> umbran_boots = ITEMS_BOP_ARMOR.register("umbran_boots", () -> new SPItemArmor(SPArmorMaterial.umbranArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> willow_helmet = ITEMS_BOP_ARMOR.register("willow_helmet", () -> new SPItemArmor(SPArmorMaterial.willowArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> willow_chestplate = ITEMS_BOP_ARMOR.register("willow_chestplate", () -> new SPItemArmor(SPArmorMaterial.willowArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> willow_leggings = ITEMS_BOP_ARMOR.register("willow_leggings", () -> new SPItemArmor(SPArmorMaterial.willowArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> willow_boots = ITEMS_BOP_ARMOR.register("willow_boots", () -> new SPItemArmor(SPArmorMaterial.willowArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> ebony_helmet = ITEMS_BOP_EXTRAS_ARMOR.register("ebony_helmet", () -> new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> ebony_chestplate = ITEMS_BOP_EXTRAS_ARMOR.register("ebony_chestplate", () -> new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> ebony_leggings = ITEMS_BOP_ARMOR.register("ebony_leggings", () -> new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> ebony_boots = ITEMS_BOP_EXTRAS_ARMOR.register("ebony_boots", () -> new SPItemArmor(SPArmorMaterial.ebonyArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> eucalyptus_helmet = ITEMS_BOP_EXTRAS_ARMOR.register("eucalyptus_helmet", () -> new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> eucalyptus_chestplate = ITEMS_BOP_EXTRAS_ARMOR.register("eucalyptus_chestplate", () -> new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> eucalyptus_leggings = ITEMS_BOP_EXTRAS_ARMOR.register("eucalyptus_leggings", () -> new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> eucalyptus_boots = ITEMS_BOP_EXTRAS_ARMOR.register("eucalyptus_boots", () -> new SPItemArmor(SPArmorMaterial.eucalyptusArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> pine_helmet = ITEMS_BOP_EXTRAS_ARMOR.register("pine_helmet", () -> new SPItemArmor(SPArmorMaterial.pineArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> pine_chestplate = ITEMS_BOP_EXTRAS_ARMOR.register("pine_chestplate", () -> new SPItemArmor(SPArmorMaterial.pineArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> pine_leggings = ITEMS_BOP_EXTRAS_ARMOR.register("pine_leggings", () -> new SPItemArmor(SPArmorMaterial.pineArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> pine_boots = ITEMS_BOP_EXTRAS_ARMOR.register("pine_boots", () -> new SPItemArmor(SPArmorMaterial.pineArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> sacred_oak_helmet = ITEMS_BOP_EXTRAS_ARMOR.register("sacred_oak_helmet", () -> new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> sacred_oak_chestplate = ITEMS_BOP_EXTRAS_ARMOR.register("sacred_oak_chestplate", () -> new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> sacred_oak_leggings = ITEMS_BOP_EXTRAS_ARMOR.register("sacred_oak_leggings", () -> new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> sacred_oak_boots = ITEMS_BOP_EXTRAS_ARMOR.register("sacred_oak_boots", () -> new SPItemArmor(SPArmorMaterial.sacredOakArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> ethereal_helmet = ITEMS_BOP_EXTRAS_ARMOR.register("ethereal_helmet", () -> new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> ethereal_chestplate = ITEMS_BOP_EXTRAS_ARMOR.register("ethereal_chestplate", () -> new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> ethereal_leggings = ITEMS_BOP_EXTRAS_ARMOR.register("ethereal_leggings", () -> new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> ethereal_boots = ITEMS_BOP_EXTRAS_ARMOR.register("ethereal_boots", () -> new SPItemArmor(SPArmorMaterial.etherealArmorMaterial, Type.BOOTS));
	
	public static void init(){
		
		SPItems.cherry = NonNullList.create();
		SPItems.cherry.add(0, new ItemStack(cherry_helmet.get()));
		SPItems.cherry.add(1, new ItemStack(cherry_chestplate.get()));
		SPItems.cherry.add(2, new ItemStack(cherry_leggings.get()));
		SPItems.cherry.add(3, new ItemStack(cherry_boots.get()));
		
		SPItems.dead = NonNullList.create();
		SPItems.dead.add(0, new ItemStack(dead_helmet.get()));
		SPItems.dead.add(1, new ItemStack(dead_chestplate.get()));
		SPItems.dead.add(2, new ItemStack(dead_leggings.get()));
		SPItems.dead.add(3, new ItemStack(dead_boots.get()));

		SPItems.fir = NonNullList.create();
		SPItems.fir.add(0, new ItemStack(fir_helmet.get()));
		SPItems.fir.add(1, new ItemStack(fir_chestplate.get()));
		SPItems.fir.add(2, new ItemStack(fir_leggings.get()));
		SPItems.fir.add(3, new ItemStack(fir_boots.get()));

		SPItems.hellbark = NonNullList.create();
		SPItems.hellbark.add(0, new ItemStack(hellbark_helmet.get()));
		SPItems.hellbark.add(1, new ItemStack(hellbark_chestplate.get()));
		SPItems.hellbark.add(2, new ItemStack(hellbark_leggings.get()));
		SPItems.hellbark.add(3, new ItemStack(hellbark_boots.get()));

		SPItems.jacaranda = NonNullList.create();
		SPItems.jacaranda.add(0, new ItemStack(jacaranda_helmet.get()));
		SPItems.jacaranda.add(1, new ItemStack(jacaranda_chestplate.get()));
		SPItems.jacaranda.add(2, new ItemStack(jacaranda_leggings.get()));
		SPItems.jacaranda.add(3, new ItemStack(jacaranda_boots.get()));

		SPItems.magic = NonNullList.create();
		SPItems.magic.add(0, new ItemStack(magic_helmet.get()));
		SPItems.magic.add(1, new ItemStack(magic_chestplate.get()));
		SPItems.magic.add(2, new ItemStack(magic_leggings.get()));
		SPItems.magic.add(3, new ItemStack(magic_boots.get()));

		SPItems.mahogany = NonNullList.create();
		SPItems.mahogany.add(0, new ItemStack(mahogany_helmet.get()));
		SPItems.mahogany.add(1, new ItemStack(mahogany_chestplate.get()));
		SPItems.mahogany.add(2, new ItemStack(mahogany_leggings.get()));
		SPItems.mahogany.add(3, new ItemStack(mahogany_boots.get()));

		SPItems.palm = NonNullList.create();
		SPItems.palm.add(0, new ItemStack(palm_helmet.get()));
		SPItems.palm.add(1, new ItemStack(palm_chestplate.get()));
		SPItems.palm.add(2, new ItemStack(palm_leggings.get()));
		SPItems.palm.add(3, new ItemStack(palm_boots.get()));

		SPItems.redwood = NonNullList.create();
		SPItems.redwood.add(0, new ItemStack(redwood_helmet.get()));
		SPItems.redwood.add(1, new ItemStack(redwood_chestplate.get()));
		SPItems.redwood.add(2, new ItemStack(redwood_leggings.get()));
		SPItems.redwood.add(3, new ItemStack(redwood_boots.get()));

		SPItems.umbran = NonNullList.create();
		SPItems.umbran.add(0, new ItemStack(umbran_helmet.get()));
		SPItems.umbran.add(1, new ItemStack(umbran_chestplate.get()));
		SPItems.umbran.add(2, new ItemStack(umbran_leggings.get()));
		SPItems.umbran.add(3, new ItemStack(umbran_boots.get()));

		SPItems.willow = NonNullList.create();
		SPItems.willow.add(0, new ItemStack(willow_helmet.get()));
		SPItems.willow.add(1, new ItemStack(willow_chestplate.get()));
		SPItems.willow.add(2, new ItemStack(willow_leggings.get()));
		SPItems.willow.add(3, new ItemStack(willow_boots.get()));
		
		if(SPCompatibilityManager.isBopExtrasLoaded()) {
			
			SPItems.ebony = NonNullList.create();
			SPItems.ebony.add(0, new ItemStack(ebony_helmet.get()));
			SPItems.ebony.add(1, new ItemStack(ebony_chestplate.get()));
			SPItems.ebony.add(2, new ItemStack(ebony_leggings.get()));
			SPItems.ebony.add(3, new ItemStack(ebony_boots.get()));
			
			SPItems.eucalyptus = NonNullList.create();
			SPItems.eucalyptus.add(0, new ItemStack(eucalyptus_helmet.get()));
			SPItems.eucalyptus.add(1, new ItemStack(eucalyptus_chestplate.get()));
			SPItems.eucalyptus.add(2, new ItemStack(eucalyptus_leggings.get()));
			SPItems.eucalyptus.add(3, new ItemStack(eucalyptus_boots.get()));
			
			SPItems.pine = NonNullList.create();
			SPItems.pine.add(0, new ItemStack(pine_helmet.get()));
			SPItems.pine.add(1, new ItemStack(pine_chestplate.get()));
			SPItems.pine.add(2, new ItemStack(pine_leggings.get()));
			SPItems.pine.add(3, new ItemStack(pine_boots.get()));
			
			SPItems.sacred_oak = NonNullList.create();
			SPItems.sacred_oak.add(0, new ItemStack(sacred_oak_helmet.get()));
			SPItems.sacred_oak.add(1, new ItemStack(sacred_oak_chestplate.get()));
			SPItems.sacred_oak.add(2, new ItemStack(sacred_oak_leggings.get()));
			SPItems.sacred_oak.add(3, new ItemStack(sacred_oak_boots.get()));
			
			SPItems.ethereal = NonNullList.create();
			SPItems.ethereal.add(0, new ItemStack(ethereal_helmet.get()));
			SPItems.ethereal.add(1, new ItemStack(ethereal_chestplate.get()));
			SPItems.ethereal.add(2, new ItemStack(ethereal_leggings.get()));
			SPItems.ethereal.add(3, new ItemStack(ethereal_boots.get()));
		}
	}

}
