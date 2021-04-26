
package net.mcreator.minecraftoverhauled.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.minecraftoverhauled.block.EndLoamBlock;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class DeepEndTabItemGroup extends MinecraftOverhauledModElements.ModElement {
	public DeepEndTabItemGroup(MinecraftOverhauledModElements instance) {
		super(instance, 157);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdeep_end_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EndLoamBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
