
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;

import net.mcreator.rebirthinc.RebirthIncMod;

import java.util.stream.Collectors;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RebirthIncModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, RebirthIncMod.MODID);
	public static final RegistryObject<Attribute> FEEDSIZE = REGISTRY.register("feedsize", () -> new RangedAttribute("attribute.rebirth_inc.feedsize", 0, 0, 10).setSyncable(true));
	public static final RegistryObject<Attribute> DEAD = REGISTRY.register("dead", () -> new RangedAttribute("attribute.rebirth_inc.dead", 0, 0, 6).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		List.of(RebirthIncModEntities.VACADACHUVA.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList())
				.forEach(entity -> event.add(entity, FEEDSIZE.get()));
		event.add(EntityType.PLAYER, DEAD.get());
	}

	@Mod.EventBusSubscriber
	public static class PlayerAttributesSync {
		@SubscribeEvent
		public static void playerClone(PlayerEvent.Clone event) {
			Player oldPlayer = event.getOriginal();
			Player newPlayer = event.getEntity();
			newPlayer.getAttribute(DEAD.get()).setBaseValue(oldPlayer.getAttribute(DEAD.get()).getBaseValue());
		}
	}
}
