package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.mcreator.rebirthinc.init.RebirthIncModItems;

public class HammeringTierProcedure {
	public static boolean execute(ItemStack hammer, ItemStack ingot) {
		double Tier = 0;
		if (hammer.getItem() == RebirthIncModItems.ROCK_HAMMER.get()) {
			Tier = 1;
		}
		if ((ingot.getItem() == Items.IRON_INGOT || ingot.getItem() == Items.COPPER_INGOT) && Tier >= 1) {
			return true;
		}
		return false;
	}
}
