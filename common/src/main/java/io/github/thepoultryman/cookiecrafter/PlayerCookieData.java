package io.github.thepoultryman.cookiecrafter;

import io.github.thepoultryman.cookiecrafter.achievement.Achievement;
import io.github.thepoultryman.cookiecrafter.achievement.AchievementLoader;
import io.github.thepoultryman.cookiecrafter.achievement.requirement.Requirement;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;

import java.util.*;

public class PlayerCookieData {
    private int cookies = 0;
    private List<String> completedAchievements = new ArrayList<>();
    private AvailableAchievements availableAchievements;

    public void addCookies(int amount) {
        this.cookies += amount;
    }

    public void addCookieData(CompoundTag compoundTag) {
        CompoundTag nestedCompoundTag = new CompoundTag();
        nestedCompoundTag.putInt("cookies", this.cookies);
        ListTag achievementsTag = new ListTag();
        for (String completedAchievement : this.completedAchievements) {
            achievementsTag.add(StringTag.valueOf(completedAchievement));
        }
        nestedCompoundTag.put("achievements", achievementsTag);
        compoundTag.put("cookieData", nestedCompoundTag);
    }

    public void getCookieData(CompoundTag compoundTag) {
        if (compoundTag.contains("cookieData")) {
            CompoundTag cookieData = compoundTag.getCompound("cookieData");
            this.cookies = cookieData.getInt("cookies");
            if (cookieData.contains("achievements")) {
                ListTag achievements = cookieData.getList("achievements", Tag.TAG_STRING);
                for (Tag achievement : achievements) {
                    this.completedAchievements.add(achievement.getAsString());
                }
                this.availableAchievements = new AvailableAchievements(AchievementLoader.achievementMap);
                this.availableAchievements.filter(this.completedAchievements);
            }
        }
    }

    public static class AvailableAchievements {
        private List<String> cookieCountAchievements = new ArrayList<>();

        public AvailableAchievements(HashMap<String, Achievement> achievements) {
            for (Map.Entry<String, Achievement> entry : achievements.entrySet()) {
                if (Arrays.asList(entry.getValue().getRequirementTypes()).contains(Requirement.RequirementType.CookieCount)) {
                    this.cookieCountAchievements.add(entry.getKey());
                }
            }
        }

        public void filter(List<String> completedAchievements) {
            this.cookieCountAchievements.removeAll(completedAchievements);
        }
    }
}
