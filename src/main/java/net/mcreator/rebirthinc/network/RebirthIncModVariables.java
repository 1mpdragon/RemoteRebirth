package net.mcreator.rebirthinc.network;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RebirthIncModVariables {
	public static double damage_delt = 0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}
}
