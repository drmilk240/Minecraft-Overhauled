// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelhook extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public Modelhook() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-0.5F, -4.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.5F, -4.0F, -4.25F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.5236F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 2).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(2.25F, -1.5F, -3.5F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.6109F, 0.6109F);
		cube_r2.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-0.25F, -3.0F, -5.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.48F, -0.6109F);
		cube_r3.setTextureOffset(0, 1).addBox(-2.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
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