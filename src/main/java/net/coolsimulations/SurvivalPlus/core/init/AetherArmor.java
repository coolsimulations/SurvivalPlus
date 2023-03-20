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

public class AetherArmor {

	public static final DeferredRegister<Item> ITEMS_AETHER_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);

	private static final RegistryObject<Item> skyroot_helmet = ITEMS_AETHER_ARMOR.register("skyroot_helmet", () -> new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> skyroot_chestplate = ITEMS_AETHER_ARMOR.register("skyroot_chestplate", () -> new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> skyroot_leggings = ITEMS_AETHER_ARMOR.register("skyroot_leggings", () -> new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> skyroot_boots = ITEMS_AETHER_ARMOR.register("skyroot_boots", () -> new SPItemArmor(SPArmorMaterial.skyrootArmorMaterial, Type.BOOTS));
	
	private static final RegistryObject<Item> golden_oak_helmet = ITEMS_AETHER_ARMOR.register("golden_oak_helmet", () -> new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.HELMET));
	private static final RegistryObject<Item> golden_oak_chestplate = ITEMS_AETHER_ARMOR.register("golden_oak_chestplate", () -> new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.CHESTPLATE));
	private static final RegistryObject<Item> golden_oak_leggings = ITEMS_AETHER_ARMOR.register("golden_oak_leggings", () -> new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.LEGGINGS));
	private static final RegistryObject<Item> golden_oak_boots = ITEMS_AETHER_ARMOR.register("golden_oak_boots", () -> new SPItemArmor(SPArmorMaterial.goldenOakArmorMaterial, Type.BOOTS));

	public static void init(){

		SPItems.skyroot = NonNullList.create();
		SPItems.skyroot.add(0, new ItemStack(skyroot_helmet.get()));
		SPItems.skyroot.add(1, new ItemStack(skyroot_chestplate.get()));
		SPItems.skyroot.add(2, new ItemStack(skyroot_leggings.get()));
		SPItems.skyroot.add(3, new ItemStack(skyroot_boots.get()));
		
		SPItems.golden_oak = NonNullList.create();
		SPItems.golden_oak.add(0, new ItemStack(golden_oak_helmet.get()));
		SPItems.golden_oak.add(1, new ItemStack(golden_oak_chestplate.get()));
		SPItems.golden_oak.add(2, new ItemStack(golden_oak_leggings.get()));
		SPItems.golden_oak.add(3, new ItemStack(golden_oak_boots.get()));
	}
}
