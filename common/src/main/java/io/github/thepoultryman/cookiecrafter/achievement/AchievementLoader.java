package io.github.thepoultryman.cookiecrafter.achievement;

import com.google.gson.Gson;
import io.github.thepoultryman.cookiecrafter.Cookiecrafter;
import io.github.thepoultryman.cookiecrafter.ResourceHelper;

import java.util.concurrent.atomic.AtomicInteger;

public class AchievementLoader {
    public static void loadAchievements() {
        Gson gson = new Gson();
        AtomicInteger count = new AtomicInteger();

        ResourceHelper.loadResource("achievements/wake_and_bake.json").ifPresent((reader) -> {
            Achievement achievement = gson.fromJson(reader, Achievement.class);
            count.getAndIncrement();
        });
        Cookiecrafter.LOGGER.info("Loaded " + count + " achievements.");
    }
}
