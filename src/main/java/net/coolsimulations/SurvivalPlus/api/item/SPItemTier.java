package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeMod;

import java.util.function.Supplier;

public enum SPItemTier implements IItemTier {
    bronzeToolMaterial(2, 350, 5.0F, 1.5F, 7, () -> {
    	return Ingredient.fromTag(new ItemTags.Wrapper(new ResourceLocation(ForgeMod.getInstance().getModId(), "ingots/bronze")));
    }),
    //3, 731, 7f, 2.5f, 16
    titaniumToolMaterial(2, 432, 7.0F, 2.5F, 17, () -> {
        return Ingredient.fromTag(new ItemTags.Wrapper(new ResourceLocation(ForgeMod.getInstance().getModId(), "ingots/titanium")));
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    SPItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}