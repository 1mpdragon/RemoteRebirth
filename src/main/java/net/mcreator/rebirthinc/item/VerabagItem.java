
package net.mcreator.rebirthinc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class VerabagItem extends Item {
	public VerabagItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
