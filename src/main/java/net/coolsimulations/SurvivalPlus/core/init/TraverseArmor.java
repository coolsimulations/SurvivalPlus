package net.coolsimulations.SurvivalPlus.core.init;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.item.SPArmorMaterial;
import net.coolsimulations.SurvivalPlus.api.item.SPItemArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class TraverseArmor {
	
	public static final DeferredRegister<Item> ITEMS_TRAVERSE_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, SPReference.MOD_ID);
	
	private static final RegistryObject<Item> fir_helmet_traverse = ITEMS_TRAVERSE_ARMOR.register("fir_helmet_traverse", () -> new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.HEAD));
	private static final RegistryObject<Item> fir_chestplate_traverse = ITEMS_TRAVERSE_ARMOR.register("fir_chestplate_traverse", () -> new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.CHEST));
	private static final RegistryObject<Item> fir_leggings_traverse = ITEMS_TRAVERSE_ARMOR.register("fir_leggings_traverse", () -> new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.LEGS));
	private static final RegistryObject<Item> fir_boots_traverse = ITEMS_TRAVERSE_ARMOR.register("fir_boots_traverse", () -> new SPItemArmor(SPArmorMaterial.firTraverseArmorMaterial, EquipmentSlot.FEET));

	public static void init(){

		SPItems.fir_traverse = NonNullList.create();
		SPItems.fir_traverse.add(0, new ItemStack(fir_helmet_traverse.get()));
		SPItems.fir_traverse.add(1, new ItemStack(fir_chestplate_traverse.get()));
		SPItems.fir_traverse.add(2, new ItemStack(fir_leggings_traverse.get()));
		SPItems.fir_traverse.add(3, new ItemStack(fir_boots_traverse.get()));
	}

}
