package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;
import net.mcreator.rebirthinc.init.RebirthIncModItems;

import javax.annotation.Nullable;

import java.util.stream.Collectors;

@Mod.EventBusSubscriber
public class SyncProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entity) ? _entity.isHolding(RebirthIncModItems.OCILOSCOPIO.get()) : false) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + RebirthIncModVariables.MapVariables.get(world).Radio_Location.stream().map(String::valueOf).collect(Collectors.joining(",")))), false);
		}
	}
}
