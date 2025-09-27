package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class SpeedArmorHelmetTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
			_livingEntity0.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(30);
	}
}
