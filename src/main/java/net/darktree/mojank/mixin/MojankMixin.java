package net.darktree.mojank.mixin;

import net.darktree.mojank.MojankTexture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashScreen.class)
public class MojankMixin {

    @Shadow
    @Final
    private static Identifier LOGO;

    @Inject(method = "init(Lnet/minecraft/client/MinecraftClient;)V", at = @At("HEAD"), cancellable=true)
    private static void init(MinecraftClient client, CallbackInfo ci) {
        client.getTextureManager().registerTexture(LOGO, new MojankTexture(LOGO));
        ci.cancel();
    }

}
