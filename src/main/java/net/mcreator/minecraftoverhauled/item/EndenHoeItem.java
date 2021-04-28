
package net.mcreator.minecraftoverhauled.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.minecraftoverhauled.itemgroup.DeepEndTabItemGroup;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class EndenHoeItem extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:enden_hoe")
	public static final Item block = null;
	public EndenHoeItem(MinecraftOverhauledModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1330;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 7;
			}

			public int getEnchantability() {
				return 46;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EndenAlloyItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(DeepEndTabItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("enden_hoe"));
	}
}
