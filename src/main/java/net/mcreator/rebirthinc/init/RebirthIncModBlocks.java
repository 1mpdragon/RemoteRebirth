
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.rebirthinc.block.RadioBlock;
import net.mcreator.rebirthinc.block.MinhocalhauBlock;
import net.mcreator.rebirthinc.block.BackpacjkBlock;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RebirthIncMod.MODID);
	public static final RegistryObject<Block> MINHOCALHAU = REGISTRY.register("minhocalhau", () -> new MinhocalhauBlock());
	public static final RegistryObject<Block> BACKPACK = REGISTRY.register("backpack", () -> new BackpacjkBlock());
	public static final RegistryObject<Block> RADIO = REGISTRY.register("radio", () -> new RadioBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
