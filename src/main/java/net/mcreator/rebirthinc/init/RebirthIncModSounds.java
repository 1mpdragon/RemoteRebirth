
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RebirthIncMod.MODID);
	public static final RegistryObject<SoundEvent> PARRY = REGISTRY.register("parry", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rebirth_inc", "parry")));
}
