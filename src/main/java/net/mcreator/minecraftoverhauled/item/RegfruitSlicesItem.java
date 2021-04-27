
package net.mcreator.minecraftoverhauled.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.minecraftoverhauled.procedures.RegfruitSlicesFoodEatenProcedure;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;

import java.util.Map;
import java.util.HashMap;

@MinecraftOverhauledModElements.ModElement.Tag
public class RegfruitSlicesItem extends MinecraftOverhauledModElements.ModElement {
	@ObjectHolder("minecraft_overhauled:regfruit_slices")
	public static final Item block = null;
	public RegfruitSlicesItem(MinecraftOverhauledModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(5).saturation(1.1f).setAlwaysEdible().build()));
			setRegistryName("regfruit_slices");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RegfruitSlicesFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
