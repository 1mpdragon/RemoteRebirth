package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MagneticCoreDestructionProcedureProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double xBlock = 0;
		double yBlock = 0;
		double zBlock = 0;
		double RadiusSize = 0;
		double RadiusSize2 = 0;
		double xBlock2 = 0;
		double yBlock2 = 0;
		double zBlock2 = 0;
		boolean MCF = false;
		boolean MCF2 = false;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RebirthIncModBlocks.MAGNETIC_CORE.get()) {
			RadiusSize = 3;
			xBlock = (int) (RadiusSize / 2);
			for (int index0 = 0; index0 < (int) RadiusSize; index0++) {
				yBlock = (int) (RadiusSize / 2);
				for (int index1 = 0; index1 < (int) RadiusSize; index1++) {
					zBlock = (int) (RadiusSize / 2);
					for (int index2 = 0; index2 < (int) RadiusSize; index2++) {
						if ((world.getBlockState(BlockPos.containing(x - xBlock, y - yBlock, z - zBlock))).getBlock() == RebirthIncModBlocks.MAGNETIC_CORE.get() && !(x - xBlock == x && y - yBlock == y && z - zBlock == z)) {
							MCF = true;
						}
						zBlock = zBlock - 1;
					}
					yBlock = yBlock - 1;
				}
				xBlock = xBlock - 1;
			}
			if (!MCF) {
				RadiusSize = 11;
				xBlock = (int) (RadiusSize / 2);
				for (int index3 = 0; index3 < (int) RadiusSize; index3++) {
					yBlock = (int) (RadiusSize / 2);
					for (int index4 = 0; index4 < (int) RadiusSize; index4++) {
						zBlock = (int) (RadiusSize / 2);
						for (int index5 = 0; index5 < (int) RadiusSize; index5++) {
							if (!(x - xBlock == x && y - yBlock == y && z - zBlock == z || (world.getBlockState(BlockPos.containing(x - xBlock, y - yBlock, z - zBlock))).getBlock() == Blocks.BEDROCK
									|| (world.getBlockState(BlockPos.containing(x - xBlock, y - yBlock, z - zBlock))).getBlock() == RebirthIncModBlocks.MAGNETIC_CORE.get())) {
								if (world instanceof ServerLevel _level)
									FallingBlockEntity.fall(_level, BlockPos.containing(x - xBlock, y - yBlock, z - zBlock), (world.getBlockState(BlockPos.containing(x - xBlock, y - yBlock, z - zBlock))));
								world.destroyBlock(BlockPos.containing(x - xBlock, y - yBlock, z - zBlock), false);
							}
							zBlock = zBlock - 1;
						}
						yBlock = yBlock - 1;
					}
					xBlock = xBlock - 1;
				}
			}
		}
	}
}
