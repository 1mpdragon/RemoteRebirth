
package net.mcreator.rebirthinc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MetallurgicBucketItem extends Item {
	public MetallurgicBucketItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
