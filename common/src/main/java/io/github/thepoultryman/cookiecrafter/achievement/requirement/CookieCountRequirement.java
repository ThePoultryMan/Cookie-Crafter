package io.github.thepoultryman.cookiecrafter.achievement.requirement;

public class CookieCountRequirement extends Requirement {
    public final int amount;

    public CookieCountRequirement(int amount) {
        super(RequirementType.CookieCount);
        this.amount = amount;
    }
}
