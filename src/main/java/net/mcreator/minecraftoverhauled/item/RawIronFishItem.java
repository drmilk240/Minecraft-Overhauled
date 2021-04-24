
package net.mcreator.minecraftoverhauled.item;

@MinecraftOverhauledModElements.ModElement.Tag
public class RawIronFishItem extends MinecraftOverhauledModElements.ModElement {

	@ObjectHolder("minecraft_overhauled:raw_iron_fish")
	public static final Item block = null;

	public RawIronFishItem(MinecraftOverhauledModElements instance) {
		super(instance, 72);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.1f)

							.meat().build()));
			setRegistryName("raw_iron_fish");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 40;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
