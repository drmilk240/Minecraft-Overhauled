
package net.mcreator.minecraftoverhauled.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.minecraftoverhauled.itemgroup.ElectricityItemGroup;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class CopperNuggetItem extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:copper_nugget")
	public static final Item block = null;
	public CopperNuggetItem(MinecraftOverhauledModElements instance) {
		super(instance, 258);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ElectricityItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("copper_nugget");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
