package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.init.RebirthIncModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(1);
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(RebirthIncModAttributes.DEAD.get()))
				_livingEntity3.getAttribute(RebirthIncModAttributes.DEAD.get()).setBaseValue(1);
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
