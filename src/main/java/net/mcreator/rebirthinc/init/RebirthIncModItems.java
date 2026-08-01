
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

import net.mcreator.rebirthinc.item.VerabagItem;
import net.mcreator.rebirthinc.item.VeraItem;
import net.mcreator.rebirthinc.item.TomatoseedItem;
import net.mcreator.rebirthinc.item.TomatoItem;
import net.mcreator.rebirthinc.item.RockHammerItem;
import net.mcreator.rebirthinc.item.ReelstringItem;
import net.mcreator.rebirthinc.item.ReelItem;
import net.mcreator.rebirthinc.item.PinItem;
import net.mcreator.rebirthinc.item.OciloscopioItem;
import net.mcreator.rebirthinc.item.NailItem;
import net.mcreator.rebirthinc.item.MinhocaItem;
import net.mcreator.rebirthinc.item.MetallurgicclampItem;
import net.mcreator.rebirthinc.item.MetallurgicBucketfullItem;
import net.mcreator.rebirthinc.item.MetallurgicBucketItem;
import net.mcreator.rebirthinc.item.LavaitemItem;
import net.mcreator.rebirthinc.item.IronshovelpartItem;
import net.mcreator.rebirthinc.item.IronplateItem;
import net.mcreator.rebirthinc.item.IronpickaxepartItem;
import net.mcreator.rebirthinc.item.IronneddleItem;
import net.mcreator.rebirthinc.item.IronmediumswordpartItem;
import net.mcreator.rebirthinc.item.IronhoepartItem;
import net.mcreator.rebirthinc.item.IronaxepartItem;
import net.mcreator.rebirthinc.item.CenetaRedItem;
import net.mcreator.rebirthinc.item.CanetaBlueItem;
import net.mcreator.rebirthinc.item.CanetaBlackItem;
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
	public static final RegistryObject<Item> OCILOSCOPIO = REGISTRY.register("ociloscopio", () -> new OciloscopioItem());
	public static final RegistryObject<Item> RADIO = REGISTRY.register(RebirthIncModBlocks.RADIO.getId().getPath(), () -> new RadioDisplayItem(RebirthIncModBlocks.RADIO.get(), new Item.Properties()));
	public static final RegistryObject<Item> WORK_SHOP = block(RebirthIncModBlocks.WORK_SHOP);
	public static final RegistryObject<Item> METALLURGIC_SMELTER = REGISTRY.register(RebirthIncModBlocks.METALLURGIC_SMELTER.getId().getPath(),
			() -> new MetallurgicSmelterDisplayItem(RebirthIncModBlocks.METALLURGIC_SMELTER.get(), new Item.Properties()));
	public static final RegistryObject<Item> METALLURGIC_BUCKET = REGISTRY.register("metallurgic_bucket", () -> new MetallurgicBucketItem());
	public static final RegistryObject<Item> METALLURGIC_BUCKETFULL = REGISTRY.register("metallurgic_bucketfull", () -> new MetallurgicBucketfullItem());
	public static final RegistryObject<Item> LAVAITEM = REGISTRY.register("lavaitem", () -> new LavaitemItem());
	public static final RegistryObject<Item> METALLURGIC_CLAY_MOLD = block(RebirthIncModBlocks.METALLURGIC_CLAY_MOLD);
	public static final RegistryObject<Item> METALLURGICCLAMP = REGISTRY.register("metallurgicclamp", () -> new MetallurgicclampItem());
	public static final RegistryObject<Item> PEDRADOGRITO_SPAWN_EGG = REGISTRY.register("pedradogrito_spawn_egg", () -> new ForgeSpawnEggItem(RebirthIncModEntities.PEDRADOGRITO, -6710785, -10092289, new Item.Properties()));
	public static final RegistryObject<Item> PEDRITAS = block(RebirthIncModBlocks.PEDRITAS);
	public static final RegistryObject<Item> BACKPACKBLOCK = block(RebirthIncModBlocks.BACKPACKBLOCK);
	public static final RegistryObject<Item> CANETA_BLACK = REGISTRY.register("caneta_black", () -> new CanetaBlackItem());
	public static final RegistryObject<Item> CANETA_BLUE = REGISTRY.register("caneta_blue", () -> new CanetaBlueItem());
	public static final RegistryObject<Item> CENETA_RED = REGISTRY.register("ceneta_red", () -> new CenetaRedItem());
	public static final RegistryObject<Item> IRONNEDDLE = REGISTRY.register("ironneddle", () -> new IronneddleItem());
	public static final RegistryObject<Item> REEL = REGISTRY.register("reel", () -> new ReelItem());
	public static final RegistryObject<Item> REELSTRING = REGISTRY.register("reelstring", () -> new ReelstringItem());
	public static final RegistryObject<Item> VERA = REGISTRY.register("vera", () -> new VeraItem());
	public static final RegistryObject<Item> PIN = REGISTRY.register("pin", () -> new PinItem());
	public static final RegistryObject<Item> VERABAG = REGISTRY.register("verabag", () -> new VerabagItem());
	public static final RegistryObject<Item> TOMATO = REGISTRY.register("tomato", () -> new TomatoItem());
	public static final RegistryObject<Item> TOMATOSEED = REGISTRY.register("tomatoseed", () -> new TomatoseedItem());
	public static final RegistryObject<Item> ROCK_HAMMER = REGISTRY.register("rock_hammer", () -> new RockHammerItem());
	public static final RegistryObject<Item> IRONAXEPART = REGISTRY.register("ironaxepart", () -> new IronaxepartItem());
	public static final RegistryObject<Item> IRONMEDIUMSWORDPART = REGISTRY.register("ironmediumswordpart", () -> new IronmediumswordpartItem());
	public static final RegistryObject<Item> IRONSHOVELPART = REGISTRY.register("ironshovelpart", () -> new IronshovelpartItem());
	public static final RegistryObject<Item> IRONPICKAXEPART = REGISTRY.register("ironpickaxepart", () -> new IronpickaxepartItem());
	public static final RegistryObject<Item> IRONHOEPART = REGISTRY.register("ironhoepart", () -> new IronhoepartItem());
	public static final RegistryObject<Item> IRONPLATE = REGISTRY.register("ironplate", () -> new IronplateItem());
	public static final RegistryObject<Item> ANVIL = block(RebirthIncModBlocks.ANVIL);
	public static final RegistryObject<Item> PALE_EYE_LOG = block(RebirthIncModBlocks.PALE_EYE_LOG);
	public static final RegistryObject<Item> PALE_EYE_WOOD = block(RebirthIncModBlocks.PALE_EYE_WOOD);
	public static final RegistryObject<Item> PALE_EYE_LEAVES = block(RebirthIncModBlocks.PALE_EYE_LEAVES);
	public static final RegistryObject<Item> PALE_EYE_LEAVE_LAYER = block(RebirthIncModBlocks.PALE_EYE_LEAVE_LAYER);
	public static final RegistryObject<Item> MAGNETIC_CORE = block(RebirthIncModBlocks.MAGNETIC_CORE);
	public static final RegistryObject<Item> GOLDEN_BLOSSOM_TREE_LEAVE = block(RebirthIncModBlocks.GOLDEN_BLOSSOM_TREE_LEAVE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
