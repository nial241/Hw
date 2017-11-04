package com.example.user.hw;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * Created by User on 04.11.2017.
 */

public class Point3Deserializer implements JsonDeserializer<Point3> {

    @Override
    public Point3 deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Point3 point3 = new Point3();
        String f = json.getAsJsonObject().get("money_amount").getAsString();
        BigDecimal b = new BigDecimal(f.replace(",",""));
        point3.setMoney_amount(b);
        return point3;
    }
}
