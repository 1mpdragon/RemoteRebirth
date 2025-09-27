package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.init.RebirthIncModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DeathHitProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player
				&& (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(RebirthIncModAttributes.DEAD.get()) ? _livingEntity1.getAttribute(RebirthIncModAttributes.DEAD.get()).getBaseValue() : 0) == 1) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
