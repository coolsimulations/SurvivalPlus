package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;

public enum SPItemTier implements ToolMaterial {
    bronzeToolMaterial(2, 350, 5.0F, 1.5F, 7, () -> {
    	return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "bronze_ingots")));
    }),
    //3, 731, 7f, 2.5f, 16
    titaniumToolMaterial(2, 432, 7.0F, 2.5F, 17, () -> {
        return Ingredient.fromTag(new ItemTags.CachingTag(new Identifier("c", "titanium_ingots")));
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairMaterial;

    SPItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new Lazy(repairMaterialIn);
    }

    public int getDurability() {
        return this.maxUses;
    }

    public float getMiningSpeed() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}