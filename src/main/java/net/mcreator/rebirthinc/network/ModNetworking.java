package net.mcreator.rebirthinc.network;

import net.mcreator.rebirthinc.network.packet.SaveDrawingPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class ModNetworking {

    private static final String VERSION = "1";

    // canal de comunicação cliente <-> servidor
    public static SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
        new ResourceLocation("rebirthinc", "main"),
        () -> VERSION,
        VERSION::equals,
        VERSION::equals
    );

    // registra todos os packets
    public static void register() {
        CHANNEL.registerMessage(
            0,
            SaveDrawingPacket.class,
            SaveDrawingPacket::encode,
            SaveDrawingPacket::new,
            SaveDrawingPacket::handle,
            Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
    }

    // envia o packet pro servidor
    public static void sendToServer(SaveDrawingPacket packet) {
        CHANNEL.sendToServer(packet);
    }
}