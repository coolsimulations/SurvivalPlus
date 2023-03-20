package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class SPDamageSource {

	public static final ResourceKey<DamageType> BOILED_WATER = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SPReference.MOD_ID, "boiled_water"));
	
}
