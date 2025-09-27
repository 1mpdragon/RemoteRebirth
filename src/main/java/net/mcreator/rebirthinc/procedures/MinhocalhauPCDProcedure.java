package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;
import net.mcreator.rebirthinc.init.RebirthIncModBlocks;
import net.mcreator.rebirthinc.RebirthIncMod;

public class MinhocalhauPCDProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		RebirthIncModVariables.MapVariables.get(world).sx = Mth.nextDouble(RandomSource.create(), -1, 1);
		RebirthIncModVariables.MapVariables.get(world).syncData(world);
		RebirthIncMod.queueServerWork(20, () -> {
			RebirthIncModVariables.MapVariables.get(world).sy = Mth.nextDouble(RandomSource.create(), -1, 1);
			RebirthIncModVariables.MapVariables.get(world).syncData(world);
			RebirthIncMod.queueServerWork(20, () -> {
				RebirthIncModVariables.MapVariables.get(world).sz = Mth.nextDouble(RandomSource.create(), -1, 1);
				RebirthIncModVariables.MapVariables.get(world).syncData(world);
				if ((world.getBlockState(BlockPos.containing(x + RebirthIncModVariables.MapVariables.get(world).sx, y + RebirthIncModVariables.MapVariables.get(world).sy, z + RebirthIncModVariables.MapVariables.get(world).sz)))
						.getBlock() == Blocks.REINFORCED_DEEPSLATE) {
					world.setBlock(BlockPos.containing(x + RebirthIncModVariables.MapVariables.get(world).sx, y + RebirthIncModVariables.MapVariables.get(world).sy, z + RebirthIncModVariables.MapVariables.get(world).sz),
							RebirthIncModBlocks.MINHOCALHAU.get().defaultBlockState(), 3);
				}
				RebirthIncMod.queueServerWork(20, () -> {
					RebirthIncModVariables.MapVariables.get(world).sx = 0;
					RebirthIncModVariables.MapVariables.get(world).syncData(world);
					RebirthIncModVariables.MapVariables.get(world).sy = 0;
					RebirthIncModVariables.MapVariables.get(world).syncData(world);
					RebirthIncModVariables.MapVariables.get(world).sz = 0;
					RebirthIncModVariables.MapVariables.get(world).syncData(world);
				});
			});
		});
	}
}
