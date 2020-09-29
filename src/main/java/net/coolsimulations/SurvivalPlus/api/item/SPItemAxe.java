package net.coolsimulations.SurvivalPlus.api.item;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.oredict.OreDictionary;

public class SPItemAxe extends ItemTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
    public final String oreDictionary;
    
    public SPItemAxe(Item.ToolMaterial material, float damage, float speed, String oreDictionary)
    {
        super(material, EFFECTIVE_ON);
        this.attackDamage = damage;
        this.attackSpeed = speed;
        this.oreDictionary = oreDictionary;
        this.setHarvestLevel("axe", material.getHarvestLevel());
    }
    
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack stack)
    {
    	List<ItemStack> acceptableItems = OreDictionary.getOres(oreDictionary);
    	for(ItemStack i : acceptableItems ){
    		if(ItemStack.areItemsEqual(i, stack) && this.oreDictionary != null) return true;
    	}
    	return false;
    }

    public boolean canDisableShield(ItemStack stack, ItemStack shield, EntityLivingBase entity, EntityLivingBase attacker)
    {
        return stack.getItem() instanceof SPItemAxe;
    }
 
}