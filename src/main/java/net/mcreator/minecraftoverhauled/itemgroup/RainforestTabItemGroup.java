
package net.mcreator.minecraftoverhauled.itemgroup;

@MinecraftOverhauledModElements.ModElement.Tag
public class RainforestTabItemGroup extends MinecraftOverhauledModElements.ModElement {

	public RainforestTabItemGroup(MinecraftOverhauledModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabrainforest_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.JUNGLE_SAPLING, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
