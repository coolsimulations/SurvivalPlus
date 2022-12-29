package net.coolsimulations.SurvivalPlus.api.item;

import java.util.function.Supplier;

import net.coolsimulations.SurvivalPlus.api.SPTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

public class SPArmorMaterial implements ArmorMaterial {
	
	public static final ArmorMaterial bronzeArmorMaterial = new SPArmorMaterial("bronze", 20, new int[] {2, 5, 5, 2}, 20, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> {
    	return Ingredient.of(SPTags.Items.INGOTS_BRONZE);
    });
	
	public static final ArmorMaterial stoneArmorMaterial = new SPArmorMaterial("stone", 20, new int[] {1, 2, 4, 2}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.COBBLESTONE);
    });
	
	public static final ArmorMaterial titaniumArmorMaterial = new SPArmorMaterial("titanium", 20, new int[] {3, 5, 7, 3}, 20, SoundEvents.ARMOR_EQUIP_GOLD, 1.0F, () -> {
    	return Ingredient.of(SPTags.Items.INGOTS_TITANIUM);
    });
	
	public static final ArmorMaterial oakArmorMaterial = new SPArmorMaterial("oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial spruceArmorMaterial = new SPArmorMaterial("spruce", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial birchArmorMaterial = new SPArmorMaterial("birch", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial jungleArmorMaterial = new SPArmorMaterial("jungle", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial acaciaArmorMaterial = new SPArmorMaterial("acacia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial darkOakArmorMaterial = new SPArmorMaterial("dark_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial crimsonArmorMaterial = new SPArmorMaterial("crimson", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial warpedArmorMaterial = new SPArmorMaterial("warped", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial mangroveArmorMaterial = new SPArmorMaterial("mangrove", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial rubberArmorMaterial = new SPArmorMaterial("rubber", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(ItemTags.create(new ResourceLocation("ic2:", "rubber_logs")));
    });
	
	public static final ArmorMaterial cherryArmorMaterial = new SPArmorMaterial("cherry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial deadArmorMaterial = new SPArmorMaterial("dead", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial etherealArmorMaterial = new SPArmorMaterial("ethereal", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial firArmorMaterial = new SPArmorMaterial("fir", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial hellbarkArmorMaterial = new SPArmorMaterial("hellbark", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial jacarandaArmorMaterial = new SPArmorMaterial("jacaranda", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial magicArmorMaterial = new SPArmorMaterial("magic", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial mahoganyArmorMaterial = new SPArmorMaterial("mahogany", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial palmArmorMaterial = new SPArmorMaterial("palm", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial redwoodArmorMaterial = new SPArmorMaterial("redwood", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial umbranArmorMaterial = new SPArmorMaterial("umbran", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial willowArmorMaterial = new SPArmorMaterial("willow", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial ebonyArmorMaterial = new SPArmorMaterial("ebony", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial eucalyptusArmorMaterial = new SPArmorMaterial("eucalyptus", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial pineArmorMaterial = new SPArmorMaterial("pine", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial sacredOakArmorMaterial = new SPArmorMaterial("sacred_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial desertAcaciaArmorMaterial = new SPArmorMaterial("desert_acacia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial balsaArmorMaterial = new SPArmorMaterial("balsa", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial baobabArmorMaterial = new SPArmorMaterial("baobab", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial cherryForestryArmorMaterial = new SPArmorMaterial("cherry_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial chestnutArmorMaterial = new SPArmorMaterial("chestnut", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial citrusArmorMaterial = new SPArmorMaterial("citrus", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial cocoboloArmorMaterial = new SPArmorMaterial("cocobolo", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial ebonyForestryArmorMaterial = new SPArmorMaterial("ebony_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial giantSequoiaArmorMaterial = new SPArmorMaterial("giant_sequoia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial greenheartArmorMaterial = new SPArmorMaterial("greenheart", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial ipeArmorMaterial = new SPArmorMaterial("ipe", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial kapokArmorMaterial = new SPArmorMaterial("kapok", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial larchArmorMaterial = new SPArmorMaterial("larch", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial limeArmorMaterial = new SPArmorMaterial("lime", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial mahoeArmorMaterial = new SPArmorMaterial("mahoe", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial mahoganyForestryArmorMaterial = new SPArmorMaterial("mahogany_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial mapleArmorMaterial = new SPArmorMaterial("maple", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial padaukArmorMaterial = new SPArmorMaterial("padauk", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial palmForestryArmorMaterial = new SPArmorMaterial("palm_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial papayaArmorMaterial = new SPArmorMaterial("papaya", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial pineForestryArmorMaterial = new SPArmorMaterial("pine_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial plumArmorMaterial = new SPArmorMaterial("plum", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial poplarArmorMaterial = new SPArmorMaterial("poplar", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial sequoiaArmorMaterial = new SPArmorMaterial("sequoia", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial teakArmorMaterial = new SPArmorMaterial("teak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial walnutArmorMaterial = new SPArmorMaterial("walnut", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	public static final ArmorMaterial wengeArmorMaterial = new SPArmorMaterial("wenge", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial willowForestryArmorMaterial = new SPArmorMaterial("willow_forestry", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial zebrawoodArmorMaterial = new SPArmorMaterial("zebrawood", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial firTraverseArmorMaterial = new SPArmorMaterial("fir_traverse", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial bambooArmorMaterial = new SPArmorMaterial("bamboo", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Blocks.BAMBOO);
    });
	
	public static final ArmorMaterial skyrootArmorMaterial = new SPArmorMaterial("skyroot", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
	public static final ArmorMaterial goldenOakArmorMaterial = new SPArmorMaterial("golden_oak", 20, new int[] {1, 2, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, () -> {
    	return Ingredient.of(Tags.Items.RODS_WOODEN);
    });
	
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
