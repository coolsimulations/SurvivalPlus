package net.coolsimulations.SurvivalPlus.core;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.coolsimulations.SurvivalPlus.api.SPCompatibilityManager;

public class SurvivalPlusMixinPlugin implements IMixinConfigPlugin {
	
	@Override
	public void onLoad(String mixinPackage) {
		
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		if (mixinClassName == "net.coolsimulations.SurvivalPlus.core.mixin.FasterObsidianEnchantmentMixin"
				|| mixinClassName == "net.coolsimulations.SurvivalPlus.core.mixin.QuickUseEnchantmentMixin")
			return SPCompatibilityManager.isGobberLoaded();
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
		
	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		
	}

}