package io.github.thepoultryman.cookiecrafter.achievement.requirement;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

public class Requirement implements JsonDeserializer<Requirement> {

    @Override
    public Requirement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        RequirementType type = context.deserialize(json.getAsJsonObject().get("type"), RequirementType.class);
        System.out.println(type);
        switch (type) {
            case CookieCount -> new CookieCountRequirement();
        }
        return null;
    }

    public enum RequirementType {
        @SerializedName("cookie_count")
        CookieCount,
    }
}
