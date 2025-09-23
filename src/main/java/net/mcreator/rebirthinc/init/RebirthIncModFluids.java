
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.rebirthinc.fluid.SemenFluid;
import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, RebirthIncMod.MODID);
	public static final RegistryObject<FlowingFluid> SEMEN = REGISTRY.register("semen", () -> new SemenFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_SEMEN = REGISTRY.register("flowing_semen", () -> new SemenFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(SEMEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SEMEN.get(), RenderType.translucent());
		}
	}
}
