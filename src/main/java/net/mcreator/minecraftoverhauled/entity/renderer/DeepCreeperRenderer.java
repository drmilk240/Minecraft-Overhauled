package net.mcreator.minecraftoverhauled.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.minecraftoverhauled.entity.DeepCreeperEntity;

@OnlyIn(Dist.CLIENT)
public class DeepCreeperRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DeepCreeperEntity.entity,
					renderManager -> new MobRenderer(renderManager, new CreeperModel(), 0.5f) {
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("minecraft_overhauled:textures/creeper.png");
						}
					});
		}
	}
}
