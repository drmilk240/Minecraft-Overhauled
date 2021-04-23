
package net.mcreator.minecraftoverhauled.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.IFluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.material.Material;
import net.minecraft.block.WallBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.minecraftoverhauled.itemgroup.SavannaItemGroup;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import java.util.List;
import java.util.Collections;

@MinecraftOverhauledModElements.ModElement.Tag
public class BushthornLogBlock extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:bushthorn_log")
	public static final Block block = null;
	public BushthornLogBlock(MinecraftOverhauledModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SavannaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends WallBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 2f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.AXE));
			setRegistryName("bushthorn_log");
		}

		private boolean func_220113_a(BlockState state, boolean checkattach, Direction face) {
			boolean flag = state.getBlock() instanceof WallBlock
					|| state.getBlock() instanceof FenceGateBlock && FenceGateBlock.isParallel(state, face);
			return !cannotAttach(state.getBlock()) && checkattach || flag;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			IWorldReader iworldreader = context.getWorld();
			BlockPos blockpos = context.getPos();
			IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
			BlockPos blockpos1 = blockpos.north();
			BlockPos blockpos2 = blockpos.east();
			BlockPos blockpos3 = blockpos.south();
			BlockPos blockpos4 = blockpos.west();
			BlockState blockstate = iworldreader.getBlockState(blockpos1);
			BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
			BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
			BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
			boolean flag = this.func_220113_a(blockstate, blockstate.isSolidSide(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
			boolean flag1 = this.func_220113_a(blockstate1, blockstate1.isSolidSide(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
			boolean flag2 = this.func_220113_a(blockstate2, blockstate2.isSolidSide(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
			boolean flag3 = this.func_220113_a(blockstate3, blockstate3.isSolidSide(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
			boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
			return this.getDefaultState().with(UP, Boolean.valueOf(flag4 || !iworldreader.isAirBlock(blockpos.up())))
					.with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2))
					.with(WEST, Boolean.valueOf(flag3)).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
		}

		@Override /**
					 * Update the provided state given the provided neighbor facing and neighbor
					 * state, returning a new state. For example, fences make their connections to
					 * the passed in state if possible, and wet concrete powder immediately returns
					 * its solidified counterpart. Note that this method should ideally consider
					 * only the specific face passed in.
					 */
		public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos,
				BlockPos facingPos) {
			if (stateIn.get(WATERLOGGED)) {
				worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			}
			if (facing == Direction.DOWN) {
				return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
			} else {
				Direction direction = facing.getOpposite();
				boolean flag = facing == Direction.NORTH
						? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction)
						: stateIn.get(NORTH);
				boolean flag1 = facing == Direction.EAST
						? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction)
						: stateIn.get(EAST);
				boolean flag2 = facing == Direction.SOUTH
						? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction)
						: stateIn.get(SOUTH);
				boolean flag3 = facing == Direction.WEST
						? this.func_220113_a(facingState, facingState.isSolidSide(worldIn, facingPos, direction), direction)
						: stateIn.get(WEST);
				boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
				return stateIn.with(UP, Boolean.valueOf(flag4 || !worldIn.isAirBlock(currentPos.up()))).with(NORTH, Boolean.valueOf(flag))
						.with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3));
			}
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
