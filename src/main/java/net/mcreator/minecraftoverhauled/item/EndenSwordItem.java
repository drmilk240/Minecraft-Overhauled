
package net.mcreator.minecraftoverhauled.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

@MinecraftOverhauledModElements.ModElement.Tag
public class EndenSwordItem extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:enden_sword")
	public static final Item block = null;
	public EndenSwordItem(MinecraftOverhauledModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1330;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 18f;
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
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("enden_sword"));
	}
}
