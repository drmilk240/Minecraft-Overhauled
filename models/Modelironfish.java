// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelironfish extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;

	public Modelironfish() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 3.0F, 7.0F, 0.0F, false);
		bb_main.setTextureOffset(10, 12).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 12).addBox(0.0F, -2.5F, 3.0F, 0.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 3).addBox(0.0F, -4.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 10).addBox(-2.0F, -2.25F, -8.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(10, 10).addBox(-2.0F, -1.75F, -8.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.1745F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(1.0F, -0.75F, -5.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.1745F, 0.0F);
		cube_r2.setTextureOffset(0, 3).addBox(-3.0F, -0.75F, -5.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);
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