
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.rebirthinc.RebirthIncMod;

public class RebirthIncModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RebirthIncMod.MODID);
	public static final RegistryObject<CreativeModeTab> TESTE = REGISTRY.register("teste",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rebirth_inc.teste")).icon(() -> new ItemStack(RebirthIncModItems.VACADACHUVA_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RebirthIncModItems.VACADACHUVA_SPAWN_EGG.get());
				tabData.accept(RebirthIncModItems.PORCODEMUSGO_SPAWN_EGG.get());
				tabData.accept(RebirthIncModItems.NAIL.get());
				tabData.accept(RebirthIncModItems.MINHOCA.get());
				tabData.accept(RebirthIncModBlocks.MINHOCALHAU.get().asItem());
			}).build());
}
