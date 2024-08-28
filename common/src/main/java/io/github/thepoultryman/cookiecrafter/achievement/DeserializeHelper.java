package io.github.thepoultryman.cookiecrafter.achievement;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import java.lang.reflect.Type;

public class DeserializeHelper {
    public static class ResourceLocationDeserializer implements JsonDeserializer<ResourceLocation> {
        @Override
        public ResourceLocation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return ResourceLocation.parse(json.getAsString());
        }
    }

    public static class ComponentDeserializer implements JsonDeserializer<MutableComponent> {
        @Override
        public MutableComponent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Component.translatable(json.getAsString());
        }
    }
}
