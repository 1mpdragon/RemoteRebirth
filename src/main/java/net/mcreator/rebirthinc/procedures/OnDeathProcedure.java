package net.mcreator.rebirthinc.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.init.RebirthIncModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnDeathProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player
				&& (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(RebirthIncModAttributes.DEAD.get()) ? _livingEntity1.getAttribute(RebirthIncModAttributes.DEAD.get()).getBaseValue() : 0) >= 1) {
			ScaleTypes.MINING_SPEED.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MINING_SPEED.getScaleData(entity).getTargetScale(), 0));
			ScaleTypes.MOTION.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MOTION.getScaleData(entity).getTargetScale(), 0));
		} else if (entity instanceof Player
				&& (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(RebirthIncModAttributes.DEAD.get()) ? _livingEntity5.getAttribute(RebirthIncModAttributes.DEAD.get()).getBaseValue() : 0) == 0) {
			ScaleTypes.MINING_SPEED.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MINING_SPEED.getScaleData(entity).getTargetScale(), 1));
			ScaleTypes.MOTION.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MOTION.getScaleData(entity).getTargetScale(), 1));
		}
	}
}
