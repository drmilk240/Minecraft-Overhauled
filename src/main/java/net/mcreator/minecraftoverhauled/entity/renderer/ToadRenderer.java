package net.mcreator.minecraftoverhauled.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.minecraftoverhauled.entity.ToadEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ToadRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ToadEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeltoad(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_overhauled:textures/toad.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modeltoad extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer rbacktoe_r1_r1;
		private final ModelRenderer Body;
		private final ModelRenderer rbacktoe_r1_r2;
		private final ModelRenderer LFrontLeg;
		private final ModelRenderer rbacktoe_r1_r3;
		private final ModelRenderer RFrontLeg;
		private final ModelRenderer rbacktoe_r1_r4;
		private final ModelRenderer LBackLeg;
		private final ModelRenderer rbacktoe_r1_r5;
		private final ModelRenderer RBackLeg;
		private final ModelRenderer rbacktoe_r1_r6;
		public Modeltoad() {
			textureWidth = 32;
			textureHeight = 32;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 19.0F, -4.0F);
			rbacktoe_r1_r1 = new ModelRenderer(this);
			rbacktoe_r1_r1.setRotationPoint(0.0F, 5.0F, 4.0F);
			Head.addChild(rbacktoe_r1_r1);
			setRotationAngle(rbacktoe_r1_r1, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r1.setTextureOffset(0, 14).addBox(-7.0F, -7.0F, -3.0F, 3.0F, 5.0F, 6.0F, 0.0F, false);
			rbacktoe_r1_r1.setTextureOffset(0, 25).addBox(-6.0F, -8.0F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			rbacktoe_r1_r1.setTextureOffset(24, 24).addBox(-6.0F, -8.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 20.0F, 0.0F);
			rbacktoe_r1_r2 = new ModelRenderer(this);
			rbacktoe_r1_r2.setRotationPoint(0.0F, 4.0F, 0.0F);
			Body.addChild(rbacktoe_r1_r2);
			setRotationAngle(rbacktoe_r1_r2, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r2.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
			LFrontLeg = new ModelRenderer(this);
			LFrontLeg.setRotationPoint(5.0F, 21.0F, -3.0F);
			rbacktoe_r1_r3 = new ModelRenderer(this);
			rbacktoe_r1_r3.setRotationPoint(-5.0F, 3.0F, 3.0F);
			LFrontLeg.addChild(rbacktoe_r1_r3);
			setRotationAngle(rbacktoe_r1_r3, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r3.setTextureOffset(24, 0).addBox(-4.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			RFrontLeg = new ModelRenderer(this);
			RFrontLeg.setRotationPoint(-5.0F, 21.0F, -3.0F);
			rbacktoe_r1_r4 = new ModelRenderer(this);
			rbacktoe_r1_r4.setRotationPoint(5.0F, 3.0F, 3.0F);
			RFrontLeg.addChild(rbacktoe_r1_r4);
			setRotationAngle(rbacktoe_r1_r4, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r4.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, 4.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			LBackLeg = new ModelRenderer(this);
			LBackLeg.setRotationPoint(5.0F, 21.0F, 2.0F);
			rbacktoe_r1_r5 = new ModelRenderer(this);
			rbacktoe_r1_r5.setRotationPoint(-5.0F, 3.0F, -2.0F);
			LBackLeg.addChild(rbacktoe_r1_r5);
			setRotationAngle(rbacktoe_r1_r5, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r5.setTextureOffset(18, 19).addBox(1.0F, -4.5F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			rbacktoe_r1_r5.setTextureOffset(16, 24).addBox(1.75F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			RBackLeg = new ModelRenderer(this);
			RBackLeg.setRotationPoint(-5.0F, 21.0F, 2.0F);
			rbacktoe_r1_r6 = new ModelRenderer(this);
			rbacktoe_r1_r6.setRotationPoint(5.0F, 3.0F, -2.0F);
			RBackLeg.addChild(rbacktoe_r1_r6);
			setRotationAngle(rbacktoe_r1_r6, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r6.setTextureOffset(12, 14).addBox(1.0F, -4.5F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			rbacktoe_r1_r6.setTextureOffset(22, 14).addBox(1.75F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			LFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			RFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			RBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.RFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.LFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
