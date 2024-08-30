package io.github.thepoultryman.cookiecrafter.neoforge;

import io.github.thepoultryman.cookiecrafter.CookieCrafterClient;
import io.github.thepoultryman.cookiecrafter.Cookiecrafter;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = Cookiecrafter.MOD_ID, dist = Dist.CLIENT)
public class CookieCrafterClientNeoForge {
    public CookieCrafterClientNeoForge() {
        CookieCrafterClient.init();
    }
}
