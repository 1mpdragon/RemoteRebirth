package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class MetaisAtributosProcedure {
	public static ArrayList execute(ItemStack metal) {
		ArrayList<Object> base = new ArrayList<>();
		ArrayList<Object> metalurgica = new ArrayList<>();
		ArrayList<Object> Ferro = new ArrayList<>();
		ArrayList<Object> returnM = new ArrayList<>();
		ArrayList<Object> Cobre = new ArrayList<>();
		boolean acho = false;
		{
			for (int i = 0; i != 4; i++) {
				metalurgica.add(null);
			}
		}
		acho = false;
		if (!acho) {
			{
				for (int i = 0; i != 1; i++) {
					Ferro.add(null);
				}
			}
			{
				metalurgica.set(0, 1);
			}
			{
				metalurgica.set(1, 3);
			}
			{
				metalurgica.set(2, 2);
			}
			{
				metalurgica.set(3, 160);
			}
			{
				Ferro.set(0, metalurgica);
			}
			if (Items.IRON_INGOT == metal.getItem()) {
				acho = true;
				returnM.addAll(Ferro);
			}
		}
		if (!acho) {
			{
				for (int i = 0; i != 1; i++) {
					Cobre.add(null);
				}
			}
			{
				metalurgica.set(0, 3);
			}
			{
				metalurgica.add(3);
			}
			{
				metalurgica.set(1, 2);
			}
			{
				metalurgica.add(2);
			}
			{
				metalurgica.set(2, 1);
			}
			{
				metalurgica.add(1);
			}
			{
				metalurgica.set(3, 140);
			}
			{
				Cobre.set(0, metalurgica);
			}
			if (Items.COPPER_INGOT == metal.getItem()) {
				acho = true;
				returnM.addAll(Cobre);
			}
		}
		return returnM;
	}
}
