package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum SPArmorMaterial implements ArmorMaterial {
	bronzeArmorMaterial("bronze", 20, new int[] {2, 5, 5, 2}, 20, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "bronze_ingots")));
    }),
    stoneArmorMaterial("stone", 20, new int[] {1, 2, 4, 2}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "cobblestones")));
    }),
    titaniumArmorMaterial("titanium", 20, new int[] {3, 5, 7, 3}, 20, SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "titanium_ingots")));
    }),
    oakArmorMaterial("oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    spruceArmorMaterial("spruce", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    birchArmorMaterial("birch", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    jungleArmorMaterial("jungle", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    acaciaArmorMaterial("acacia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    darkOakArmorMaterial("dark_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    crimsonArmorMaterial("crimson", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    warpedArmorMaterial("warped", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    mangroveArmorMaterial("mangrove", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    bambooArmorMaterial("bamboo", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "bamboos")));
    }),
    firTraverseArmorMaterial("fir_traverse", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    redwoodTerrestriaArmorMaterial("redwood_terrestria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    hemlockArmorMaterial("hemlock", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    rubberTerrestriaArmorMaterial("rubber_terrestria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    cypressArmorMaterial("cypress", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    willowTerrestriaArmorMaterial("willow_terrestria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    japaneseMapleArmorMaterial("japanese_maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    rainbowEucalyptusArmorMaterial("rainbow_eucalyptus", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    sakuraArmorMaterial("sakura", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    yuccaPalmArmorMaterial("yucca_palm", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    whiteOakArmorMaterial("white_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    redwoodVanillaEnhancedArmorMaterial("redwood_vanilla_enhanced", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    skyrootArmorMaterial("skyroot", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    goldenOakArmorMaterial("golden_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    orangeArmorMaterial("orange", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    crystalArmorMaterial("crystal", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    }),
    wisteriaArmorMaterial("wisteria", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("c", "wood_sticks")));
    });
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private LazyLoadedValue<Ingredient> repairMaterial;
    private final String name;
    
    SPArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterialIn) {
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadedValue(repairMaterialIn);
        this.name = name;
}
    
    public int getDurabilityForType(Type slotIn) {
        return MAX_DAMAGE_ARRAY[MAX_DAMAGE_ARRAY.length - 1 - slotIn.ordinal()] * this.maxDamageFactor;
    }

    public int getDefenseForType(Type slotIn) {
        return this.damageReductionAmountArray[this.damageReductionAmountArray.length - 1 - slotIn.ordinal()];
    }

    public int getEnchantmentValue() {
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

	@Override
	public float getKnockbackResistance() {
		return 0;
	}

}
