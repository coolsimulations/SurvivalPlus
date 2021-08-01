package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;

public enum SPItemTier implements Tier {
	bronzeToolMaterial(2, 350, 5.0F, 1.5F, 7, () -> {
		return Ingredient.of(SPTags.Items.INGOTS_BRONZE);
	}),
	//3, 731, 7f, 2.5f, 16
	titaniumToolMaterial(2, 432, 7.0F, 2.5F, 17, () -> {
		return Ingredient.of(SPTags.Items.INGOTS_TITANIUM);
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyLoadedValue<Ingredient> repairMaterial;

	SPItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyLoadedValue(repairMaterialIn);
	}

	public int getUses() {
		return this.maxUses;
	}

	public float getSpeed() {
		return this.efficiency;
	}

	public float getAttackDamageBonus() {
		return this.attackDamage;
	}

	public int getLevel() {
		return this.harvestLevel;
	}

	public int getEnchantmentValue() {
		return this.enchantability;
	}

	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}
}