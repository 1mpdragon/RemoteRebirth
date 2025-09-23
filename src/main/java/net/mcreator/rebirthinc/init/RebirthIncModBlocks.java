
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.rebirthinc.block.SemenBlock;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RebirthIncMod.MODID);
	public static final RegistryObject<Block> SEMEN = REGISTRY.register("semen", () -> new SemenBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
