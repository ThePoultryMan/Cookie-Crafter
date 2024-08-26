package io.github.thepoultryman.cookiecrafter;

import net.minecraft.nbt.CompoundTag;

public class PlayerCookieData {
    private int cookies = 0;

    public void addCookieData(CompoundTag compoundTag) {
        CompoundTag nestedCompoundTag = new CompoundTag();
        nestedCompoundTag.putInt("cookies", this.cookies);
        compoundTag.put("cookieData", nestedCompoundTag);
    }

    public void getCookieData(CompoundTag compoundTag) {
        if (compoundTag.contains("cookieData")) {
            CompoundTag nestedCompoundTag = compoundTag.getCompound("cookieData");
            this.cookies = nestedCompoundTag.getInt("cookies");
        }
    }
}
