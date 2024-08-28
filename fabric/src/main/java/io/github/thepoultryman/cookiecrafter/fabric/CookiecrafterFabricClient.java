package io.github.thepoultryman.cookiecrafter.fabric;

import io.github.thepoultryman.cookiecrafter.CookieCrafterClient;
import net.fabricmc.api.ClientModInitializer;

public final class CookiecrafterFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CookieCrafterClient.init();
    }
}
