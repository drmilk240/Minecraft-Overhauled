package net.mcreator.minecraftoverhauled.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.minecraftoverhauled.entity.AntEntity;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@MinecraftOverhauledModElements.ModElement.Tag
public class AnthillBlockUpdateTickProcedure extends MinecraftOverhauledModElements.ModElement {
	public AnthillBlockUpdateTickProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 80);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure AnthillBlockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure AnthillBlockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure AnthillBlockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AnthillBlockUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "hasAnts")) != (true))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("countAnts", (2 + Math.round((Math.random() * 3))));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("timeTillAntRelease", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("hasAnts", (true));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("timeTillAntRelease", ((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "timeTillAntRelease")) - 1));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "timeTillAntRelease")) <= 0)) {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "countAnts")) > 0)) {
				if ((!(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid()))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						Entity entityToSpawn = new AntEntity.CustomEntity(AntEntity.entity, world.getWorld());
						entityToSpawn.setLocationAndAngles(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
									SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					((Entity) world.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), (y + 1) - (0.1 / 2d),
							z - (0.1 / 2d), x + (0.1 / 2d), (y + 1) + (0.1 / 2d), z + (0.1 / 2d)), null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, (y + 1), z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeX", x);
					((Entity) world.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), (y + 1) - (0.1 / 2d),
							z - (0.1 / 2d), x + (0.1 / 2d), (y + 1) + (0.1 / 2d), z + (0.1 / 2d)), null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, (y + 1), z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeY", y);
					((Entity) world.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), (y + 1) - (0.1 / 2d),
							z - (0.1 / 2d), x + (0.1 / 2d), (y + 1) + (0.1 / 2d), z + (0.1 / 2d)), null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, (y + 1), z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeZ", z);
				} else {
					if ((!(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).isSolid()))) {
						if (world instanceof World && !world.getWorld().isRemote) {
							Entity entityToSpawn = new AntEntity.CustomEntity(AntEntity.entity, world.getWorld());
							entityToSpawn.setLocationAndAngles(x, y, (z + 1), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
										SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						((Entity) world
								.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d),
										(z + 1) - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), (z + 1) + (0.1 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, (z + 1))).findFirst().orElse(null)).getPersistentData().putDouble("HomeX", x);
						((Entity) world
								.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d),
										(z + 1) - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), (z + 1) + (0.1 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, (z + 1))).findFirst().orElse(null)).getPersistentData().putDouble("HomeY", y);
						((Entity) world
								.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d),
										(z + 1) - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), (z + 1) + (0.1 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, (z + 1))).findFirst().orElse(null)).getPersistentData().putDouble("HomeZ", z);
					} else {
						if ((!(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).isSolid()))) {
							if (world instanceof World && !world.getWorld().isRemote) {
								Entity entityToSpawn = new AntEntity.CustomEntity(AntEntity.entity, world.getWorld());
								entityToSpawn.setLocationAndAngles((x + 1), y, z, world.getRandom().nextFloat() * 360F, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
											SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							((Entity) world
									.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB((x + 1) - (0.1 / 2d), y - (0.1 / 2d),
											z - (0.1 / 2d), (x + 1) + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf((x + 1), y, z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeX", x);
							((Entity) world
									.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB((x + 1) - (0.1 / 2d), y - (0.1 / 2d),
											z - (0.1 / 2d), (x + 1) + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf((x + 1), y, z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeY", y);
							((Entity) world
									.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB((x + 1) - (0.1 / 2d), y - (0.1 / 2d),
											z - (0.1 / 2d), (x + 1) + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf((x + 1), y, z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeZ", z);
						} else {
							if ((!(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).isSolid()))) {
								if (world instanceof World && !world.getWorld().isRemote) {
									Entity entityToSpawn = new AntEntity.CustomEntity(AntEntity.entity, world.getWorld());
									entityToSpawn.setLocationAndAngles(x, y, (z - 1), world.getRandom().nextFloat() * 360F, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
												SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								((Entity) world
										.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d),
												(z - 1) - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), (z - 1) + (0.1 / 2d)), null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, (z - 1))).findFirst().orElse(null)).getPersistentData().putDouble("HomeX", x);
								((Entity) world
										.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d),
												(z - 1) - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), (z - 1) + (0.1 / 2d)), null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, (z - 1))).findFirst().orElse(null)).getPersistentData().putDouble("HomeY", y);
								((Entity) world
										.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d),
												(z - 1) - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), (z - 1) + (0.1 / 2d)), null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, (z - 1))).findFirst().orElse(null)).getPersistentData().putDouble("HomeZ", z);
							} else {
								if ((!(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).isSolid()))) {
									if (world instanceof World && !world.getWorld().isRemote) {
										Entity entityToSpawn = new AntEntity.CustomEntity(AntEntity.entity, world.getWorld());
										entityToSpawn.setLocationAndAngles((x - 1), y, z, world.getRandom().nextFloat() * 360F, 0);
										if (entityToSpawn instanceof MobEntity)
											((MobEntity) entityToSpawn).onInitialSpawn(world,
													world.getDifficultyForLocation(new BlockPos(entityToSpawn)), SpawnReason.MOB_SUMMONED,
													(ILivingEntityData) null, (CompoundNBT) null);
										world.addEntity(entityToSpawn);
									}
									((Entity) world
											.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB((x - 1) - (0.1 / 2d),
													y - (0.1 / 2d), z - (0.1 / 2d), (x - 1) + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf((x - 1), y, z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeX", x);
									((Entity) world
											.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB((x - 1) - (0.1 / 2d),
													y - (0.1 / 2d), z - (0.1 / 2d), (x - 1) + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf((x - 1), y, z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeY", y);
									((Entity) world
											.getEntitiesWithinAABB(AntEntity.CustomEntity.class, new AxisAlignedBB((x - 1) - (0.1 / 2d),
													y - (0.1 / 2d), z - (0.1 / 2d), (x - 1) + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf((x - 1), y, z)).findFirst().orElse(null)).getPersistentData().putDouble("HomeZ", z);
								} else {
									if (!world.getWorld().isRemote) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putDouble("countAnts", ((new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "countAnts")) + 1));
										world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
								}
							}
						}
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("countAnts", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "countAnts")) - 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
