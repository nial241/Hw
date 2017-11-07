package com.example.user.hw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1
        Point1and2 srcObject_toJson = new Point1and2();
        srcObject_toJson.setName("name");
        srcObject_toJson.setAny_map(new HashMap<String, Integer>(3){{
            put("a",55);
            put("b",85);
            put("c",56);}});
        Gson gson_builder = new GsonBuilder()
                .setExclusionStrategies(new ExclStrat())
                .create();
        String json_with_ignored_field = gson_builder.toJson(srcObject_toJson);
        Log.d("Point1",json_with_ignored_field);
        TextView txt1 = (TextView) findViewById(R.id.textView2);
        txt1.setText(json_with_ignored_field);
        //2
        Gson g2 = new GsonBuilder()
                .registerTypeAdapter(Point2.class, new Point2Deserializer())
                .create();
        Point2 point2 = g2.fromJson("{\"name\":\"name\",\"any_map\":{\"a\":\"55\",\"b\":\"85\",\"c\":\"56\"}}",
                Point2.class);
        Log.d("Point 2",point2.toString());
        TextView txt2 = (TextView) findViewById(R.id.textView4);
        txt2.setText(point2.getAny_map().toString());
        //3
        Gson g3 = new GsonBuilder()
                .registerTypeAdapter(Point3.class, new Point3Deserializer())
                .create();
        Point3 point3 =  g3.fromJson("{\"money_amount\":\"2444,88\"}",Point3.class);
        Log.d("Point3",point3.getMoney_amount().toString());
        TextView txt3 = (TextView) findViewById(R.id.textView6);
        txt3.setText(point3.getMoney_amount().toString());
        //4
        DateExample temp = new DateExample(new Date());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateExample.class,new DateSerializer())
                .create();
        String json = gson.toJson(temp);
        TextView txt = (TextView) findViewById(R.id.textView8);
        txt.setText(json);
        Log.d("Point4",json);
    }

}
