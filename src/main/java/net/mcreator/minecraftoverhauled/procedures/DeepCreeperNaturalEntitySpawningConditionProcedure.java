package net.mcreator.minecraftoverhauled.procedures;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledMod;

import java.util.Map;

@MinecraftOverhauledModElements.ModElement.Tag
public class DeepCreeperNaturalEntitySpawningConditionProcedure extends MinecraftOverhauledModElements.ModElement {
	public DeepCreeperNaturalEntitySpawningConditionProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 319);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency y for procedure DeepCreeperNaturalEntitySpawningCondition!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if (((y < 27) == (true))) {
			return (true);
		}
		return (false);
	}
}
