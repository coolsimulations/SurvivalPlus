package net.coolsimulations.SurvivalPlus.api.item;

import net.coolsimulations.SurvivalPlus.api.SPTabs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Identifier;

public class SPItemShield extends ShieldItem {

	public SPItemShield(int maxDamage) {
		super((new FabricItemSettings()).maxCount(1).maxDamage(maxDamage).group(SPTabs.tabCombat));
		
		FabricModelPredicateProviderRegistry.register(this, new Identifier("blocking"),(itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
		});
	}
}
