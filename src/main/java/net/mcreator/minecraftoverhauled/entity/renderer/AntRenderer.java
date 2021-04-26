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

import net.mcreator.minecraftoverhauled.entity.AntEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AntRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(AntEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelant(), 0.05f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("minecraft_overhauled:textures/ant.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelant extends EntityModel<Entity> {
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		public Modelant() {
			textureWidth = 16;
			textureHeight = 16;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.5236F);
			cube_r1.setTextureOffset(0, 0).addBox(-1.25F, -1.25F, 0.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-1.25F, -1.25F, -0.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-1.25F, -1.25F, -1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.5236F);
			cube_r2.setTextureOffset(0, 0).addBox(-0.5F, -0.75F, -1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 0).addBox(-0.5F, -0.75F, 0.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.cube_r1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.cube_r2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
