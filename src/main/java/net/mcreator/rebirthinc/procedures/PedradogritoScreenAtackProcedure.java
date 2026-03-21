package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;
import net.mcreator.rebirthinc.init.RebirthIncModAttributes;
import net.mcreator.rebirthinc.entity.PedradogritoEntity;

import java.util.List;
import java.util.Comparator;

public class PedradogritoScreenAtackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get())
				? _livingEntity0.getAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get()).getBaseValue()
				: 0) <= 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator || entityiterator instanceof PedradogritoEntity || entityiterator.isShiftKeyDown())) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rebirth_inc:pedradogrito_scream")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rebirth_inc:pedradogrito_scream")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), y, (entityiterator.getZ())));
						if (entity instanceof PedradogritoEntity) {
							((PedradogritoEntity) entity).setAnimation("1");
						}
						{
							double _setval = 240;
							entityiterator.getCapability(RebirthIncModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PedradogritoJumpscare = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get()))
							_livingEntity9.getAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get()).setBaseValue(240);
					}
				}
			}
		} else {
			if ((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get())
					? _livingEntity11.getAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get()).getBaseValue()
					: 0) >= 240) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator || entityiterator instanceof PedradogritoEntity)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 5, false, false));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.SONIC_BOOM)),
									(float) (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity15.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
						}
					}
				}
			}
			if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get()))
				_livingEntity20.getAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get())
						.setBaseValue(((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get())
								? _livingEntity19.getAttribute(RebirthIncModAttributes.SCREAM_COULDOWN.get()).getBaseValue()
								: 0) - 1));
		}
	}
}
