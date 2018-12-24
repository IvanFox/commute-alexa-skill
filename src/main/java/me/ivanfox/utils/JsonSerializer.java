package me.ivanfox.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public enum JsonSerializer {
    JSON_SERIALIZER;

    public final Gson gson;

    JsonSerializer() {
        gson = new GsonBuilder().create();
    }

    public <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public String toJson(Object o) {
        return gson.toJson(o);
    }
}
