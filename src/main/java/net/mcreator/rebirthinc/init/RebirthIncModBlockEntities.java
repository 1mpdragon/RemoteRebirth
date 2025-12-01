
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.rebirthinc.block.entity.RadioBlockEntity;
import net.mcreator.rebirthinc.block.entity.BackpacjkBlockEntity;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RebirthIncMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> BACKPACK = register("backpack", RebirthIncModBlocks.BACKPACK, BackpacjkBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RADIO = register("radio", RebirthIncModBlocks.RADIO, RadioBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
