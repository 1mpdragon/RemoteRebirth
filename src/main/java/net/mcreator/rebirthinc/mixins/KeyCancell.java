package net.mcreator.rebirthinc.mixins;


import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;


import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyCancell {

    @Inject(method = "keyPress", at = @At("HEAD"), cancellable = true)
    private void blockKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {

        int key_F5 = GLFW.GLFW_KEY_F3;


        if (key == key_F5) {

            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && !mc.player.hasPermissions(4)) {

                ci.cancel();
            }
        } else if (key == GLFW.GLFW_KEY_TAB) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && !mc.player.hasPermissions(4)) {

                ci.cancel();
            }
        }
    }
}

