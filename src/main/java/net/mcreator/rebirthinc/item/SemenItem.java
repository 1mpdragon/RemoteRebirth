
package net.mcreator.rebirthinc.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.rebirthinc.init.RebirthIncModFluids;

public class SemenItem extends BucketItem {
	public SemenItem() {
		super(RebirthIncModFluids.SEMEN, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
