package io.github.thepoultryman.cookiecrafter.mixin;

import io.github.thepoultryman.cookiecrafter.Cookiecrafter;
import io.github.thepoultryman.cookiecrafter.duck.CookieDataDuck;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(at = @At("TAIL"), method = "onItemPickup")
    private void cookiecrafter$onItemPickup(ItemEntity itemEntity, CallbackInfo ci) {
        if (itemEntity.getOwner() instanceof Player player && itemEntity.getItem().is(Cookiecrafter.COOKIES_TAG)) {
            ((CookieDataDuck) player).addCookies(itemEntity.getItem().getCount());
        }
    }
}
