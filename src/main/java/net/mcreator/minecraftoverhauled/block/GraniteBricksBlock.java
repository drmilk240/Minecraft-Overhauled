
package net.mcreator.minecraftoverhauled.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import java.util.List;
import java.util.Collections;

@MinecraftOverhauledModElements.ModElement.Tag
public class GraniteBricksBlock extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:granite_bricks")
	public static final Block block = null;
	public GraniteBricksBlock(MinecraftOverhauledModElements instance) {
		super(instance, 269);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 10f).setLightLevel(s -> 0));
			setRegistryName("granite_bricks");
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
