
package net.mcreator.minecraftoverhauled.block;

import net.minecraft.block.material.Material;

@MinecraftOverhauledModElements.ModElement.Tag
public class RegfruitBlock extends MinecraftOverhauledModElements.ModElement {

	@ObjectHolder("minecraft_overhauled:regfruit")
	public static final Block block = null;

	public RegfruitBlock(MinecraftOverhauledModElements instance) {
		super(instance, 63);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SavannaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.PLANTS).sound(SoundType.BAMBOO).hardnessAndResistance(1.1500000000000001f, 10f).lightValue(3)
							.harvestLevel(1).harvestTool(ToolType.AXE));

			setRegistryName("regfruit");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(RegfruitSlicesItem.block, (int) (4)));
		}

	}

}
