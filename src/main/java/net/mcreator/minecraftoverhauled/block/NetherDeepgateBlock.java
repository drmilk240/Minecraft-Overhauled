
package net.mcreator.minecraftoverhauled.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.minecraftoverhauled.procedures.NetherDeepgateOnBlockRightClickedProcedure;
import net.mcreator.minecraftoverhauled.itemgroup.NetherTabItemGroup;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@MinecraftOverhauledModElements.ModElement.Tag
public class NetherDeepgateBlock extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:nether_deepgate")
	public static final Block block = null;
	public NetherDeepgateBlock(MinecraftOverhauledModElements instance) {
		super(instance, 235);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(NetherTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.NETHER_BRICK).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0));
			setRegistryName("nether_deepgate");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(state, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				NetherDeepgateOnBlockRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ActionResultType.SUCCESS;
		}
	}
}
