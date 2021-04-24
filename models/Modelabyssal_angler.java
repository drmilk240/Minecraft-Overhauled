// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelabyssal_angler extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public Modelabyssal_angler() {
		textureWidth = 512;
		textureHeight = 512;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-35.0F, -40.0F, -27.0F, 39.0F, 40.0F, 70.0F, 0.0F, false);
		bb_main.setTextureOffset(148, 0).addBox(-30.0F, -33.0F, 43.0F, 29.0F, 31.0F, 26.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-17.0F, -35.0F, 95.0F, 3.0F, 36.0F, 26.0F, 0.0F, false);
		bb_main.setTextureOffset(120, 158).addBox(-27.0F, -23.0F, 69.0F, 23.0F, 19.0F, 26.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 203).addBox(-20.0F, -53.0F, -72.0F, 10.0F, 13.0F, 10.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 10).addBox(-9.0F, -33.0F, -29.0F, 9.0F, 7.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-30.0F, -33.0F, -29.0F, 9.0F, 7.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(32, 0).addBox(-32.0F, -29.0F, -42.0F, 3.0F, 13.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(44, 0).addBox(-24.0F, -26.0F, -42.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(32, 0).addBox(-13.0F, -31.0F, -42.0F, 3.0F, 13.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(32, 0).addBox(-2.0F, -28.0F, -42.0F, 3.0F, 13.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(53, 11).addBox(-7.0F, -26.0F, -42.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(41, 14).addBox(-19.0F, -24.0F, -42.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(44, 0).addBox(-28.0F, -25.0F, -42.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.6981F);
		cube_r1.setTextureOffset(188, 80).addBox(-42.0F, -30.0F, -9.0F, 24.0F, 2.0F, 30.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.6981F);
		cube_r2.setTextureOffset(188, 173).addBox(-5.0F, -10.0F, -9.0F, 24.0F, 2.0F, 30.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.8727F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 110).addBox(-17.0F, -21.0F, -85.0F, 3.0F, 41.0F, 6.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.6545F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(192, 112).addBox(-17.0F, -85.0F, 11.0F, 3.0F, 56.0F, 6.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.1745F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 110).addBox(-17.0F, -57.0F, -23.0F, 3.0F, 36.0F, 57.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3491F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(63, 110).addBox(-35.0F, -33.0F, -35.0F, 39.0F, 24.0F, 24.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
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
}