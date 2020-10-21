package com.example.doulingo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButtonCheck;
    private TextView mtextResult;
    private TextView mtextResult1;
    private int state1 = 0, state2 = 0, state3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addAction();
    }

    private void addAction() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state1 % 2 == 0){
                    mButton1.setBackgroundResource(R.drawable.select_button);
                    mButton2.setBackgroundResource(R.drawable.custom_botton);
                    mButton3.setBackgroundResource(R.drawable.custom_botton);
                    mButtonCheck.setBackgroundResource(R.drawable.select_check);
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    state2 = 0;
                    state3 = 0;
                }
                else {
                    mButton1.setBackgroundResource(R.drawable.custom_botton);
                    mButtonCheck.setBackgroundResource(R.drawable.botton_check);
                }
                state1++;
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state2 % 2 == 0){
                    mButton2.setBackgroundResource(R.drawable.select_button);
                    mButton1.setBackgroundResource(R.drawable.custom_botton);
                    mButton3.setBackgroundResource(R.drawable.custom_botton);
                    mButtonCheck.setBackgroundResource(R.drawable.select_check);
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    state1 = 0;
                    state3 = 0;
                }
                else {
                    mButton2.setBackgroundResource(R.drawable.custom_botton);
                    mButtonCheck.setBackgroundResource(R.drawable.botton_check);
                }
                state2++;
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state3 % 2 == 0){
                    mButton3.setBackgroundResource(R.drawable.select_button);
                    mButton1.setBackgroundResource(R.drawable.custom_botton);
                    mButton2.setBackgroundResource(R.drawable.custom_botton);
                    mButtonCheck.setBackgroundResource(R.drawable.select_check);
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    state1 = 0;
                    state2 = 0;
                }
                else {
                    mButton3.setBackgroundResource(R.drawable.custom_botton);
                    mButtonCheck.setBackgroundResource(R.drawable.botton_check);
                }
                state3++;
            }
        });
        mButtonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state3 % 2 == 1){
                    mtextResult.setText("Bạn làm tốt lắm!");
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    mButtonCheck.setText("TIẾP TỤC");
                }
                else{
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    mButtonCheck.setBackgroundResource(R.drawable.botton_checkfaulse);
                    mtextResult.setText("Trả lời đúng:");
                    mtextResult.setTextColor(getColor(R.color.Wrongcolor));
                    mtextResult1.setText("I like coffee.");
                }
            }
        });
    }

    private void initView() {
        mButton1 = findViewById(R.id.button_1);
        mButton2 = findViewById(R.id.button_2);
        mButton3 = findViewById(R.id.button_3);
        mButtonCheck = findViewById(R.id.button_Check);
        mtextResult = findViewById(R.id.textView_Result);
    }
}