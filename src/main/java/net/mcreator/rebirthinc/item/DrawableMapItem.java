package net.mcreator.rebirthinc.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class DrawableMapItem {

    // tamanho do mapa — tem que ser igual ao MAP_SIZE do DrawableMapScreen
    public static final int MAP_SIZE = 64;

    // lê os pixels do NBT do item
    // se não tiver nada salvo ainda, retorna um array zerado
    public static byte[] getPixels(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("DrawingPixels")) {
            return tag.getByteArray("DrawingPixels");
        }
        return new byte[MAP_SIZE * MAP_SIZE];
    }

    // salva os pixels no NBT do item
    public static void setPixels(ItemStack stack, byte[] pixels) {
        stack.getOrCreateTag().putByteArray("DrawingPixels", pixels);
    }
}