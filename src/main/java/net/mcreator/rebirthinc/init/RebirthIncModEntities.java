
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rebirthinc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.rebirthinc.entity.VacadachuvaEntity;
import net.mcreator.rebirthinc.entity.PorcodemusgoEntity;
import net.mcreator.rebirthinc.RebirthIncMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RebirthIncModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RebirthIncMod.MODID);
	public static final RegistryObject<EntityType<VacadachuvaEntity>> VACADACHUVA = register("vacadachuva",
			EntityType.Builder.<VacadachuvaEntity>of(VacadachuvaEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VacadachuvaEntity::new)

					.sized(0.9f, 0.6f));
	public static final RegistryObject<EntityType<PorcodemusgoEntity>> PORCODEMUSGO = register("porcodemusgo",
			EntityType.Builder.<PorcodemusgoEntity>of(PorcodemusgoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PorcodemusgoEntity::new)

					.sized(1.7f, 2f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			VacadachuvaEntity.init();
			PorcodemusgoEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(VACADACHUVA.get(), VacadachuvaEntity.createAttributes().build());
		event.put(PORCODEMUSGO.get(), PorcodemusgoEntity.createAttributes().build());
	}
}
