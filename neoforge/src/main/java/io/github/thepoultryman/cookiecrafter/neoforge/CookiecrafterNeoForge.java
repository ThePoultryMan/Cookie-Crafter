package io.github.thepoultryman.cookiecrafter.neoforge;

import io.github.thepoultryman.cookiecrafter.Cookiecrafter;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@Mod(Cookiecrafter.MOD_ID)
public final class CookiecrafterNeoForge {
    public CookiecrafterNeoForge() {
        // Run our common setup.
        Cookiecrafter.init();
    }
}
