
package net.mcreator.minecraftoverhauled.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MinecraftOverhauledModElements.ModElement.Tag
public class CapybaraEntity extends MinecraftOverhauledModElements.ModElement {
	public static EntityType entity = null;
	public CapybaraEntity(MinecraftOverhauledModElements instance) {
		super(instance, 88);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("capybara")
						.setRegistryName("capybara");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13686250, -12772851, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("capybara_spawn_egg"));
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
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcapybara(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraft_overhauled:textures/capybara.png");
				}
			};
		});
	}
	public static class CustomEntity extends PigEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new SwimGoal(this));
			this.goalSelector.addGoal(3, new PanicGoal(this, 2));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.LEATHER, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.step")), 0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
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
