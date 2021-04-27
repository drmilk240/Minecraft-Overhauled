

package net.mcreator.minecraftoverhauled.block;

import net.minecraft.block.material.Material;

@MinecraftOverhauledModElements.ModElement.Tag
public class EndLoamBlock extends MinecraftOverhauledModElements.ModElement {

	@ObjectHolder("minecraft_overhauled:end_loam")
	public static final Block block = null;


	public EndLoamBlock (MinecraftOverhauledModElements instance) {
		super(instance, 37);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());


	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(DeepEndTabItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}




	public static class CustomBlock extends
				Block
 {


		public CustomBlock() {
			super(

			Block.Properties.create(Material.EARTH)
					.sound(SoundType.SHROOMLIGHT)
					.hardnessAndResistance(3f, 9f)
					.setLightLevel(s -> 5)
					.harvestLevel(1)
					.harvestTool(ToolType.PICKAXE)
					.setRequiresTool()
			);


			setRegistryName("end_loam");
		}















		@Override public MaterialColor getMaterialColor() {
        	return MaterialColor.CYAN;
    	}



        @Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}




			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}


	private static Feature<OreFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH = null;

	private static class CustomRuleTest extends RuleTest {

		static final CustomRuleTest INSTANCE = new CustomRuleTest();
		static final com.mojang.serialization.Codec<CustomRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;


			return blockCriteria;
		}

		protected IRuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

	private static class FeatureRegisterHandler {

		@SubscribeEvent public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			CUSTOM_MATCH = Registry.register(Registry.RULE_TEST, new ResourceLocation("minecraft_overhauled:end_loam_match"), () -> CustomRuleTest.codec);

			feature = new OreFeature(OreFeatureConfig.CODEC) {
				@Override public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

							if(dimensionType == World.THE_END)
								dimensionCriteria = true;

					if(!dimensionCriteria)
						return false;


					return super.generate(world, generator, rand, pos, config);
				}
			};

			configuredFeature = feature
					.withConfiguration(new OreFeatureConfig(CustomRuleTest.INSTANCE, block.getDefaultState(), 16))
					.range(64)
					.square()
					.func_242731_b(10);

			event.getRegistry().register(feature.setRegistryName("end_loam"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("minecraft_overhauled:end_loam"), configuredFeature);
		}

	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
	}

}
