package net.coolsimulations.SurvivalPlus.core.compat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import moze_intel.projecte.api.mapper.EMCMapper;
import moze_intel.projecte.api.mapper.IEMCMapper;
import moze_intel.projecte.api.mapper.collector.IMappingCollector;
import moze_intel.projecte.api.nss.NSSItem;
import moze_intel.projecte.api.nss.NormalizedSimpleStack;
import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;
import net.coolsimulations.SurvivalPlus.api.SPItems;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.ResourceManager;

@EMCMapper
public class SurvivalPlusEMCValues implements IEMCMapper<NormalizedSimpleStack, Long> {
	
	private static final Map<NormalizedSimpleStack, Long> customEmcValues = new HashMap();
	
	@Override
	public String getName() {
		return "SurvivalPlusMapper";
	}
	
	@Override
	public String getDescription() {
		return "Adds EMC Values to SurvivalPlus Items.";
	}
	
	public static void init(){
		
		//SurvivalPlus Tags haven't been working in 1.13 or 1.14, however they do work in SurvivalPlus Lightsabers so I'm assuming that it order of loading related
		//So these lines below do not work, but leaving them there in case other mods tags work
		//Also unsure if ProjectE will make changes to this in 1.16 due to the ITag<> stuff, so this may not work...
		//Leaving this commented out to avoid crashes as I'm not 100% sure if it'll work since SurvivalPlus generally updates to newer versions (ex. 1.17) before ProjectE
		/**registerCustomEMC(NSSItem.createTag(SPTags.Items.INGOTS_COPPER.func_230234_a_()), 55);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.INGOTS_TIN.func_230234_a_()), 256);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.INGOTS_TITANIUM.func_230234_a_()), 2048);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.CROPS_ONION.func_230234_a_()), 64);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.SEEDS_ONION.func_230234_a_()), 32);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.GEMS_AMETHYST.func_230234_a_()), 512);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.GEMS_RUBY.func_230234_a_()), 512);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.GEMS_TOPAZ.func_230234_a_()), 512);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.GEMS_SAPPHIRE.func_230234_a_()), 512);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.GEMS_PEARL.func_230234_a_()), 2048);
		registerCustomEMC(NSSItem.createTag(SPTags.Items.GEMS_SPINEL.func_230234_a_()), 2048);**/
		
		registerCustomEMC(NSSItem.createItem(SPItems.titanium_ingot.get()), 2048);
		registerCustomEMC(NSSItem.createItem(SPItems.raw_onion.get()), 64);
		registerCustomEMC(NSSItem.createItem(SPItems.onion_seeds.get()), 32);
		registerCustomEMC(NSSItem.createItem(SPItems.ruby_shard.get()), 512);
		registerCustomEMC(NSSItem.createItem(SPItems.topaz_shard.get()), 512);
		registerCustomEMC(NSSItem.createItem(SPItems.sapphire_shard.get()), 512);
		registerCustomEMC(NSSItem.createItem(SPItems.pearl.get()), 2048);
		registerCustomEMC(NSSItem.createItem(SPItems.spinel_shard.get()), 2048);
    		
		if (SPCompatibilityManager.isIc2Loaded()) {
			
			registerCustomEMC(NSSItem.createItem(SPItems.crushed_titanium_ore.get()), 1024);
			registerCustomEMC(NSSItem.createItem(SPItems.purified_titanium_ore.get()), 1024);
			registerCustomEMC(NSSItem.createItem(SPItems.titanium_dust.get()), 1024);
			registerCustomEMC(NSSItem.createItem(SPItems.tiny_titanium_pile.get()), (long) 113.7);
		}
    		
    		/**if(SPConfig.enableSponge) {
    			
    			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Blocks.SPONGE), 2496);
    		}**/
	}

	public static void registerCustomEMC(@Nonnull NormalizedSimpleStack stack, long emcValue) {
		customEmcValues.put(stack, emcValue);
	}

	public static void unregisterNSS(@Nonnull NormalizedSimpleStack stack) {
		customEmcValues.remove(stack);
	}

	@Override
	public void addMappings(IMappingCollector<NormalizedSimpleStack, Long> mapper, CommentedFileConfig config, ReloadableServerResources registriy, ResourceManager resourceManager) {
		
		Iterator var4 = customEmcValues.entrySet().iterator();

		while (var4.hasNext()) {
			Entry<NormalizedSimpleStack, Long> entry = (Entry) var4.next();
			NormalizedSimpleStack normStack = (NormalizedSimpleStack) entry.getKey();
			long value = (Long) entry.getValue();
			mapper.setValueBefore(normStack, value);
		}
	}
}
