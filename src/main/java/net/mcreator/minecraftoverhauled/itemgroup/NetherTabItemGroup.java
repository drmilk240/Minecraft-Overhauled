
package net.mcreator.minecraftoverhauled.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class NetherTabItemGroup extends MinecraftOverhauledModElements.ModElement {
	public NetherTabItemGroup(MinecraftOverhauledModElements instance) {
		super(instance, 209);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnether_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.NETHERRACK, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
