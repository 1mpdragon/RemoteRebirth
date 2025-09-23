package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

public class PorcodemusgoEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		double health = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity2.getAttribute(Attributes.ARMOR).setBaseValue((-20));
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 2);
		} else if (entity.isOnFire()) {
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity6.getAttribute(Attributes.ARMOR).setBaseValue((-15));
		} else {
			if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity7.getAttribute(Attributes.ARMOR).setBaseValue(20);
		}
	}
}
