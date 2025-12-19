package net.mcreator.rebirthinc.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.rebirthinc.init.RebirthIncModAttributes;
import net.mcreator.rebirthinc.RebirthIncMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Iterator;

@Mod.EventBusSubscriber
public class OnDeathProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player
				&& (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(RebirthIncModAttributes.DEAD.get()) ? _livingEntity1.getAttribute(RebirthIncModAttributes.DEAD.get()).getBaseValue() : 0) == 1) {
			ScaleTypes.MINING_SPEED.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MINING_SPEED.getScaleData(entity).getTargetScale(), 0));
			ScaleTypes.MOTION.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MOTION.getScaleData(entity).getTargetScale(), 0));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
			if (world.isClientSide()) {
				SetupPlayerAnimatorProcedure.setAnimationClientside((Player) entity, "dead", true);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
					List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
					synchronized (connections) {
						Iterator<Connection> iterator = connections.iterator();
						while (iterator.hasNext()) {
							Connection connection = iterator.next();
							if (!connection.isConnecting() && connection.isConnected())
								RebirthIncMod.PACKET_HANDLER.sendTo(new SetupPlayerAnimatorProcedure.RebirthIncModAnimationMessage(Component.literal("dead"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
						}
					}
				}
			}
		} else if (entity instanceof Player
				&& (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(RebirthIncModAttributes.DEAD.get()) ? _livingEntity7.getAttribute(RebirthIncModAttributes.DEAD.get()).getBaseValue() : 0) == 0) {
			ScaleTypes.MINING_SPEED.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MINING_SPEED.getScaleData(entity).getTargetScale(), 1));
			ScaleTypes.MOTION.getScaleData(entity).setTargetScale((float) ScaleOperations.SET.applyAsDouble(ScaleTypes.MOTION.getScaleData(entity).getTargetScale(), 1));
		}
	}
}
