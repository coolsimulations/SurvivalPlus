package net.coolsimulations.SurvivalPlus.api;

import net.minecraft.entity.damage.DamageSource;

public class SPDamageSource extends DamageSource {

	protected SPDamageSource(String name) {
		super(name);
	}

	public static final DamageSource BOILED_WATER = new SPDamageSource("boiled_water");
	
}
