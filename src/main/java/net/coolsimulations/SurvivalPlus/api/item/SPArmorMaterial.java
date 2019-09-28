package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.coolsimulations.SurvivalPlus.api.SPReference;
import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.minecraft.util.SoundEvents;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;

public enum SPArmorMaterial implements IArmorMaterial {
	bronzeArmorMaterial("bronze", 20, new int[] {2, 6, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
    	return Ingredient.fromTag(SPTags.Items.INGOTS_BRONZE);
    }),
    stoneArmorMaterial("stone", 20, new int[] {1, 2, 4, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.COBBLESTONE);
    }),
    titaniumArmorMaterial("titanium", 20, new int[] {3, 2, 5, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, () -> {
    	return Ingredient.fromTag(SPTags.Items.INGOTS_TITANIUM);
    }),
    oakArmorMaterial("oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    spruceArmorMaterial("spruce", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    birchArmorMaterial("birch", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    jungleArmorMaterial("jungle", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    acaciaArmorMaterial("acacia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    darkOakArmorMaterial("dark_oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    rubberArmorMaterial("rubber", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(new ItemTags.Wrapper(new ResourceLocation("minecraft", "rubber_logs")));
    }),
    cherryArmorMaterial("cherry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    deadArmorMaterial("dead", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    etherealArmorMaterial("ethereal", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    firArmorMaterial("fir", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    hellbarkArmorMaterial("hellbark", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    jacarandaArmorMaterial("jacaranda", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    magicArmorMaterial("magic", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    mahoganyArmorMaterial("mahogany", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    palmArmorMaterial("palm", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    redwoodArmorMaterial("redwood", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    umbranArmorMaterial("umbran", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    willowArmorMaterial("willow", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    ebonyArmorMaterial("ebony", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    eucalyptusArmorMaterial("eucalyptus", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    mangroveArmorMaterial("mangrove", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    pineArmorMaterial("pine", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    sacredOakArmorMaterial("sacred_oak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    desertAcaciaArmorMaterial("desert_acacia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    balsaArmorMaterial("balsa", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    baobabArmorMaterial("baobab", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    cherryForestryArmorMaterial("cherry_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    chestnutArmorMaterial("chestnut", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    citrusArmorMaterial("citrus", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    cocoboloArmorMaterial("cocobolo", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    ebonyForestryArmorMaterial("ebony_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    giantSequoiaArmorMaterial("giant_sequoia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    greenheartArmorMaterial("greenheart", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    ipeArmorMaterial("ipe", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    kapokArmorMaterial("kapok", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    larchArmorMaterial("larch", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    limeArmorMaterial("lime", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    mahoeArmorMaterial("mahoe", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    mahoganyForestryArmorMaterial("mahogany_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    mapleArmorMaterial("maple", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    padaukArmorMaterial("padauk", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    palmForestryArmorMaterial("palm_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    papayaArmorMaterial("papaya", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    pineForestryArmorMaterial("pine_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    plumArmorMaterial("plum", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    poplarArmorMaterial("poplar", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    sequoiaArmorMaterial("sequoia", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    teakArmorMaterial("teak", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    walnutArmorMaterial("walnut", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    wengeArmorMaterial("wenge", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    willowForestryArmorMaterial("willow_forestry", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
    zebrawoodArmorMaterial("zebrawood", 20, new int[] {1, 2, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.fromTag(Tags.Items.RODS_WOODEN);
    }),
;
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private LazyLoadBase<Ingredient> repairMaterial;
    private final String name;
    
    SPArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterialIn) {
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadBase(repairMaterialIn);
        this.name = name;
}
    
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return name;
    }

    public float getToughness() {
        return this.toughness;
}

}
