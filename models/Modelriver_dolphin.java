// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelriver_dolphin extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer cube_r3;
	private final ModelRenderer Tail;
	private final ModelRenderer BackFin;
	private final ModelRenderer RightFin;
	private final ModelRenderer cube_r1;
	private final ModelRenderer LeftFin;
	private final ModelRenderer cube_r2;

	public Modelriver_dolphin() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(1.0F, 20.0F, -5.0F);
		Body.setTextureOffset(0, 0).addBox(-5.0F, -6.0F, -11.0F, 10.0F, 10.0F, 23.0F, 0.0F, false);
		Body.setTextureOffset(0, 13).addBox(-1.0F, 0.0F, -19.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-1.0F, 4.0F, 5.0F);
		Body.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.2618F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(0.5F, -12.0F, -5.0F, 1.0F, 4.0F, 9.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -1.0F, 12.0F);
		Body.addChild(Tail);
		Tail.setTextureOffset(0, 42).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 12.0F, 0.0F, false);

		BackFin = new ModelRenderer(this);
		BackFin.setRotationPoint(0.0F, 2.0F, 11.0F);
		Tail.addChild(BackFin);
		BackFin.setTextureOffset(43, 0).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 1.0F, 8.0F, 0.0F, false);

		RightFin = new ModelRenderer(this);
		RightFin.setRotationPoint(-5.0F, 3.0F, -2.0F);
		Body.addChild(RightFin);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(4.0F, 1.0F, 7.0F);
		RightFin.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1745F, 0.3054F, -0.1745F);
		cube_r1.setTextureOffset(0, 33).addBox(-16.0F, -4.0F, -10.0F, 16.0F, 1.0F, 8.0F, 0.0F, false);

		LeftFin = new ModelRenderer(this);
		LeftFin.setRotationPoint(5.0F, 3.0F, -2.0F);
		Body.addChild(LeftFin);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-6.0F, 1.0F, 7.0F);
		LeftFin.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1745F, -0.3054F, 0.1745F);
		cube_r2.setTextureOffset(40, 34).addBox(2.0F, -4.0F, -10.5F, 16.0F, 1.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.BackFin.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Tail.rotateAngleX = f3 / (180F / (float) Math.PI);
		this.Body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Body.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}