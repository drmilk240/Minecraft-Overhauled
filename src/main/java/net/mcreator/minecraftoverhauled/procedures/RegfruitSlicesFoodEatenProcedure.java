package net.mcreator.minecraftoverhauled.procedures;

@MinecraftOverhauledModElements.ModElement.Tag
public class RegfruitSlicesFoodEatenProcedure extends MinecraftOverhauledModElements.ModElement {

	public RegfruitSlicesFoodEatenProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 64);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RegfruitSlicesFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 1, (false), (false)));

	}

}
