package net.mcreator.minecraftoverhauled.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftoverhauled.MinecraftOverhauledModElements;
import net.mcreator.minecraftoverhauled.MinecraftOverhauledMod;

import java.util.Map;

@MinecraftOverhauledModElements.ModElement.Tag
public class SulphuricAcidMobplayerCollidesBlockProcedure extends MinecraftOverhauledModElements.ModElement {
	public SulphuricAcidMobplayerCollidesBlockProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 262);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftOverhauledMod.LOGGER.warn("Failed to load dependency entity for procedure SulphuricAcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 1, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 1, (true), (false)));
	}
}
