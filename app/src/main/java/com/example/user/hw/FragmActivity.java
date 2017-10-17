package com.example.user.hw;

import android.os.Bundle;

public class FragmActivity extends  android.support.v4.app.FragmentActivity  {


//    @Override
//    public void moveTo(int position) {
//        viewPager.setCurrentItem(position);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragm);
        getSupportFragmentManager()
                .beginTransaction()
                .add(new FirstFragment(), "First")
                .commit();



    }
}
