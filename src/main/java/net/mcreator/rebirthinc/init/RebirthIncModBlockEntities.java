
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.rebirthinc.block.entity.RadioTileEntity;
import net.mcreator.rebirthinc.block.entity.MetallurgicSmelterTileEntity;
import net.mcreator.rebirthinc.block.entity.MetallurgicClayMoldBlockEntity;
import net.mcreator.rebirthinc.block.entity.BackpackblockBlockEntity;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RebirthIncMod.MODID);
	public static final RegistryObject<BlockEntityType<RadioTileEntity>> RADIO = REGISTRY.register("radio", () -> BlockEntityType.Builder.of(RadioTileEntity::new, RebirthIncModBlocks.RADIO.get()).build(null));
	public static final RegistryObject<BlockEntityType<MetallurgicSmelterTileEntity>> METALLURGIC_SMELTER = REGISTRY.register("metallurgic_smelter",
			() -> BlockEntityType.Builder.of(MetallurgicSmelterTileEntity::new, RebirthIncModBlocks.METALLURGIC_SMELTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> METALLURGIC_CLAY_MOLD = register("metallurgic_clay_mold", RebirthIncModBlocks.METALLURGIC_CLAY_MOLD, MetallurgicClayMoldBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BACKPACKBLOCK = register("backpackblock", RebirthIncModBlocks.BACKPACKBLOCK, BackpackblockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
