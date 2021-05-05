
package net.mcreator.minecraftoverhauled.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.minecraftoverhauled.item.CopperIngotItem;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class ElectricityItemGroup extends MinecraftOverhauledModElements.ModElement {
	public ElectricityItemGroup(MinecraftOverhauledModElements instance) {
		super(instance, 156);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabelectricity") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CopperIngotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
