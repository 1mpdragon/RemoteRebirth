
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.rebirthinc.client.particle.Smoke3Particle;
import net.mcreator.rebirthinc.client.particle.Smoke2Particle;
import net.mcreator.rebirthinc.client.particle.Smoke1Particle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RebirthIncModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(RebirthIncModParticleTypes.SMOKE_1.get(), Smoke1Particle::provider);
		event.registerSpriteSet(RebirthIncModParticleTypes.SMOKE_2.get(), Smoke2Particle::provider);
		event.registerSpriteSet(RebirthIncModParticleTypes.SMOKE_3.get(), Smoke3Particle::provider);
	}
}
