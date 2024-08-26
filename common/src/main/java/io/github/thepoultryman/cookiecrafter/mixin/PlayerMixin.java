package io.github.thepoultryman.cookiecrafter.mixin;

import io.github.thepoultryman.cookiecrafter.duck.CookieDataDuck;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin implements CookieDataDuck {
    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    private void cookiecrafter$addAdditionalSaveData(CompoundTag compoundTag, CallbackInfo ci) {
        cookieData.addCookieData(compoundTag);
    }

    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    private void cookiecrafter$readAdditionalSaveData(CompoundTag compoundTag, CallbackInfo ci) {
        cookieData.getCookieData(compoundTag);
    }
}
