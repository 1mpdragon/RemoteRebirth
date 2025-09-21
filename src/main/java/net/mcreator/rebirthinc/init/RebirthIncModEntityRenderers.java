
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.rebirthinc.client.renderer.VacadachuvaRenderer;
import net.mcreator.rebirthinc.client.renderer.PorcodemusgoRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RebirthIncModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(RebirthIncModEntities.VACADACHUVA.get(), VacadachuvaRenderer::new);
		event.registerEntityRenderer(RebirthIncModEntities.PORCODEMUSGO.get(), PorcodemusgoRenderer::new);
	}
}
