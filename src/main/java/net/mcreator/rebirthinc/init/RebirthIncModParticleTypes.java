
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RebirthIncMod.MODID);
	public static final RegistryObject<SimpleParticleType> SMOKE_1 = REGISTRY.register("smoke_1", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SMOKE_2 = REGISTRY.register("smoke_2", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SMOKE_3 = REGISTRY.register("smoke_3", () -> new SimpleParticleType(true));
}
