package net.mcreator.rebirthinc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.rebirthinc.init.RebirthIncModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerHandOciloscopioProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(RenderPlayerEvent.Pre event) {
		execute(event, (Player) event.getEntity(), (HumanoidModel) event.getRenderer().getModel());
	}

	public static void execute(Entity entity, HumanoidModel Model) {
		execute(null, entity, Model);
	}

	private static void execute(@Nullable Event event, Entity entity, HumanoidModel Model) {
		if (entity == null || Model == null)
			return;
		if (RebirthIncModItems.OCILOSCOPIO.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			Model.rightArmPose = HumanoidModel.ArmPose.SPYGLASS;
			Model.body.x = 10;
		}
	}
}
