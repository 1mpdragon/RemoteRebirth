
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.rebirthinc.block.WorkShopBlock;
import net.mcreator.rebirthinc.block.RadioBlock;
import net.mcreator.rebirthinc.block.PedritasBlock;
import net.mcreator.rebirthinc.block.PaleEyeWoodBlock;
import net.mcreator.rebirthinc.block.PaleEyeLogBlock;
import net.mcreator.rebirthinc.block.PaleEyeLeavesBlock;
import net.mcreator.rebirthinc.block.PaleEyeLeaveLayerBlock;
import net.mcreator.rebirthinc.block.MinhocalhauBlock;
import net.mcreator.rebirthinc.block.MetallurgicSmelterBlock;
import net.mcreator.rebirthinc.block.MetallurgicClayMoldBlock;
import net.mcreator.rebirthinc.block.MagneticCoreBlock;
import net.mcreator.rebirthinc.block.GoldenBlossomTreeLeaveBlock;
import net.mcreator.rebirthinc.block.BackpackblockBlock;
import net.mcreator.rebirthinc.block.AnvilBlock;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RebirthIncMod.MODID);
	public static final RegistryObject<Block> MINHOCALHAU = REGISTRY.register("minhocalhau", () -> new MinhocalhauBlock());
	public static final RegistryObject<Block> RADIO = REGISTRY.register("radio", () -> new RadioBlock());
	public static final RegistryObject<Block> WORK_SHOP = REGISTRY.register("work_shop", () -> new WorkShopBlock());
	public static final RegistryObject<Block> METALLURGIC_SMELTER = REGISTRY.register("metallurgic_smelter", () -> new MetallurgicSmelterBlock());
	public static final RegistryObject<Block> METALLURGIC_CLAY_MOLD = REGISTRY.register("metallurgic_clay_mold", () -> new MetallurgicClayMoldBlock());
	public static final RegistryObject<Block> PEDRITAS = REGISTRY.register("pedritas", () -> new PedritasBlock());
	public static final RegistryObject<Block> BACKPACKBLOCK = REGISTRY.register("backpackblock", () -> new BackpackblockBlock());
	public static final RegistryObject<Block> ANVIL = REGISTRY.register("anvil", () -> new AnvilBlock());
	public static final RegistryObject<Block> PALE_EYE_LOG = REGISTRY.register("pale_eye_log", () -> new PaleEyeLogBlock());
	public static final RegistryObject<Block> PALE_EYE_WOOD = REGISTRY.register("pale_eye_wood", () -> new PaleEyeWoodBlock());
	public static final RegistryObject<Block> PALE_EYE_LEAVES = REGISTRY.register("pale_eye_leaves", () -> new PaleEyeLeavesBlock());
	public static final RegistryObject<Block> PALE_EYE_LEAVE_LAYER = REGISTRY.register("pale_eye_leave_layer", () -> new PaleEyeLeaveLayerBlock());
	public static final RegistryObject<Block> MAGNETIC_CORE = REGISTRY.register("magnetic_core", () -> new MagneticCoreBlock());
	public static final RegistryObject<Block> GOLDEN_BLOSSOM_TREE_LEAVE = REGISTRY.register("golden_blossom_tree_leave", () -> new GoldenBlossomTreeLeaveBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
