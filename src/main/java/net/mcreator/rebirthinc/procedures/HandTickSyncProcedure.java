package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;
import net.mcreator.rebirthinc.RebirthIncMod;

import java.util.stream.Collectors;

public class HandTickSyncProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		RebirthIncMod.queueServerWork(10, () -> {
			{
				String _setval = RebirthIncModVariables.MapVariables.get(world).Radio_Location.stream().map(String::valueOf).collect(Collectors.joining(","));
				entity.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Radio_Location_PlayerSync = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
	}
}
