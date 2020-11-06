package com.example.doulingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.doulingo.R;

public class Question3 extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButtonCheck;
    private TextView mtextResult;
    private TextView mtextResult1;
    private View mViewResult;
    private Button mButtonClose;
    private ConstraintLayout mLayoutClose;
    private Button mButtonBack;
    private Button mButtonStop;
    private ProgressBar mtrueBar;
    private int state1 = 0, state2 = 0, state3 = 0, trueAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Intent intent = getIntent();
        trueAnswer = intent.getIntExtra(Question1.EXTRA_NUMBER, 0);
        mtrueBar = findViewById(R.id.TrueBar);
        mtrueBar.setProgress(trueAnswer);

        initView();
        addAction();
        addCheck();
        closeApp();
    }


    private void closeApp() {
        mButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayoutClose.setVisibility(View.VISIBLE);
                mButtonClose.setVisibility(View.INVISIBLE);
                mButton1.setVisibility(View.INVISIBLE);
                mButton2.setVisibility(View.INVISIBLE);
                mButton3.setVisibility(View.INVISIBLE);
                mButtonCheck.setVisibility(View.INVISIBLE);

                mButtonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLayoutClose.setVisibility(View.INVISIBLE);
                        mButtonClose.setVisibility(View.VISIBLE);
                        mButton1.setVisibility(View.VISIBLE);
                        mButton2.setVisibility(View.VISIBLE);
                        mButton3.setVisibility(View.VISIBLE);
                        mButtonCheck.setVisibility(View.VISIBLE);
                    }
                });

                mButtonStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        System.exit(0);
                    }
                });
            }
        });
    }

    private void initView() {
        mButton1 = findViewById(R.id.button_1);
        mButton2 = findViewById(R.id.button_2);
        mButton3 = findViewById(R.id.button_3);
        mButtonCheck = findViewById(R.id.button_Check);
        mtextResult = findViewById(R.id.textView_Result);
        mtextResult1 = findViewById(R.id.textView_Result1);
        mViewResult = findViewById(R.id.viewResult);
        mButtonClose = findViewById(R.id.buttonClose);
        mLayoutClose = findViewById(R.id.LayoutClose);
        mButtonBack = findViewById(R.id.button_Back);
        mButtonStop = findViewById(R.id.button_Stop);
        mtrueBar = findViewById(R.id.TrueBar);
    }

    private void addCheck() {
        mButtonCheck.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (mButtonCheck.getText().toString() != "TIẾP TỤC") {
                    mButton1.setEnabled(false);
                    mButton2.setEnabled(false);
                    mButton3.setEnabled(false);
                    if (state1 % 2 == 1) {
                        mtextResult.setText("Bạn làm tốt lắm!");
                        mViewResult.setBackgroundColor(getColor(R.color.Viewtrue));
                        mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                        mButtonCheck.setText("TIẾP TỤC");
                        trueAnswer++;
                        mtrueBar.setProgress(trueAnswer);
                    } else {
                        mButtonCheck.setText("TIẾP TỤC");
                        mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                        mButtonCheck.setBackgroundResource(R.drawable.botton_checkfaulse);
                        mtextResult.setText("Trả lời đúng:");
                        mtextResult.setTextColor(getColor(R.color.Resultwrong));
                        mtextResult1.setText("I like you.");
                        mtextResult1.setTextColor(getColor(R.color.Resultwrong));
                        mViewResult.setBackgroundColor(getColor(R.color.Viewfalse));
                    }
                }
                else {
                    Intent intent = new Intent(Question3.this, Question4.class);
                    intent.putExtra(EXTRA_NUMBER,trueAnswer);
                    startActivity(intent);
                }
            }
        });
    }


    private void addAction() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state1 % 2 == 0){
                    mButton1.setBackgroundResource(R.drawable.select_button);
                    mButton2.setBackgroundResource(R.drawable.custom_botton);
                    mButton2.setTextColor(getColor(R.color.textbutton));
                    mButton3.setBackgroundResource(R.drawable.custom_botton);
                    mButton3.setTextColor(getColor(R.color.textbutton));
                    mButtonCheck.setBackgroundResource(R.drawable.select_check);
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    mButton1.setTextColor(getColor(R.color.chooseAnswer));
                    mButtonCheck.setEnabled(true);
                    state2 = 0;
                    state3 = 0;
                }
                else {
                    mButtonCheck.setEnabled(false);
                    mButton1.setBackgroundResource(R.drawable.custom_botton);
                    mButton1.setTextColor(getColor(R.color.textbutton));
                    mButtonCheck.setBackgroundResource(R.drawable.botton_check);
                    mButtonCheck.setTextColor(getColor(R.color.textCheck));
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
                    mButton1.setTextColor(getColor(R.color.textbutton));
                    mButton3.setBackgroundResource(R.drawable.custom_botton);
                    mButton3.setTextColor(getColor(R.color.textbutton));
                    mButtonCheck.setBackgroundResource(R.drawable.select_check);
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    mButton2.setTextColor(getColor(R.color.chooseAnswer));
                    mButtonCheck.setEnabled(true);
                    state1 = 0;
                    state3 = 0;
                }
                else {
                    mButtonCheck.setEnabled(false);
                    mButton2.setBackgroundResource(R.drawable.custom_botton);
                    mButton2.setTextColor(getColor(R.color.textbutton));
                    mButtonCheck.setBackgroundResource(R.drawable.botton_check);
                    mButtonCheck.setTextColor(getColor(R.color.textCheck));
                }
                state2++;
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state3 % 2 == 0){
                    mButtonCheck.setEnabled(true);
                    mButton3.setBackgroundResource(R.drawable.select_button);
                    mButton1.setBackgroundResource(R.drawable.custom_botton);
                    mButton1.setTextColor(getColor(R.color.textbutton));
                    mButton2.setBackgroundResource(R.drawable.custom_botton);
                    mButton2.setTextColor(getColor(R.color.textbutton));
                    mButtonCheck.setBackgroundResource(R.drawable.select_check);
                    mButtonCheck.setTextColor(getColor(R.color.Defaultcolor));
                    mButton3.setTextColor(getColor(R.color.chooseAnswer));
                    state1 = 0;
                    state2 = 0;
                }
                else {
                    mButtonCheck.setEnabled(false);
                    mButton3.setBackgroundResource(R.drawable.custom_botton);
                    mButton3.setTextColor(getColor(R.color.textbutton));
                    mButtonCheck.setBackgroundResource(R.drawable.botton_check);
                    mButtonCheck.setTextColor(getColor(R.color.textCheck));
                }
                state3++;
            }
        });
    }
}