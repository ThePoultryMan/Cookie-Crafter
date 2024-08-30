package io.github.thepoultryman.cookiecrafter.client;

import io.github.thepoultryman.cookiecrafter.achievement.Achievement;
import io.github.thepoultryman.cookiecrafter.achievement.AchievementLoader;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class CookieScreen extends Screen {
    public CookieScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        int middleHorizontal = this.width / 2 - 10;
        int middleVertical = this.height / 2 - 10;
        for (Map.Entry<String, Achievement> entry : AchievementLoader.achievementMap.entrySet()) {
            Achievement achievement = entry.getValue();
            this.addRenderableOnly(new AchievementWidget(
                    middleHorizontal + achievement.getPosition().x() * 40,
                    middleVertical + achievement.getPosition().y() * 40,
                    achievement.getDisplay().icon(),
                    achievement.getDisplay().title(),
                    achievement.getDisplay().description()));
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        guiGraphics.fill(8, 8, this.width - 8, this.height - 8, 0xFF141414);
        super.render(guiGraphics, i, j, f);
        guiGraphics.renderOutline(8, 8, this.width - 16, this.height - 16, 0xFFe9c8a4);
        guiGraphics.drawString(this.font, Component.translatable("cookiecrafter.title"), 14, 14, 0xFFFFFF, true);
    }
}
