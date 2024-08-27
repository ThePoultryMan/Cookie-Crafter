package io.github.thepoultryman.cookiecrafter;

import io.github.thepoultryman.cookiecrafter.achievement.AchievementLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Cookiecrafter {
    public static final String MOD_ID = "cookiecrafter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final TagKey<Item> COOKIES_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "cookies"));

    public static void init() {
        AchievementLoader.loadAchievements();
    }
}
