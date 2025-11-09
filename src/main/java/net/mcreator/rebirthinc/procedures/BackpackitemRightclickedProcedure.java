package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.RebirthIncMod;

public class BackpackitemRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		RebirthIncMod.queueServerWork(10, () -> {
			if (entity instanceof Player _player)
				_player.closeContainer();
		});
	}
}
