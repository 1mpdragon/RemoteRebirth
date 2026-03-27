package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class TrinketCheckProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:logs")))) {
			return false;
		}
		return true;
	}
}
