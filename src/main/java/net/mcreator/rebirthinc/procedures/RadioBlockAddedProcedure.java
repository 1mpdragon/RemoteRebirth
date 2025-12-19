package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import java.util.ArrayList;

public class RadioBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double array_list_position = 0;
		boolean acho = false;
		ArrayList<Object> Radio_location_cords = new ArrayList<>();
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("Hz", 0);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		array_list_position = 0;
		if (RebirthIncModVariables.MapVariables.get(world).Radio_Location.size() == 0) {
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(x);
			}
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(y);
			}
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(z);
			}
		} else {
			acho = false;
			while (acho == false) {
				if ((RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) array_list_position) instanceof Double _doub5 ? _doub5 : 0.0D) == x) {
					if ((RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 1)) instanceof Double _doub6 ? _doub6 : 0.0D) == y) {
						if ((RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 2)) instanceof Double _doub7 ? _doub7 : 0.0D) == z) {
							break;
						} else {
							array_list_position = array_list_position + 3;
						}
					} else {
						array_list_position = array_list_position + 3;
					}
				} else {
					array_list_position = array_list_position + 3;
				}
				if (RebirthIncModVariables.MapVariables.get(world).Radio_Location.size() <= array_list_position) {
					acho = true;
				}
			}
			if (acho == true) {
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(x);
				}
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(y);
				}
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(z);
				}
			}
		}
	}
}
