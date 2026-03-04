
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

import net.mcreator.rebirthinc.item.OciloscopioItem;
import net.mcreator.rebirthinc.item.NailItem;
import net.mcreator.rebirthinc.item.MinhocaItem;
import net.mcreator.rebirthinc.item.MetallurgicclampItem;
import net.mcreator.rebirthinc.item.MetallurgicBucketfullItem;
import net.mcreator.rebirthinc.item.MetallurgicBucketItem;
import net.mcreator.rebirthinc.item.LavaitemItem;
import net.mcreator.rebirthinc.item.FolhaItem;
import net.mcreator.rebirthinc.item.AcoraIraItem;
import net.mcreator.rebirthinc.block.display.RadioDisplayItem;
import net.mcreator.rebirthinc.block.display.MetallurgicSmelterDisplayItem;
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
	public static final RegistryObject<Item> OCILOSCOPIO = REGISTRY.register("ociloscopio", () -> new OciloscopioItem());
	public static final RegistryObject<Item> RADIO = REGISTRY.register(RebirthIncModBlocks.RADIO.getId().getPath(), () -> new RadioDisplayItem(RebirthIncModBlocks.RADIO.get(), new Item.Properties()));
	public static final RegistryObject<Item> FOLHA = REGISTRY.register("folha", () -> new FolhaItem());
	public static final RegistryObject<Item> WORK_SHOP = block(RebirthIncModBlocks.WORK_SHOP);
	public static final RegistryObject<Item> METALLURGIC_SMELTER = REGISTRY.register(RebirthIncModBlocks.METALLURGIC_SMELTER.getId().getPath(),
			() -> new MetallurgicSmelterDisplayItem(RebirthIncModBlocks.METALLURGIC_SMELTER.get(), new Item.Properties()));
	public static final RegistryObject<Item> METALLURGIC_BUCKET = REGISTRY.register("metallurgic_bucket", () -> new MetallurgicBucketItem());
	public static final RegistryObject<Item> METALLURGIC_BUCKETFULL = REGISTRY.register("metallurgic_bucketfull", () -> new MetallurgicBucketfullItem());
	public static final RegistryObject<Item> LAVAITEM = REGISTRY.register("lavaitem", () -> new LavaitemItem());
	public static final RegistryObject<Item> METALLURGIC_CLAY_MOLD = block(RebirthIncModBlocks.METALLURGIC_CLAY_MOLD);
	public static final RegistryObject<Item> METALLURGICCLAMP = REGISTRY.register("metallurgicclamp", () -> new MetallurgicclampItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
