package net.mcreator.rebirthinc.network.packet;

import net.mcreator.rebirthinc.item.DrawableMapItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SaveDrawingPacket {

    // os pixels que vão ser enviados do cliente pro servidor
    private final byte[] pixels;

    // construtor normal — usado ao enviar
    public SaveDrawingPacket(byte[] pixels) {
        this.pixels = pixels;
    }

    // construtor de leitura — usado ao receber
    public SaveDrawingPacket(FriendlyByteBuf buf) {
        this.pixels = buf.readByteArray();
    }

    // escreve os pixels no buffer pra enviar
    public void encode(FriendlyByteBuf buf) {
        buf.writeByteArray(pixels);
    }

    // roda no servidor ao receber o packet
    // pega o item na mão do jogador e salva os pixels no NBT
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            DrawableMapItem.setPixels(stack, pixels);
        });
        ctx.get().setPacketHandled(true);
    }
}