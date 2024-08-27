package io.github.thepoultryman.cookiecrafter.achievement;

import com.google.gson.Gson;
import io.github.thepoultryman.cookiecrafter.Cookiecrafter;
import io.github.thepoultryman.cookiecrafter.ResourceHelper;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AchievementLoader {
    public static HashMap<String, Achievement> achievementMap;

    public static void loadAchievements() {
        Gson gson = new Gson();
        AtomicInteger count = new AtomicInteger();
        AtomicInteger totalAchievements = new AtomicInteger();

        ResourceHelper.loadResource("achievements/_list.json").ifPresent((reader) -> {
            String[] achievements = gson.fromJson(reader, String[].class);
            totalAchievements.set(achievements.length);
            achievementMap = new HashMap<>(achievements.length);

            for (String achievement : achievements) {
                ResourceHelper.loadResource("achievements/" + achievement + ".json").ifPresent((achievementReader) -> {
                    achievementMap.put(achievement, gson.fromJson(achievementReader, Achievement.class));
                    count.getAndIncrement();
                });
            }
        });

        Cookiecrafter.LOGGER.info("Loaded " + count + "/" + totalAchievements + " achievements.");
    }
}
