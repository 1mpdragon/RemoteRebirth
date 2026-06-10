
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.rebirthinc.RebirthIncMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RebirthIncModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RebirthIncMod.MODID);
	public static final RegistryObject<CreativeModeTab> TESTE = REGISTRY.register("teste",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rebirth_inc.teste")).icon(() -> new ItemStack(RebirthIncModItems.VACADACHUVA_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RebirthIncModItems.VACADACHUVA_SPAWN_EGG.get());
				tabData.accept(RebirthIncModItems.PORCODEMUSGO_SPAWN_EGG.get());
				tabData.accept(RebirthIncModItems.PEDRADOGRITO_SPAWN_EGG.get());
				tabData.accept(RebirthIncModItems.MINHOCA.get());
				tabData.accept(RebirthIncModItems.OCILOSCOPIO.get());
				tabData.accept(RebirthIncModBlocks.RADIO.get().asItem());
				tabData.accept(RebirthIncModBlocks.METALLURGIC_CLAY_MOLD.get().asItem());
				tabData.accept(RebirthIncModItems.NAIL.get());
				tabData.accept(RebirthIncModItems.ACORA_IRA.get());
				tabData.accept(RebirthIncModBlocks.MINHOCALHAU.get().asItem());
				tabData.accept(RebirthIncModBlocks.WORK_SHOP.get().asItem());
				tabData.accept(RebirthIncModBlocks.PEDRITAS.get().asItem());
				tabData.accept(RebirthIncModBlocks.BACKPACKBLOCK.get().asItem());
				tabData.accept(RebirthIncModItems.VERA.get());
				tabData.accept(RebirthIncModItems.VERABAG.get());
			}).build());
	public static final RegistryObject<CreativeModeTab> BLACKSMITH = REGISTRY.register("blacksmith",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rebirth_inc.blacksmith")).icon(() -> new ItemStack(RebirthIncModItems.ROCK_HAMMER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RebirthIncModBlocks.METALLURGIC_SMELTER.get().asItem());
				tabData.accept(RebirthIncModItems.METALLURGIC_BUCKET.get());
				tabData.accept(RebirthIncModItems.METALLURGICCLAMP.get());
				tabData.accept(RebirthIncModItems.ROCK_HAMMER.get());
				tabData.accept(RebirthIncModItems.IRONPLATE.get());
				tabData.accept(RebirthIncModItems.IRONAXEPART.get());
				tabData.accept(RebirthIncModItems.IRONMEDIUMSWORDPART.get());
				tabData.accept(RebirthIncModItems.IRONSHOVELPART.get());
				tabData.accept(RebirthIncModItems.IRONPICKAXEPART.get());
				tabData.accept(RebirthIncModItems.IRONHOEPART.get());
				tabData.accept(RebirthIncModBlocks.ANVIL.get().asItem());
			}).withSearchBar().withTabsBefore(TESTE.getId()).build());
	public static final RegistryObject<CreativeModeTab> COSTURA = REGISTRY.register("costura",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rebirth_inc.costura")).icon(() -> new ItemStack(RebirthIncModItems.REELSTRING.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RebirthIncModItems.IRONNEDDLE.get());
				tabData.accept(RebirthIncModItems.REEL.get());
				tabData.accept(RebirthIncModItems.REELSTRING.get());
				tabData.accept(RebirthIncModItems.PIN.get());
			}).withTabsBefore(BLACKSMITH.getId()).build());
	public static final RegistryObject<CreativeModeTab> FARMING = REGISTRY.register("farming",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rebirth_inc.farming")).icon(() -> new ItemStack(RebirthIncModItems.TOMATO.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RebirthIncModItems.TOMATOSEED.get());
			}).withTabsBefore(COSTURA.getId()).build());
	public static final RegistryObject<CreativeModeTab> NATURE = REGISTRY.register("nature",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.rebirth_inc.nature")).icon(() -> new ItemStack(RebirthIncModBlocks.PALE_EYE_LOG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RebirthIncModBlocks.PALE_EYE_LOG.get().asItem());
				tabData.accept(RebirthIncModBlocks.PALE_EYE_WOOD.get().asItem());
				tabData.accept(RebirthIncModBlocks.PALE_EYE_LEAVES.get().asItem());
			}).withSearchBar().withTabsBefore(FARMING.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(RebirthIncModBlocks.PEDRITAS.get().asItem());
			tabData.accept(RebirthIncModBlocks.PALE_EYE_LOG.get().asItem());
			tabData.accept(RebirthIncModBlocks.PALE_EYE_WOOD.get().asItem());
		}
	}
}
