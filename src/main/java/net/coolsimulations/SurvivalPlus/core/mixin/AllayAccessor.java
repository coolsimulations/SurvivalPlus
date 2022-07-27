package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.item.crafting.Ingredient;

@Mixin(Allay.class)
public interface AllayAccessor {

	@Accessor("DUPLICATION_ITEM")
	@Mutable
	public static Ingredient getDupeItem() {
		throw new AssertionError();
	}
	
	@Accessor("DUPLICATION_ITEM")
	@Mutable
	public static void setDupeItem(Ingredient ingredients) {
		throw new AssertionError();
	}
}
