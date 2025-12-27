package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import java.util.ArrayList;

public class RadioBlockBrokenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double array_list_position = 0;
		boolean acho = false;
		ArrayList<Object> Radio_location_cords = new ArrayList<>();
		array_list_position = 0;
		acho = false;
		while (acho == false && RebirthIncModVariables.MapVariables.get(world).Radio_Location.size() - 4 >= array_list_position) {
			if ((RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 0)) instanceof Double _doub1 ? _doub1 : 0.0D) == x
					&& (RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 1)) instanceof Double _doub2 ? _doub2 : 0.0D) == y
					&& (RebirthIncModVariables.MapVariables.get(world).Radio_Location.get((int) (array_list_position + 2)) instanceof Double _doub3 ? _doub3 : 0.0D) == z) {
				acho = true;
				for (int index1 = 0; index1 < 4; index1++) {
					{
						RebirthIncModVariables.MapVariables.get(world).Radio_Location.remove((int) array_list_position);
					}
				}
			} else {
				array_list_position = array_list_position + 4;
			}
		}
	}
}
