package io.github.thepoultryman.cookiecrafter;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class Cookiecrafter {
    public static final String MOD_ID = "cookiecrafter";

    public static final TagKey<Item> COOKIES_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "cookies"));

    public static void init() {
        // Write common init code here.
    }
}
