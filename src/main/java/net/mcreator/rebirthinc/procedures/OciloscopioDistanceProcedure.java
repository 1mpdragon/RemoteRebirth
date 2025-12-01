package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OciloscopioDistanceProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static String execute(Entity entity) {
		return execute(null, entity);
	}

	private static String execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return "";
		Direction OciloscopioCalibrator = Direction.NORTH;
		double BX = 0;
		double BY = 0;
		double BZ = 0;
		double PX = 0;
		double PY = 0;
		double PZ = 0;
		double Dist = 0;
		double aX = 0;
		double aY = 0;
		double angleToTarget = 0;
		double difference = 0;
		double distance = 0;
		double RaioDistance = 0;
		double Temp = 0;
		double HorizontalDist = 0;
		double dy = 0;
		double PitchToTarget = 0;
		double dist2 = 0;
		double DistanceToTarget = 0;
		RaioDistance = 5;
		BX = 0.5;
		BY = 0.5;
		BZ = 0.5;
		PX = entity.getX();
		PY = entity.getY();
		PZ = entity.getZ();
		dy = BY - (PY + 1.6);
		distance = Math.sqrt(Math.pow(BX - PX, 2) + Math.pow(BZ - PZ, 2) + Math.pow(BY - PY, 2));
		return Math.round(Math.pow(10, 1) * distance) / Math.pow(10, 1) + "m";
	}
}
