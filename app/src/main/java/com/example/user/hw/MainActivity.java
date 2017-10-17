package com.example.user.hw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;

    //метод start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(view.getContext());
            }
        });
        Button shareBtn = (Button) findViewById(R.id.share_btn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                TextView text = (TextView) findViewById(R.id.editText);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        Button fragm_btn = (Button) findViewById(R.id.to_fragm_act_btn);
        fragm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),FragmActivity.class);
                startActivity(intent);
            }
        });
        final EditText textField = (EditText) findViewById(R.id.editText);
        Button nextBtn = (Button) findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResultActivity.class);
                intent.putExtra("input text", textField.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            EditText b = (EditText) findViewById(R.id.editText);
            TextView res = (TextView) findViewById(R.id.result_txtView);
            if (resultCode == RESULT_OK) {
                res.setText(R.string.correct_input_txt);
            } else if (resultCode == RESULT_CANCELED) {
                res.setText(R.string.incorrect_input_txt);
                b.setText(R.string.input_text_view);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ExplActivity.class);
        context.startActivity(intent);
    }
}
