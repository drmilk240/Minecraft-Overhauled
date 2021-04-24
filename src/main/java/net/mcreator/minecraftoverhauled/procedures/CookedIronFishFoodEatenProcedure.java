package net.mcreator.minecraftoverhauled.procedures;

@MinecraftOverhauledModElements.ModElement.Tag
public class CookedIronFishFoodEatenProcedure extends MinecraftOverhauledModElements.ModElement {

	public CookedIronFishFoodEatenProcedure(MinecraftOverhauledModElements instance) {
		super(instance, 73);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CookedIronFishFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 256, (int) 1, (false), (false)));

	}

}
