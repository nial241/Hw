package com.example.user.hw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 17.10.2017.
 */

public class FourthFragment extends  android.support.v4.app.Fragment{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fourth, container, false);
        Button back = (Button) v.findViewById(R.id.back_btn);
        TextView res = (TextView) v.findViewById(R.id.res_textView);
        Bundle bundle = getArguments();
        int rec1 = bundle.getInt("number1");
        int rec2 = bundle.getInt("number2");
        int op = bundle.getInt("op_flag");
        StringBuilder sb = new StringBuilder("");
        sb.append(rec1);
        switch (op){
            case 1:{
                sb.append(" x ");
                sb.append(rec2);
                sb.append(" = ");
                sb.append(rec1*rec2);
                break;
            }
            case 2:{
                sb.append(" / ");
                sb.append(rec2);
                sb.append(" = ");
                sb.append(rec1/rec2);
                break;
            }
            case 3:{
                sb.append(" + ");
                sb.append(rec2);
                sb.append(" = ");
                sb.append(rec1+rec2);
                break;
            }
            case 4:{
                sb.append(" - ");
                sb.append(rec2);
                sb.append(" = ");
                sb.append(rec1-rec2);
                break;
            }
            default:
                break;
        }
        res.setText(sb.toString());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        return v;
    }
}
