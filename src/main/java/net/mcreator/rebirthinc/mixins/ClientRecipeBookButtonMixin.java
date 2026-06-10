package net.mcreator.rebirthinc.mixins;

import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public class ClientRecipeBookButtonMixin {

    @Inject(method = "init", at = @At("TAIL"))
    private void removeRecipeBookButton(CallbackInfo ci) {
        InventoryScreen screen = (InventoryScreen)(Object)this;
        screen.children().forEach(widget -> {
            if (widget instanceof ImageButton button) {
                button.visible = false;
            }
        });
    }
}

