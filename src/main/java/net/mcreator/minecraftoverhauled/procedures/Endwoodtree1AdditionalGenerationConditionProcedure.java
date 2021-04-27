package net.mcreator.minecraftoverhauled.procedures;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledMod;

import java.util.Map;

@MinecraftOverhauledModElements.ModElement.Tag
public class Endwoodtree1AdditionalGenerationConditionProcedure extends MinecraftOverhauledModElements.ModElement {
	public Endwoodtree1AdditionalGenerationConditionProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 180);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency y for procedure Endwoodtree1AdditionalGenerationCondition!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if ((!(y < 18))) {
			return (true);
		}
		return (false);
	}
}
