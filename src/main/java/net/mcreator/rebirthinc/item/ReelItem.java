
package net.mcreator.rebirthinc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ReelItem extends Item {
	public ReelItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}
}
