package com.example.user.hw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by User on 17.10.2017.
 */

public class ThirdFragment extends  android.support.v4.app.Fragment{


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third,container,false);
        Button mult = (Button) v.findViewById(R.id.mult_btn);
        Button div = (Button) v.findViewById(R.id.div_btn);
        Button sum = (Button) v.findViewById(R.id.sum_btn);
        Button min = (Button) v.findViewById(R.id.min_btn);
        Button back = (Button) v.findViewById(R.id.back_btn);
        Bundle bundle = getArguments();
        int rec1 = bundle.getInt("number1");
        int rec2 = bundle.getInt("number2");
        final Fragment fourth_frag = new FourthFragment();
        final Bundle bundle1 = new Bundle();
        bundle1.putInt("number1", rec1);
        bundle1.putInt("number2", rec2);
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle1.putInt("op_flag", 1);
                fourth_frag.setArguments(bundle1);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragm_act, fourth_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle1.putInt("op_flag", 2);
                fourth_frag.setArguments(bundle1);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragm_act, fourth_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle1.putInt("op_flag", 3);
                fourth_frag.setArguments(bundle1);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragm_act, fourth_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle1.putInt("op_flag", 4);
                fourth_frag.setArguments(bundle1);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragm_act, fourth_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        return v;
    }
}
