package com.example.user.hw;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by User on 07.11.2017.
 */

public class Point2Deserializer implements JsonDeserializer<Point2>{
    @Override
    public Point2 deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Point2 temp = new Point2();
        JsonObject obj = json.getAsJsonObject().get("any_map").getAsJsonObject();
        temp.setName(json.getAsJsonObject().get("name").getAsString());
        Type stringIntegerMap = new TypeToken<HashMap<String,String>>(){}.getType();
        HashMap<String,String> temp_hash_map = new Gson().fromJson(obj,stringIntegerMap);
        temp.setAny_map(temp_hash_map);
        return temp;
    }
}
