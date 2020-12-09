package DucThuan.duolingo.UI.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/*
    Creat by Duc Thuan
        26/11/2020
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.LessonListActivity.LessonListActivity;

public class HelloActivity extends AppCompatActivity {

    //  private FirebaseAuth mFirebaseAuth;
    //  private FirebaseAuth.AuthStateListener mAuthStateListener;

    private String FILE_NAME = "signin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hello);

        File file = new File(getFilesDir(), FILE_NAME);

        if(file.exists()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(HelloActivity.this, LessonListActivity.class);
                    startActivity(intent);
                    finish();
                }
            },5300);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(HelloActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            },5300);
        }


        //  mFirebaseAuth = FirebaseAuth.getInstance();

    /*    mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    //user is signed in
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(HelloActivity.this, LessonListActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    },5500);
                } else {
                    //user is signed out
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(HelloActivity.this, WelcomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    },5500);
                }
            }
        }; */

    }

    @Override
    protected void onResume(){
        super.onResume();
     //   mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
       // mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        finish();
        super.onStop();
    }
}