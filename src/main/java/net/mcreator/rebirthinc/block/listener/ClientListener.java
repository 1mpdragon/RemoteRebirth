package net.mcreator.rebirthinc.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.rebirthinc.init.RebirthIncModBlockEntities;
import net.mcreator.rebirthinc.block.renderer.RadioTileRenderer;
import net.mcreator.rebirthinc.RebirthIncMod;

@Mod.EventBusSubscriber(modid = RebirthIncMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(RebirthIncModBlockEntities.RADIO.get(), context -> new RadioTileRenderer());
	}
}
