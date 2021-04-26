package net.mcreator.minecraftoverhauled.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.minecraftoverhauled.block.BushBlock;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledMod;

import java.util.Map;

@MinecraftOverhauledModElements.ModElement.Tag
public class AntOnEntityTickUpdateProcedure extends MinecraftOverhauledModElements.ModElement {
	public AntOnEntityTickUpdateProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 81);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency entity for procedure AntOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency x for procedure AntOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency y for procedure AntOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency z for procedure AntOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency world for procedure AntOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double VarX = 0;
		double VarZ = 0;
		double VarY = 0;
		entity.setMotion((0.2 * Math.cos((((entity.rotationYaw) + 90) * (Math.PI / 180)))), (entity.getMotion().getY()),
				(0.2 * Math.sin((((entity.rotationYaw) + 90) * (Math.PI / 180)))));
		entity.getPersistentData().putDouble("checkBush", ((entity.getPersistentData().getDouble("checkBush")) - 1));
		if (((entity.getPersistentData().getDouble("checkBush")) <= 0)) {
			VarX = (double) (-3);
			VarY = (double) (-1);
			VarZ = (double) (-3);
			while (((VarY) <= 1)) {
				while (((VarZ) <= 3)) {
					while (((VarX) <= 3)) {
						if (((world.getBlockState(new BlockPos((int) (x + (VarX)), (int) (y + (VarY)), (int) (z + (VarZ)))))
								.getBlock() == BushBlock.block.getDefaultState().getBlock())) {
							break;
						}
						VarX = (double) ((VarX) + 1);
					}
					if (((world.getBlockState(new BlockPos((int) (x + (VarX)), (int) (y + (VarY)), (int) (z + (VarZ))))).getBlock() == BushBlock.block
							.getDefaultState().getBlock())) {
						break;
					}
					VarX = (double) (-3);
					VarZ = (double) ((VarZ) + 1);
				}
				if (((world.getBlockState(new BlockPos((int) (x + (VarX)), (int) (y + (VarY)), (int) (z + (VarZ))))).getBlock() == BushBlock.block
						.getDefaultState().getBlock())) {
					world.setBlockState(new BlockPos((int) (x + (VarX)), (int) (y + (VarY)), (int) (z + (VarZ))), Blocks.AIR.getDefaultState(), 3);
					break;
				}
				VarZ = (double) (-3);
				VarY = (double) ((VarY) + 1);
			}
			entity.getPersistentData().putDouble("checkBush", 100);
		}
	}
}
