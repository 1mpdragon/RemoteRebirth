package net.mcreator.rebirthinc.procedures;

import virtuoel.pehkui.api.ScaleTypes;
import virtuoel.pehkui.api.ScaleOperations;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.rebirthinc.init.RebirthIncModItems;
import net.mcreator.rebirthinc.init.RebirthIncModAttributes;
import net.mcreator.rebirthinc.entity.VacadachuvaEntity;

public class VacadachuvaRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double previousRecipe = 0;
		if (itemstack.getItem() == RebirthIncModItems.MINHOCA.get()) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(sourceentity))) {
				itemstack.setCount((int) (itemstack.getCount() - 1));
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
			if ((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(RebirthIncModAttributes.FEEDSIZE.get()) ? _livingEntity9.getAttribute(RebirthIncModAttributes.FEEDSIZE.get()).getValue() : 0) >= 10) {
				ScaleTypes.BASE.getScaleData(entity).setTargetScale((float) ScaleOperations.ADD.applyAsDouble(ScaleTypes.BASE.getScaleData(entity).getTargetScale(), 0.1));
				if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(RebirthIncModAttributes.FEEDSIZE.get()))
					_livingEntity11.getAttribute(RebirthIncModAttributes.FEEDSIZE.get()).setBaseValue(0);
				if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity13.getAttribute(Attributes.MAX_HEALTH)
							.setBaseValue(((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity12.getAttribute(Attributes.MAX_HEALTH).getValue() : 0) + 2));
				if ((entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity14.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getValue() : 0) < 1) {
					if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
						_livingEntity16.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
								((entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity15.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getValue() : 0)
										+ 0.05));
				}
				if (entity instanceof VacadachuvaEntity) {
					((VacadachuvaEntity) entity).setAnimation("eating");
				}
				if (entity instanceof VacadachuvaEntity) {
					((VacadachuvaEntity) entity).setAnimation("big");
				}
			} else if ((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(RebirthIncModAttributes.FEEDSIZE.get())
					? _livingEntity19.getAttribute(RebirthIncModAttributes.FEEDSIZE.get()).getValue()
					: 0) < 10) {
				if (entity instanceof VacadachuvaEntity) {
					((VacadachuvaEntity) entity).setAnimation("eating");
				}
				if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(RebirthIncModAttributes.FEEDSIZE.get()))
					_livingEntity22.getAttribute(RebirthIncModAttributes.FEEDSIZE.get())
							.setBaseValue(((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(RebirthIncModAttributes.FEEDSIZE.get())
									? _livingEntity21.getAttribute(RebirthIncModAttributes.FEEDSIZE.get()).getValue()
									: 0) + 1));
			}
		}
		if (itemstack.getItem() == Items.BLACK_DYE) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(sourceentity))) {
				itemstack.setCount((int) (itemstack.getCount() - 1));
			}
			if (entity instanceof VacadachuvaEntity animatable)
				animatable.setTexture("vaca_da_chuva_1");
		}
		if (itemstack.getItem() == Blocks.RED_CARPET.asItem()) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(sourceentity))) {
				itemstack.setCount((int) (itemstack.getCount() - 1));
			}
			if (entity instanceof VacadachuvaEntity animatable)
				animatable.setTexture("vaca_da_chuva_red");
		}
		if (itemstack.getItem() == Items.PINK_DYE) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(sourceentity))) {
				itemstack.setCount((int) (itemstack.getCount() - 1));
			}
			if (entity instanceof VacadachuvaEntity animatable)
				animatable.setTexture("vaca_da_chuva_morango");
		}
	}
}
