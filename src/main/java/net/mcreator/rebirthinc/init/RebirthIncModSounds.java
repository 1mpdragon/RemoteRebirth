
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
	public static final RegistryObject<SoundEvent> OCILOSCOPIO_FREQUENCY = REGISTRY.register("ociloscopio_frequency", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rebirth_inc", "ociloscopio_frequency")));
	public static final RegistryObject<SoundEvent> PEDRADOGRITO_SCREAM = REGISTRY.register("pedradogrito_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rebirth_inc", "pedradogrito_scream")));
	public static final RegistryObject<SoundEvent> EVIL_ASS_BELL = REGISTRY.register("evil_ass_bell", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rebirth_inc", "evil_ass_bell")));
}
