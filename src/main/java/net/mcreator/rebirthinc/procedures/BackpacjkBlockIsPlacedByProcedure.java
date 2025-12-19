package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.UUID;

public class BackpacjkBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockEntity blockEntity = world.getBlockEntity(BlockPos.containing((int) x, (int) y, (int) z));
			if (blockEntity != null) {
				blockEntity.getPersistentData().putUUID("Items", new UUID(0, 0));
			}
		}
	}
}
