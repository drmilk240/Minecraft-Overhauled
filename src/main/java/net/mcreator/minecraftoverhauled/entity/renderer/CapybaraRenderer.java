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

import net.mcreator.minecraftoverhauled.entity.CapybaraEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CapybaraRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CapybaraEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcapybara(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_overhauled:textures/capybara.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelcapybara extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer NeckHead;
		private final ModelRenderer head_r1;
		private final ModelRenderer neck_r1;
		private final ModelRenderer RFrontLeg;
		private final ModelRenderer LFrontLeg;
		private final ModelRenderer RBackLeg;
		private final ModelRenderer rbackthigh_r1;
		private final ModelRenderer LBackLeg;
		private final ModelRenderer lbackthigh_r1;
		public Modelcapybara() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 8.5F, 3.0F);
			Body.setTextureOffset(0, 0).addBox(-7.0F, -5.5F, -11.0F, 14.0F, 13.0F, 22.0F, 0.0F, false);
			NeckHead = new ModelRenderer(this);
			NeckHead.setRotationPoint(0.0F, 6.0F, -7.0F);
			NeckHead.setTextureOffset(0, 35).addBox(-4.0F, -8.0F, -7.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			NeckHead.setTextureOffset(12, 14).addBox(3.0F, -8.0F, -7.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(0.0F, 18.0F, 7.0F);
			NeckHead.addChild(head_r1);
			setRotationAngle(head_r1, 0.1745F, 0.0F, 0.0F);
			head_r1.setTextureOffset(0, 35).addBox(-5.0F, -25.0F, -18.0F, 10.0F, 8.0F, 13.0F, 0.0F, false);
			neck_r1 = new ModelRenderer(this);
			neck_r1.setRotationPoint(0.0F, 18.0F, 7.0F);
			NeckHead.addChild(neck_r1);
			setRotationAngle(neck_r1, -0.48F, 0.0F, 0.0F);
			neck_r1.setTextureOffset(46, 35).addBox(-4.0F, -17.0F, -19.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
			RFrontLeg = new ModelRenderer(this);
			RFrontLeg.setRotationPoint(-7.0F, 13.0F, -5.0F);
			RFrontLeg.setTextureOffset(46, 49).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 13.0F, 5.0F, 0.0F, false);
			LFrontLeg = new ModelRenderer(this);
			LFrontLeg.setRotationPoint(7.0F, 12.0F, -5.0F);
			LFrontLeg.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 13.0F, 5.0F, 0.0F, false);
			RBackLeg = new ModelRenderer(this);
			RBackLeg.setRotationPoint(-8.0F, 12.0F, 10.0F);
			RBackLeg.setTextureOffset(18, 56).addBox(-1.0F, 6.0F, -1.0F, 3.0F, 6.0F, 4.0F, 0.0F, false);
			rbackthigh_r1 = new ModelRenderer(this);
			rbackthigh_r1.setRotationPoint(8.0F, 12.0F, -10.0F);
			RBackLeg.addChild(rbackthigh_r1);
			setRotationAngle(rbackthigh_r1, 0.2618F, 0.0F, 0.0F);
			rbackthigh_r1.setTextureOffset(50, 0).addBox(-9.0F, -11.0F, 10.0F, 3.0F, 9.0F, 6.0F, 0.0F, false);
			LBackLeg = new ModelRenderer(this);
			LBackLeg.setRotationPoint(8.0F, 12.0F, 10.0F);
			LBackLeg.setTextureOffset(32, 56).addBox(-2.0F, 6.0F, -1.0F, 3.0F, 6.0F, 4.0F, 0.0F, false);
			lbackthigh_r1 = new ModelRenderer(this);
			lbackthigh_r1.setRotationPoint(-8.0F, 12.0F, -10.0F);
			LBackLeg.addChild(lbackthigh_r1);
			setRotationAngle(lbackthigh_r1, 0.2618F, 0.0F, 0.0F);
			lbackthigh_r1.setTextureOffset(0, 56).addBox(6.0F, -11.0F, 10.0F, 3.0F, 9.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			NeckHead.render(matrixStack, buffer, packedLight, packedOverlay);
			RFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			RBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RBackLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LBackLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.NeckHead.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.NeckHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
