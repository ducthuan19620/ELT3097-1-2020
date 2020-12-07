package DucThuan.duolingo.UI.activity;

import androidx.appcompat.app.AppCompatActivity;
/*
    Creat by Duc Thuan
        26/11/2020
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.LessonListActivity.LessonListActivity;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hello);

        Intent intent = getIntent();
        final int login = intent.getIntExtra(SignInActivity.EXTRA_NUMBER, 0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (login == 1 ) {
                    Intent intent = new Intent(HelloActivity.this, LessonListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(HelloActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },5500);
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}