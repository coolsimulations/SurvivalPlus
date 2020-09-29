package net.coolsimulations.SurvivalPlus.api.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.oredict.OreDictionary;

public class SPItemShield extends ItemShield{

	public final String oreDictionary;

	public SPItemShield(int maxDamage, String oreDictionary)
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
		this.oreDictionary = oreDictionary;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.getSubCompound("BlockEntityTag") != null)
		{
			EnumDyeColor enumdyecolor = TileEntityBanner.getColor(stack);
			return I18n.translateToLocal(this.getUnlocalizedName() + "." + enumdyecolor.getUnlocalizedName() + ".name");
		}
		else
		{
			return I18n.translateToLocal(this.getUnlocalizedName() + ".name");
		}
	}

	@Override
	public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity)
	{
		return true;
	}

}
