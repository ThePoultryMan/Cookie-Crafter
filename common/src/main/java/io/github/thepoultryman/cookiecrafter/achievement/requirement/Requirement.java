package io.github.thepoultryman.cookiecrafter.achievement.requirement;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

public class Requirement {
    private RequirementType type;

    public Requirement(RequirementType type) {
        this.type = type;
    }

    public RequirementType getRequirementType() {
        return this.type;
    }

    public enum RequirementType {
        @SerializedName("cookie_count")
        CookieCount,
    }

    public static class Deserializer implements JsonDeserializer<Requirement> {
        @Override
        public Requirement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            RequirementType type = context.deserialize(jsonObject.get("type"), RequirementType.class);
            return switch (type) {
                case CookieCount -> new CookieCountRequirement(jsonObject.get("amount").getAsInt());
            };
        }
    }
}
