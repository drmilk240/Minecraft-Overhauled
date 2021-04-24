
package net.mcreator.minecraftoverhauled.entity;

import net.minecraft.block.material.Material;

@MinecraftOverhauledModElements.ModElement.Tag
public class PiranhaEntity extends MinecraftOverhauledModElements.ModElement {

	public static EntityType entity = null;

	public PiranhaEntity(MinecraftOverhauledModElements instance) {
		super(instance, 89);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.WATER_CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("piranha").setRegistryName("piranha");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -10991030, -7579817, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("piranha_spawn_egg"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("minecraft_overhauled:rainforest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("jungle")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.getSpawns(EntityClassification.WATER_CREATURE).add(new Biome.SpawnListEntry(entity, 60, 42, 68));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SquidEntity::func_223365_b);

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelpiranha(), 0.5f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraft_overhauled:textures/piranha.png");
				}
			};
		});

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));

					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.WATER;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7999999999999999);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);

		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}

	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports

	public static class Modelpiranha extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer Tail;
		private final ModelRenderer BackFin;
		private final ModelRenderer RightFin;
		private final ModelRenderer cube_r2;
		private final ModelRenderer LeftFin;
		private final ModelRenderer cube_r3;

		public Modelpiranha() {
			textureWidth = 32;
			textureHeight = 32;

			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -5.0F, 3.0F, 6.0F, 10.0F, 0.0F, false);

			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.5F, -4.5F, 5.5F);
			Body.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 10).addBox(-1.0F, -2.0F, -8.0F, 0.0F, 3.0F, 6.0F, 0.0F, false);

			Tail = new ModelRenderer(this);
			Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(Tail);
			Tail.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 5.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);

			BackFin = new ModelRenderer(this);
			BackFin.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(BackFin);
			BackFin.setTextureOffset(12, 13).addBox(-0.5F, -6.5F, 8.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);

			RightFin = new ModelRenderer(this);
			RightFin.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(RightFin);

			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-3.0F, 0.0F, 0.0F);
			RightFin.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.2618F, 0.0F);
			cube_r2.setTextureOffset(11, 0).addBox(-1.0F, -1.0F, -3.0F, 3.0F, 0.0F, 5.0F, 0.0F, false);

			LeftFin = new ModelRenderer(this);
			LeftFin.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(LeftFin);

			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.0F, 0.0F, 0.0F);
			LeftFin.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, -0.2618F, 0.0F);
			cube_r3.setTextureOffset(11, 5).addBox(-1.0F, -1.0F, -3.0F, 3.0F, 0.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.BackFin.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftFin.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Body.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Body.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightFin.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
