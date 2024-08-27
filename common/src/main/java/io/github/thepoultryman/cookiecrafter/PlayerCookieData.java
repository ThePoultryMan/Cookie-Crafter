package io.github.thepoultryman.cookiecrafter;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayerCookieData {
    private int cookies = 0;
    private List<String> completedAchievements = new ArrayList<>();

    public void addCookies(int amount) {
        this.cookies += amount;
    }

    public void addCookieData(CompoundTag compoundTag) {
        CompoundTag nestedCompoundTag = new CompoundTag();
        nestedCompoundTag.putInt("cookies", this.cookies);
        ListTag achievementsTag = new ListTag();
        achievementsTag.add(StringTag.valueOf("test"));
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
            }
        }
    }
}
