package com.example.user.hw;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class RenderJS {

    private String[] day = new String[7];


    void Render(JSONObject parObj) throws JSONException {
        JSONArray ar_j = parObj.getJSONArray("list");
        Weather o = new Weather();
        for (int i = 0 ; i<ar_j.length();i++) {
            o.setTemp(String.valueOf( Math.round(ar_j.getJSONObject(i).getJSONObject("temp").getDouble("day"))));
            o.setMax_temp(String.valueOf(Math.round( ar_j.getJSONObject(i).getJSONObject("temp").getDouble("max"))));
            o.setMin_temp(String.valueOf(Math.round(Math.floor( ar_j.getJSONObject(i).getJSONObject("temp").getDouble("min")))));
            o.setMain(ar_j.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main"));
            o.setDescription(ar_j.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description"));
            day[i] = o.to_str();
        }
    }

    public String getDay(int i){

        GregorianCalendar g =  new GregorianCalendar();
        g.roll(Calendar.DATE,i);
        return  (g.get(Calendar.DATE))+"."+(g.get(Calendar.MONTH)+1)+" "+"\n"+ day[i];
    }
}
