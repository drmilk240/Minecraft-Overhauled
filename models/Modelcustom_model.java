// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public Modelcustom_model() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -16.0F, 10.0F, 10.0F, 23.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 42).addBox(-2.0F, -8.0F, 7.0F, 6.0F, 7.0F, 12.0F, 0.0F, false);
		bb_main.setTextureOffset(43, 0).addBox(-6.0F, -4.0F, 18.0F, 14.0F, 1.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 13).addBox(0.0F, -4.0F, -24.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1745F, 0.3054F, -0.1745F);
		cube_r1.setTextureOffset(0, 33).addBox(-16.0F, -4.0F, -10.0F, 16.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1745F, -0.3054F, 0.1745F);
		cube_r2.setTextureOffset(40, 34).addBox(2.0F, -4.0F, -10.5F, 16.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.2618F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(0.5F, -12.0F, -5.0F, 1.0F, 4.0F, 9.0F, 0.0F, false);
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