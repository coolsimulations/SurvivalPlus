package net.coolsimulations.SurvivalPlus.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.platform.GlStateManager;

import net.coolsimulations.SurvivalPlus.api.item.SPItemShield;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.texture.TextureCache;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Mixin(BuiltinModelItemRenderer.class)
public abstract class BuiltinModelItemRendererMixin {

	private final BannerBlockEntity banner = new BannerBlockEntity();
	private final ShieldEntityModel modelShield = new ShieldEntityModel();

	@Inject(at = @At("HEAD"), method = "render", cancellable = true)
	public void render(ItemStack stack, CallbackInfo info)
	{
		Item item = stack.getItem();

		if (item instanceof SPItemShield) {
			if (stack.getSubTag("BlockEntityTag") != null) {
				this.banner.readFrom(stack, ShieldItem.getColor(stack));
				MinecraftClient.getInstance().getTextureManager()
				.bindTexture(new TextureCache.Manager("shield_", new Identifier(Registry.ITEM.getId(item).getNamespace(), "textures/entity/" + Registry.ITEM.getId(item).getPath() + "_base.png"), "textures/entity/shield/").get(this.banner.getPatternCacheKey(), this.banner.getPatterns(), this.banner.getPatternColors()));
			} else {
				MinecraftClient.getInstance().getTextureManager().bindTexture(new Identifier(Registry.ITEM.getId(item).getNamespace(), "textures/entity/" + Registry.ITEM.getId(item).getPath() + "_base_nopattern.png"));
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.renderItem();
			if (stack.hasEnchantmentGlint()) {
				ShieldEntityModel var10001 = this.modelShield;
				this.renderEnchantmentGlint(var10001::renderItem);
			}

			GlStateManager.popMatrix();
			info.cancel();
			return;
		}
	}

	@Shadow
	public abstract void renderEnchantmentGlint(Runnable runnable);

}
