package io.github.thepoultryman.cookiecrafter.achievement;

import io.github.thepoultryman.cookiecrafter.achievement.requirement.Requirement;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class Achievement {
    private String id;
    private Position position;
    private Display display;
    private Requirement[] requirements;

    public Requirement.RequirementType[] getRequirementTypes() {
        Requirement.RequirementType[] requirementTypes = new Requirement.RequirementType[this.requirements.length];
        for (int i = 0; i < this.requirements.length; i++) {
            requirementTypes[i] = this.requirements[i].getRequirementType();
        }
        return requirementTypes;
    }

    public record Position(int x, int y) {}

    public record Display(MutableComponent title, MutableComponent description, ResourceLocation icon) {}
}
