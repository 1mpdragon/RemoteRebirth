package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.rebirthinc.init.RebirthIncModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PogoJumpProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RebirthIncModItems.NAIL.get()) {
			if (world.isEmptyBlock(BlockPos.containing(sourceentity.getX(), sourceentity.getY() - 0.5, sourceentity.getZ())) && sourceentity.getXRot() >= 45) {
				sourceentity.setDeltaMovement(new Vec3((sourceentity.getDeltaMovement().x()),
						(0.5 - (sourceentity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity8.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getValue() : 0)),
						(sourceentity.getDeltaMovement().z())));
			}
		}
	}
}
