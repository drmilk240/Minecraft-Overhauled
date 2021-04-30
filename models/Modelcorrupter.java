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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}