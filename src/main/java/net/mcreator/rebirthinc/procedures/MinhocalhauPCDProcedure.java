package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

import java.util.Map;

public class MinhocalhauPCDProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Direction local_random_direction = Direction.NORTH;
		double random_int = 0;
		if (Mth.nextDouble(RandomSource.create(), 1, 10) < 2) {
			local_random_direction = Direction.getRandom(RandomSource.create());
			if (!((world.getBlockState(BlockPos.containing(x + local_random_direction.getStepX(), y + local_random_direction.getStepY(), z + local_random_direction.getStepZ()))).getBlock() == Blocks.AIR)) {
				{
					BlockPos _bp = BlockPos.containing(x + local_random_direction.getStepX(), y + local_random_direction.getStepY(), z + local_random_direction.getStepZ());
					BlockState _bs = RebirthIncModBlocks.MINHOCALHAU.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
		}
	}
}
