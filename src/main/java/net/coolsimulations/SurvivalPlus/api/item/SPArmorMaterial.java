package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;

public enum SPArmorMaterial implements ArmorMaterial {
	bronzeArmorMaterial("bronze", 20, new int[] {2, 5, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
    	return Ingredient.fromTag(SPTags.Items.INGOTS_BRONZE);
    }),
    stoneArmorMaterial("stone", 20, new int[] {1, 2, 4, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "cobblestones")));
    }),
    titaniumArmorMaterial("titanium", 20, new int[] {3, 5, 7, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, () -> {
    	return Ingredient.fromTag(SPTags.Items.INGOTS_TITANIUM);
    }),
    oakArmorMaterial("oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    spruceArmorMaterial("spruce", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    birchArmorMaterial("birch", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    jungleArmorMaterial("jungle", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    acaciaArmorMaterial("acacia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    darkOakArmorMaterial("dark_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    bambooArmorMaterial("bamboo", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "bamboos")));
    }),
    firTraverseArmorMaterial("fir_traverse", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    redwoodTerrestriaArmorMaterial("redwood_terrestria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    hemlockArmorMaterial("hemlock", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    rubberTerrestriaArmorMaterial("rubber_terrestria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    cypressArmorMaterial("cypress", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    willowTerrestriaArmorMaterial("willow_terrestria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    japaneseMapleArmorMaterial("japanese_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    rainbowEucalyptusArmorMaterial("rainbow_eucalyptus", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    }),
    sakuraArmorMaterial("sakura", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "wood_sticks")));
    });
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private Lazy<Ingredient> repairMaterial;
    private final String name;
    
    SPArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterialIn) {
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = new Lazy(repairMaterialIn);
        this.name = name;
}
    
    public int getDurability(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getEntitySlotId()] * this.maxDamageFactor;
    }

    public int getProtectionAmount(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return name;
    }

    public float getToughness() {
        return this.toughness;
}

}
