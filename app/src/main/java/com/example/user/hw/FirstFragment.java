package com.example.user.hw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends  android.support.v4.app.Fragment {

    final String LOG_TAG = "myLogs";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first,container,false);
        final EditText num1 = (EditText)  v.findViewById(R.id.inp_num_1);
        /*Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_TAG, "Button click in Fragment2");
            }
        });*/


        Button btn = (Button) v.findViewById(R.id.next_btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment second_frag = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("number1", Integer.parseInt(num1.getText().toString()));
                second_frag.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragm_act, second_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return v;
    }
}

