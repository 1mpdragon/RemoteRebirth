package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.rebirthinc.init.RebirthIncModBlocks;

public class IncepcionBackPackCheckProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getItem() == RebirthIncModBlocks.BACKPACKBLOCK.get().asItem()) {
			return true;
		}
		return false;
	}
}
