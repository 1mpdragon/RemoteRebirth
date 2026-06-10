package net.mcreator.rebirthinc.mixins;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {

    @Inject(method = "setupCollections", at = @At("HEAD"), cancellable = true)
    private void disableRecipeBook(CallbackInfo ci) {
        ci.cancel();
    }
}