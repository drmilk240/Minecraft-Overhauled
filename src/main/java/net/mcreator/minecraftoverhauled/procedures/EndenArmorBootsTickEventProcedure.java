package net.mcreator.minecraftoverhauled.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledMod;

import java.util.Map;

@MinecraftOverhauledModElements.ModElement.Tag
public class EndenArmorBootsTickEventProcedure extends MinecraftOverhauledModElements.ModElement {
	public EndenArmorBootsTickEventProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 230);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency entity for procedure EndenArmorBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((!(entity.isOnGround())) && (!(entity.isSneaking())))) {
			entity.setNoGravity((true));
		} else if (((entity.isOnGround()) || (entity.isSneaking()))) {
			entity.setNoGravity((false));
		}
	}
}
