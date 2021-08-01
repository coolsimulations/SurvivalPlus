package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

public enum SPArmorMaterial implements ArmorMaterial {
	bronzeArmorMaterial("bronze", 20, new int[] {2, 5, 5, 2}, 20, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> {
    	return Ingredient.of(SPTags.Items.INGOTS_BRONZE);
    }),
    stoneArmorMaterial("stone", 20, new int[] {1, 2, 4, 2}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.COBBLESTONE);
    }),
    titaniumArmorMaterial("titanium", 20, new int[] {3, 5, 7, 3}, 20, SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, () -> {
    	return Ingredient.of(SPTags.Items.INGOTS_TITANIUM);
    }),
    oakArmorMaterial("oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    spruceArmorMaterial("spruce", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    birchArmorMaterial("birch", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    jungleArmorMaterial("jungle", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    acaciaArmorMaterial("acacia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    darkOakArmorMaterial("dark_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    crimsonArmorMaterial("crimson", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    warpedArmorMaterial("warped", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    rubberArmorMaterial("rubber", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of((Tag<Item>) ItemTags.bind("minecraft:" + "rubber_logs"));
    }),
    cherryArmorMaterial("cherry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    deadArmorMaterial("dead", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    etherealArmorMaterial("ethereal", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    firArmorMaterial("fir", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    hellbarkArmorMaterial("hellbark", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    jacarandaArmorMaterial("jacaranda", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    magicArmorMaterial("magic", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    mahoganyArmorMaterial("mahogany", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    palmArmorMaterial("palm", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    redwoodArmorMaterial("redwood", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    umbranArmorMaterial("umbran", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    willowArmorMaterial("willow", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    ebonyArmorMaterial("ebony", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    eucalyptusArmorMaterial("eucalyptus", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    mangroveArmorMaterial("mangrove", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    pineArmorMaterial("pine", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    sacredOakArmorMaterial("sacred_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    desertAcaciaArmorMaterial("desert_acacia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    balsaArmorMaterial("balsa", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    baobabArmorMaterial("baobab", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    cherryForestryArmorMaterial("cherry_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    chestnutArmorMaterial("chestnut", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    citrusArmorMaterial("citrus", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    cocoboloArmorMaterial("cocobolo", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    ebonyForestryArmorMaterial("ebony_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    giantSequoiaArmorMaterial("giant_sequoia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    greenheartArmorMaterial("greenheart", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    ipeArmorMaterial("ipe", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    kapokArmorMaterial("kapok", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    larchArmorMaterial("larch", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    limeArmorMaterial("lime", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    mahoeArmorMaterial("mahoe", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    mahoganyForestryArmorMaterial("mahogany_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    mapleArmorMaterial("maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    padaukArmorMaterial("padauk", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    palmForestryArmorMaterial("palm_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    papayaArmorMaterial("papaya", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    pineForestryArmorMaterial("pine_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    plumArmorMaterial("plum", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    poplarArmorMaterial("poplar", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    sequoiaArmorMaterial("sequoia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    teakArmorMaterial("teak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    walnutArmorMaterial("walnut", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    wengeArmorMaterial("wenge", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    willowForestryArmorMaterial("willow_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    zebrawoodArmorMaterial("zebrawood", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    firTraverseArmorMaterial("fir_traverse", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    bambooArmorMaterial("bamboo", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Blocks.BAMBOO);
    }),
;
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private LazyLoadedValue<Ingredient> repairMaterial;
    private final String name;
    
    SPArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterialIn) {
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadedValue(repairMaterialIn);
        this.name = name;
}
    
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return name;
    }

    public float getToughness() {
        return this.toughness;
    }

	public float getKnockbackResistance() {
		return 0;
	}

}
