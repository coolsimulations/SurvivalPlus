package net.coolsimulations.SurvivalPlus.core.recipes;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.level.Level;

public class SPShieldRecipes extends CustomRecipe {
	
	public static final SimpleCraftingRecipeSerializer<SPShieldRecipes> CRAFTING_SPECIAL_SPSHIELD = new SimpleCraftingRecipeSerializer<>(SPShieldRecipes::new);
	
	public SPShieldRecipes(ResourceLocation idIn, CraftingBookCategory category) {
		super(idIn, category);
	}

	@Override
	public boolean matches(CraftingContainer inv, Level worldIn) {
		ItemStack itemstack = ItemStack.EMPTY;
		ItemStack itemstack1 = ItemStack.EMPTY;

		for (int i = 0; i < inv.getContainerSize(); ++i) {
			ItemStack itemstack2 = inv.getItem(i);
			if (!itemstack2.isEmpty()) {
				if (itemstack2.getItem() instanceof BannerItem) {
					if (!itemstack1.isEmpty()) {
						return false;
					}

					itemstack1 = itemstack2;
				} else {
					if (!(itemstack2.getItem() instanceof SPItemShield)) {
						return false;
					}

					if (!itemstack.isEmpty()) {
						return false;
					}

					if (itemstack2.getTagElement("BlockEntityTag") != null) {
						return false;
					}

					itemstack = itemstack2;
				}
			}
		}

		if (!itemstack.isEmpty() && !itemstack1.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack assemble(CraftingContainer inv, RegistryAccess registryAccess) {
		ItemStack itemstack = ItemStack.EMPTY;
		ItemStack itemstack1 = ItemStack.EMPTY;

		for (int i = 0; i < inv.getContainerSize(); ++i) {
			ItemStack itemstack2 = inv.getItem(i);
			if (!itemstack2.isEmpty()) {
				if (itemstack2.getItem() instanceof BannerItem) {
					itemstack = itemstack2;
				} else if (itemstack2.getItem() instanceof SPItemShield) {
					itemstack1 = itemstack2.copy();
				}
			}
		}

		if (itemstack1.isEmpty()) {
			return itemstack1;
		} else {
			CompoundTag compoundnbt = itemstack.getTagElement("BlockEntityTag");
			CompoundTag compoundnbt1 = compoundnbt == null ? new CompoundTag() : compoundnbt.copy();
			compoundnbt1.putInt("Base", ((BannerItem) itemstack.getItem()).getColor().getId());
			itemstack1.addTagElement("BlockEntityTag", compoundnbt1);
			return itemstack1;
		}
	}

	/**
	 * Used to determine if this recipe can fit in a grid of the given width/height
	 */
	@Environment(EnvType.CLIENT)
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width * height >= 2;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return CRAFTING_SPECIAL_SPSHIELD;
	}
}