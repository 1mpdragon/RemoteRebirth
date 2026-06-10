
package net.mcreator.rebirthinc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class VeraItem extends Item {
	public VeraItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
