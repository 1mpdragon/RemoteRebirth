package net.mcreator.rebirthinc.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.mcreator.rebirthinc.item.CanetaBlackItem;
import net.mcreator.rebirthinc.item.CanetaBlueItem;
import net.mcreator.rebirthinc.item.CenetaRedItem;

public class AbrirMapaGUIProcedure {

    public static void execute(Level world, Entity entity) {
        if (world.isClientSide()) {
            ItemStack offhand = ((net.minecraft.world.entity.LivingEntity) entity)
                .getItemInHand(net.minecraft.world.InteractionHand.OFF_HAND);

            int color;
            if (offhand.getItem() instanceof CenetaRedItem) {
                color = 3; // vermelho
            } else if (offhand.getItem() instanceof CanetaBlueItem) {
                color = 2; // azul
            } else if (offhand.getItem() instanceof CanetaBlackItem) {
                color = 1; // preto
            } else {
                color = 1; // padrão preto se não tiver caneta
            }

            net.minecraft.client.Minecraft.getInstance()
                .setScreen(new net.mcreator.rebirthinc.client.gui.DrawableMapScreen(
                    ((net.minecraft.world.entity.LivingEntity) entity).getMainHandItem(),
                    color
                ));
        }
    }
}