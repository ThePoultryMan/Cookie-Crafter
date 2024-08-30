package io.github.thepoultryman.cookiecrafter.client;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

public class AchievementWidget extends AbstractWidget {
    private final ResourceLocation achievementTexture;

    public AchievementWidget(int i, int j, ResourceLocation achievementTexture, MutableComponent title, MutableComponent description) {
        super(i, j, 20, 20, title);
        this.achievementTexture = achievementTexture;
        this.setTooltip(Tooltip.create(title.append("\n").append(description.withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)))));
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int i, int j, float f) {
        guiGraphics.blit(this.achievementTexture, this.getX(), this.getY(), 16, 16, 0.0f, 0.0f, 16, 16, 16, 16);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
