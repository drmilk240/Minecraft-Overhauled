package net.mcreator.minecraftoverhauled.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.minecraftoverhauled.entity.CorrupterEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CorrupterRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CorrupterEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcorrupter(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_overhauled:textures/corrupter.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("minecraft_overhauled:textures/corrupterglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelcorrupter extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer Head;
		public Modelcorrupter() {
			textureWidth = 64;
			textureHeight = 64;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 11.0F, 0.0F);
			setRotationAngle(Body, 0.1745F, 0.0F, 0.0F);
			Body.setTextureOffset(0, 13).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(18, 1).addBox(-4.0F, 5.0F, 2.0F, 8.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 1).addBox(-3.0F, 6.0F, 2.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 14).addBox(-3.0F, 7.0F, 2.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(20, 3).addBox(-2.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 0).addBox(1.0F, 6.0F, 2.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 15).addBox(2.0F, 7.0F, 2.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(20, 15).addBox(2.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(18, 0).addBox(-4.0F, 5.0F, -2.0F, 8.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(18, 2).addBox(-4.0F, 6.0F, -2.0F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 4).addBox(-3.0F, 7.0F, -2.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(22, 3).addBox(-3.0F, 8.0F, -2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 5).addBox(1.0F, 6.0F, -2.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(0, 16).addBox(1.0F, 7.0F, -2.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(20, 16).addBox(2.0F, 8.0F, -2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Body.setTextureOffset(18, 1).addBox(-4.0F, 5.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(0, 0).addBox(-4.0F, 6.0F, -2.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(0, 0).addBox(-4.0F, 7.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			Body.setTextureOffset(4, 1).addBox(-4.0F, 8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(18, 0).addBox(4.0F, 5.0F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(18, 2).addBox(4.0F, 6.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(0, 11).addBox(4.0F, 6.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			Body.setTextureOffset(20, 12).addBox(4.0F, 7.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 8.0F, -1.0F);
			Head.setTextureOffset(0, 0).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
