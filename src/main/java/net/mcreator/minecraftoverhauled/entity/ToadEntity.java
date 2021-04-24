
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MinecraftOverhauledModElements.ModElement.Tag
public class ToadEntity extends MinecraftOverhauledModElements.ModElement {
	public static EntityType entity = null;
	public ToadEntity(MinecraftOverhauledModElements instance) {
		super(instance, 41);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("toad")
						.setRegistryName("toad");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -12622015, -9404865, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("toad_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna_plateau")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 6, 1, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeltoad(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecraft_overhauled:textures/toad.png");
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
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new SwimGoal(this));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AntEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(4, new FollowMobGoal(this, (float) 1, 10, 5));
			this.goalSelector.addGoal(6, new PanicGoal(this, 1.2));
			this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 1, 40));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
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
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modeltoad extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer rbacktoe_r1_r1;
		private final ModelRenderer Body;
		private final ModelRenderer rbacktoe_r1_r2;
		private final ModelRenderer LFrontLeg;
		private final ModelRenderer rbacktoe_r1_r3;
		private final ModelRenderer RFrontLeg;
		private final ModelRenderer rbacktoe_r1_r4;
		private final ModelRenderer LBackLeg;
		private final ModelRenderer rbacktoe_r1_r5;
		private final ModelRenderer RBackLeg;
		private final ModelRenderer rbacktoe_r1_r6;
		public Modeltoad() {
			textureWidth = 32;
			textureHeight = 32;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 19.0F, -4.0F);
			rbacktoe_r1_r1 = new ModelRenderer(this);
			rbacktoe_r1_r1.setRotationPoint(0.0F, 5.0F, 4.0F);
			Head.addChild(rbacktoe_r1_r1);
			setRotationAngle(rbacktoe_r1_r1, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r1.setTextureOffset(0, 14).addBox(-7.0F, -7.0F, -3.0F, 3.0F, 5.0F, 6.0F, 0.0F, false);
			rbacktoe_r1_r1.setTextureOffset(0, 25).addBox(-6.0F, -8.0F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			rbacktoe_r1_r1.setTextureOffset(24, 24).addBox(-6.0F, -8.0F, -3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 20.0F, 0.0F);
			rbacktoe_r1_r2 = new ModelRenderer(this);
			rbacktoe_r1_r2.setRotationPoint(0.0F, 4.0F, 0.0F);
			Body.addChild(rbacktoe_r1_r2);
			setRotationAngle(rbacktoe_r1_r2, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r2.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
			LFrontLeg = new ModelRenderer(this);
			LFrontLeg.setRotationPoint(5.0F, 21.0F, -3.0F);
			rbacktoe_r1_r3 = new ModelRenderer(this);
			rbacktoe_r1_r3.setRotationPoint(-5.0F, 3.0F, 3.0F);
			LFrontLeg.addChild(rbacktoe_r1_r3);
			setRotationAngle(rbacktoe_r1_r3, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r3.setTextureOffset(24, 0).addBox(-4.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			RFrontLeg = new ModelRenderer(this);
			RFrontLeg.setRotationPoint(-5.0F, 21.0F, -3.0F);
			rbacktoe_r1_r4 = new ModelRenderer(this);
			rbacktoe_r1_r4.setRotationPoint(5.0F, 3.0F, 3.0F);
			RFrontLeg.addChild(rbacktoe_r1_r4);
			setRotationAngle(rbacktoe_r1_r4, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r4.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, 4.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			LBackLeg = new ModelRenderer(this);
			LBackLeg.setRotationPoint(5.0F, 21.0F, 2.0F);
			rbacktoe_r1_r5 = new ModelRenderer(this);
			rbacktoe_r1_r5.setRotationPoint(-5.0F, 3.0F, -2.0F);
			LBackLeg.addChild(rbacktoe_r1_r5);
			setRotationAngle(rbacktoe_r1_r5, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r5.setTextureOffset(18, 19).addBox(1.0F, -4.5F, -6.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			rbacktoe_r1_r5.setTextureOffset(16, 24).addBox(1.75F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			RBackLeg = new ModelRenderer(this);
			RBackLeg.setRotationPoint(-5.0F, 21.0F, 2.0F);
			rbacktoe_r1_r6 = new ModelRenderer(this);
			rbacktoe_r1_r6.setRotationPoint(5.0F, 3.0F, -2.0F);
			RBackLeg.addChild(rbacktoe_r1_r6);
			setRotationAngle(rbacktoe_r1_r6, 0.0F, -1.5708F, 0.0F);
			rbacktoe_r1_r6.setTextureOffset(12, 14).addBox(1.0F, -4.5F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			rbacktoe_r1_r6.setTextureOffset(22, 14).addBox(1.75F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			LFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			RFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			RBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.RFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.LFrontLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
