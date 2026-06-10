
package net.mcreator.rebirthinc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TomatoseedItem extends Item {
	public TomatoseedItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
