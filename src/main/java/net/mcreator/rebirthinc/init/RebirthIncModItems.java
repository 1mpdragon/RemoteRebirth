
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.rebirthinc.item.NailItem;
import net.mcreator.rebirthinc.item.MinhocaItem;
import net.mcreator.rebirthinc.item.BackpackitemItem;
import net.mcreator.rebirthinc.item.AcoraIraItem;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RebirthIncMod.MODID);
	public static final RegistryObject<Item> VACADACHUVA_SPAWN_EGG = REGISTRY.register("vacadachuva_spawn_egg", () -> new ForgeSpawnEggItem(RebirthIncModEntities.VACADACHUVA, -1, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> MINHOCA = REGISTRY.register("minhoca", () -> new MinhocaItem());
	public static final RegistryObject<Item> PORCODEMUSGO_SPAWN_EGG = REGISTRY.register("porcodemusgo_spawn_egg", () -> new ForgeSpawnEggItem(RebirthIncModEntities.PORCODEMUSGO, -13382656, -16738048, new Item.Properties()));
	public static final RegistryObject<Item> NAIL = REGISTRY.register("nail", () -> new NailItem());
	public static final RegistryObject<Item> MINHOCALHAU = block(RebirthIncModBlocks.MINHOCALHAU);
	public static final RegistryObject<Item> ACORA_IRA = REGISTRY.register("acora_ira", () -> new AcoraIraItem());
	public static final RegistryObject<Item> BACKPACK = block(RebirthIncModBlocks.BACKPACK);
	public static final RegistryObject<Item> BACKPACKITEM = REGISTRY.register("backpackitem", () -> new BackpackitemItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
