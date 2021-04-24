
package net.mcreator.minecraftoverhauled.block;

import net.minecraft.block.material.Material;

@MinecraftOverhauledModElements.ModElement.Tag
public class AnthillbaseBlock extends MinecraftOverhauledModElements.ModElement {

	@ObjectHolder("minecraft_overhauled:anthillbase")
	public static final Block block = null;

	public AnthillbaseBlock(MinecraftOverhauledModElements instance) {
		super(instance, 79);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SavannaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.NETHER_WART).hardnessAndResistance(3f, 10f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE).tickRandomly());

			setRegistryName("anthillbase");
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 1;
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
