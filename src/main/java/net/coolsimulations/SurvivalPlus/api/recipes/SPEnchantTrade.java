package net.coolsimulations.SurvivalPlus.api.recipes;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

public class SPEnchantTrade implements TradeOffers.Factory {
	private final ItemStack tool;
    private final int sellPrice;
    private final int maxUses;
    private final int experience;
    private final float multiplier;

    public SPEnchantTrade(int sellPrice, Item item, int maxUses, int experience, float multiplier) {
       this.tool = new ItemStack(item);
       this.sellPrice = sellPrice;
       this.maxUses = maxUses;
       this.experience = experience;
       this.multiplier = multiplier;
    }
    
    public SPEnchantTrade(int sellPrice, Item item, int maxUses, int experience) {
    	this.tool = new ItemStack(item);
        this.sellPrice = sellPrice;
        this.maxUses = maxUses;
        this.experience = experience;
        this.multiplier = 0.05F;
    }

	public TradeOffer create(Entity entity, Random random) {
		int i = 5 + random.nextInt(15);
        ItemStack itemStack = EnchantmentHelper.enchant(random, new ItemStack(this.tool.getItem()), i, false);
        ItemStack itemStack2 = new ItemStack(Items.EMERALD, this.sellPrice);
        return new TradeOffer(itemStack2, itemStack, this.maxUses, this.experience, this.multiplier);
	}
}
