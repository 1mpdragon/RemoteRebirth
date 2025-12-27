package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import java.util.ArrayList;

public class RadioAtualizationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double array_list_position = 0;
		boolean acho = false;
		ArrayList<Object> Radio_location_cords = new ArrayList<>();
		array_list_position = 0;
		if (RebirthIncModVariables.MapVariables.get(world).Radio_Location.isEmpty()) {
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(x);
			}
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(y);
			}
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(z);
			}
			{
				RebirthIncModVariables.MapVariables.get(world).Radio_Location.add((new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "Hz")));
			}
		} else {
			while (array_list_position < RebirthIncModVariables.MapVariables.get(world).Radio_Location.size()) {
				if ((RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) array_list_position) instanceof Double _doub8 ? _doub8 : 0.0D) == x
						&& (RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 1)) instanceof Double _doub9 ? _doub9 : 0.0D) == y
						&& (RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 2)) instanceof Double _doub10 ? _doub10 : 0.0D) == z) {
					break;
				} else {
					array_list_position = array_list_position + 4;
				}
			}
			if (array_list_position + 4 > RebirthIncModVariables.MapVariables.get(world).Radio_Location.size()) {
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(x);
				}
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(y);
				}
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add(z);
				}
				{
					RebirthIncModVariables.MapVariables.get(world).Radio_Location.add((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "Hz")));
				}
			}
		}
	}
}
