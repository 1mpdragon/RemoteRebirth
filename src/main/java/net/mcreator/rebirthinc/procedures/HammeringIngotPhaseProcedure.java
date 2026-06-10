package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.mcreator.rebirthinc.init.RebirthIncModItems;

public class HammeringIngotPhaseProcedure {
	public static ItemStack execute(ItemStack ingot, double batidas) {
		ItemStack result = ItemStack.EMPTY;
		if (ingot.getItem() == Items.IRON_INGOT) {
			if (batidas >= 0 && batidas <= 2) {
				result = new ItemStack(Items.IRON_INGOT).copy();
			}
			if (batidas >= 3 && batidas <= 4) {
				result = new ItemStack(RebirthIncModItems.IRONPLATE.get()).copy();
			}
			if (batidas >= 5 && batidas <= 6) {
				result = new ItemStack(RebirthIncModItems.IRONSHOVELPART.get()).copy();
			}
			if (batidas >= 7 && batidas <= 8) {
				result = new ItemStack(RebirthIncModItems.IRONAXEPART.get()).copy();
			}
			if (batidas >= 9 && batidas <= 13) {
				result = new ItemStack(RebirthIncModItems.IRONHOEPART.get()).copy();
			}
			if (batidas >= 14 && batidas <= 19) {
				result = new ItemStack(RebirthIncModItems.IRONPICKAXEPART.get()).copy();
			}
			if (batidas >= 20 && batidas <= 41) {
				result = new ItemStack(RebirthIncModItems.IRONMEDIUMSWORDPART.get()).copy();
			}
		}
		return result;
	}
}
