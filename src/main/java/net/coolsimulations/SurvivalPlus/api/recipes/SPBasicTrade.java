package net.coolsimulations.SurvivalPlus.api.recipes;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

public class SPBasicTrade implements TradeOffers.Factory {
	private final Item buy;
	private final Item sell;
	private final int buyPrice;
	private final int sellPrice;
	private final int maxUses;
	private final int experience;
	private final float multiplier;

	public SPBasicTrade(ItemStack buyStack, ItemStack sellStack, int maxUses, int experience, float multiplier) {
		this.buy = buyStack.getItem();
		this.sell = sellStack.getItem();
		this.buyPrice = buyStack.getCount();
		this.sellPrice = sellStack.getCount();
		this.maxUses = maxUses;
		this.experience = experience;
		this.multiplier = multiplier;
	}

	public SPBasicTrade(ItemStack buyStack, ItemStack sellStack, int maxUses, int experience) {
		this.buy = buyStack.getItem();
		this.sell = sellStack.getItem();
		this.buyPrice = buyStack.getCount();
		this.sellPrice = sellStack.getCount();
		this.maxUses = maxUses;
		this.experience = experience;
		this.multiplier = 0.05F;
	}
	
	public SPBasicTrade(int price, ItemStack sellStack, int maxUses, int experience, float multiplier) {
		this.buy = Items.EMERALD;
		this.sell = sellStack.getItem();
		this.buyPrice = price;
		this.sellPrice = sellStack.getCount();
		this.maxUses = maxUses;
		this.experience = experience;
		this.multiplier = multiplier;
	}

	public SPBasicTrade(int price, ItemStack sellStack, int maxUses, int experience) {
		this.buy = Items.EMERALD;
		this.sell = sellStack.getItem();
		this.buyPrice = price;
		this.sellPrice = sellStack.getCount();
		this.maxUses = maxUses;
		this.experience = experience;
		this.multiplier = 0.05F;
	}

	public TradeOffer create(Entity entity, Random random) {
		ItemStack itemStack = new ItemStack(this.buy, this.buyPrice);
		ItemStack sellStack = new ItemStack(this.sell, this.sellPrice);
		return new TradeOffer(itemStack, sellStack, this.maxUses, this.experience, this.multiplier);
	}
}
