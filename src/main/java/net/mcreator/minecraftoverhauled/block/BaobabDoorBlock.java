
package net.mcreator.minecraftoverhauled.block;

import net.minecraft.block.material.Material;

@MinecraftOverhauledModElements.ModElement.Tag
public class BaobabDoorBlock extends MinecraftOverhauledModElements.ModElement {

	@ObjectHolder("minecraft_overhauled:baobab_door")
	public static final Block block = null;

	public BaobabDoorBlock(MinecraftOverhauledModElements instance) {
		super(instance, 66);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(SavannaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends DoorBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());

			setRegistryName("baobab_door");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			if (state.get(BlockStateProperties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER)
				return Collections.emptyList();

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
