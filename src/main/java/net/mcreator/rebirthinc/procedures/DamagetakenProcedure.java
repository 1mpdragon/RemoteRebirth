package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.rebirthinc.network.RebirthIncModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DamagetakenProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity, double amount) {
		execute(null, world, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double Hp = 0;
		if (sourceentity instanceof Player) {
			RebirthIncModVariables.damage_delt = amount;
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + RebirthIncModVariables.damage_delt)), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + amount)), false);
		}
	}
}
