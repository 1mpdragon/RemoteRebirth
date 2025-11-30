package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;

public class OciloscopioItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
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
		RaioDistance = 5;
		BX = 0.5;
		BZ = 0.5;
		PX = entity.getX();
		PZ = entity.getZ();
		distance = Math.sqrt(Math.pow(BX - PX, 2) + Math.pow(BZ - PZ, 2));
		angleToTarget = Math.atan2(BZ - PZ, BX - PX) * (180 / Math.PI);
		angleToTarget = angleToTarget - 90;
		Temp = angleToTarget - entity.getYRot();
		while (Temp > 180) {
			Temp = Temp - 360;
		}
		while (Temp <= -180) {
			Temp = Temp + 360;
		}
		Dist = Temp;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Angulo:" + Math.round(Math.pow(10, 1) * angleToTarget) / Math.pow(10, 1) + " " + "Distance:" + Math.round(Math.pow(10, 1) * distance) / Math.pow(10, 1) + " "
					+ "distancia at\u00E9 o angulo:" + Math.round(Math.pow(10, 1) * Dist) / Math.pow(10, 1))), false);
	}
}
