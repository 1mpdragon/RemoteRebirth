package net.mcreator.rebirthinc.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.LevelAccessor;

import net.minecraftforge.network.NetworkHooks;

public class WorkShopOnBlockRightClickedProcedure {

    public static void execute(LevelAccessor world, Player player) {

        // segurança básica
        if (player == null) return;
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        // abre a crafting table vanilla
        NetworkHooks.openScreen(
            serverPlayer,
            new SimpleMenuProvider(
                (id, inv, p) -> new CraftingMenu(id, inv),
                Component.literal("Crafting")
            )
        );
    }
}
