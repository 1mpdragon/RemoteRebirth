
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.rebirthinc.fluid.types.SemenFluidType;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, RebirthIncMod.MODID);
	public static final RegistryObject<FluidType> SEMEN_TYPE = REGISTRY.register("semen", () -> new SemenFluidType());
}
