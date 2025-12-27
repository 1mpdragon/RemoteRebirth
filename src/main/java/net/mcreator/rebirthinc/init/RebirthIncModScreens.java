
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.rebirthinc.client.gui.FolhaGUIScreen;
import net.mcreator.rebirthinc.client.gui.BackpackScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RebirthIncModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(RebirthIncModMenus.BACKPACK.get(), BackpackScreen::new);
			MenuScreens.register(RebirthIncModMenus.FOLHA_GUI.get(), FolhaGUIScreen::new);
		});
	}
}
