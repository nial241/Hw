package com.example.user.hw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawView customView = (DrawView) findViewById(R.id.Line);
        customView.setData(new float[] { 0, 10, (float) 1.5, 14, 3, 8, 5, 20, 7, 0, 8, 12, 9, 9, 10, 13 });

    }
}