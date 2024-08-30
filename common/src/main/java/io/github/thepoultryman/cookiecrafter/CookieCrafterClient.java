package io.github.thepoultryman.cookiecrafter;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import io.github.thepoultryman.cookiecrafter.client.CookieScreen;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;

public class CookieCrafterClient {
    public static final KeyMapping COOKIE_SCREEN_KEYMAPPING = new KeyMapping(
            "cookiecrafter.cookie_screen",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_Y,
            "cookiecrafter.title"
    );

    public static void init() {
        KeyMappingRegistry.register(COOKIE_SCREEN_KEYMAPPING);

        ClientTickEvent.CLIENT_POST.register(minecraft -> {
            while (COOKIE_SCREEN_KEYMAPPING.consumeClick()) {
                minecraft.setScreen(new CookieScreen(Component.translatable("cookiecrafter.cookie_screen")));
            }
        });
    }
}
