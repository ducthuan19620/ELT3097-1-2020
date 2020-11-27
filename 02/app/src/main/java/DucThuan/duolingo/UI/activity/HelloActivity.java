package DucThuan.duolingo.UI.activity;

import androidx.appcompat.app.AppCompatActivity;
/*
    Creat by Duc Thuan
        26/11/2020
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import DucThuan.duolingo.R;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HelloActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        },5500);
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}