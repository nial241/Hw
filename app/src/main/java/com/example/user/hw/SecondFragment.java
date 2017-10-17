package com.example.user.hw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends  android.support.v4.app.Fragment {

    //final String LOG_TAG = "myLogs";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second,container,false);
        final TextView num_2 = (TextView) v.findViewById(R.id.inp_num_2);
        Bundle bundle = getArguments();
        int recieveInfo = 1;
        if (bundle != null) {
            recieveInfo = bundle.getInt("number1");
        }
        final int rec = recieveInfo;

        Button btn_back = (Button) v.findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        Button btn_ok = (Button)v.findViewById(R.id.next_btn);
        btn_ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment third_frag = new ThirdFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("number1", rec);
                bundle.putInt("number2", Integer.parseInt(num_2.getText().toString()));

                third_frag.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragm_act, third_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}

