package net.mcreator.minecraftoverhauled.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledMod;

import java.util.Map;

@MinecraftOverhauledModElements.ModElement.Tag
public class FreezingOnPotionActiveTickProcedure extends MinecraftOverhauledModElements.ModElement {
	public FreezingOnPotionActiveTickProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 295);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency entity for procedure FreezingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency x for procedure FreezingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency y for procedure FreezingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency z for procedure FreezingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency world for procedure FreezingOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("minecraft_overhauled:mountains_plus")))) {
			if ((!(((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
					: ItemStack.EMPTY).getItem() == new ItemStack(Items.LEATHER_BOOTS, (int) (1)).getItem())
					&& (((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem() == new ItemStack(Items.LEATHER_LEGGINGS, (int) (1)).getItem()))
					&& ((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem() == new ItemStack(Items.LEATHER_CHESTPLATE, (int) (1)).getItem())
							&& (((entity instanceof LivingEntity)
									? ((LivingEntity) entity)
											.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
									: ItemStack.EMPTY).getItem() == new ItemStack(Items.LEATHER_HELMET, (int) (1)).getItem()))))) {
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).addExhaustion((float) 0.1);
				}
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 0.1);
				entity.setMotionMultiplier(null, new Vector3d(0.25D, (double) 0.05F, 0.25D));
			}
		}
	}
}
