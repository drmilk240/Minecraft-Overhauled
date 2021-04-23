// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modeltoad extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer rbacktoe_r1;

	public Modeltoad() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		rbacktoe_r1 = new ModelRenderer(this);
		rbacktoe_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(rbacktoe_r1);
		setRotationAngle(rbacktoe_r1, 0.0F, -1.5708F, 0.0F);
		rbacktoe_r1.setTextureOffset(22, 14).addBox(1.75F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(12, 14).addBox(1.0F, -4.5F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(16, 24).addBox(1.75F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(18, 19).addBox(1.0F, -4.5F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, 4.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(24, 0).addBox(-4.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(24, 24).addBox(-6.0F, -8.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(0, 25).addBox(-6.0F, -8.0F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(0, 14).addBox(-7.0F, -7.0F, -3.0F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		rbacktoe_r1.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}