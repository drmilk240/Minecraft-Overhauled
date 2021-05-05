
package net.mcreator.minecraftoverhauled.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class EmberThreatItem extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:ember_threat")
	public static final Item block = null;
	public EmberThreatItem(MinecraftOverhauledModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, MinecraftOverhauledModElements.sounds.get(new ResourceLocation("minecraft_overhauled:emberthreat")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("ember_threat");
		}
	}
}
