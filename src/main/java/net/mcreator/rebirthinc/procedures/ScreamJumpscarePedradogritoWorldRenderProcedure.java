package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ScreamJumpscarePedradogritoWorldRenderProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).PedradogritoJumpscare < 0) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList()
						.broadcastSystemMessage(Component.literal(("" + (entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).PedradogritoJumpscare)), false);
			{
				double _setval = (entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RebirthIncModVariables.PlayerVariables())).PedradogritoJumpscare - 5;
				entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PedradogritoJumpscare = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
