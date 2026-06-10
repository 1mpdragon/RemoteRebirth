package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PaleEyeLeaveLayerBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).isCollisionShapeFullBlock(world, BlockPos.containing(0, 0, 0))) {
			return true;
		}
		return false;
	}
}
