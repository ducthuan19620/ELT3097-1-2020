package DucThuan.duolingo.UI.activity.QuestionWelcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/*
    Creat by Duc Thuan
        27/11/2020
 */
import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.PickDailyGoalActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Question2 extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.back_button)
    Button backButton;

    @BindView(R.id.friend)
    RelativeLayout friend;

    @BindView(R.id.brain)
    RelativeLayout brain;

    @BindView(R.id.school)
    RelativeLayout school;

    @BindView(R.id.job)
    RelativeLayout job;

    @BindView(R.id.cultural)
    RelativeLayout cultural;

    @BindView(R.id.travel)
    RelativeLayout travel;

    @BindView(R.id.others)
    RelativeLayout others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        ButterKnife.bind(this);

        progressBar.setProgress(3);

        Back();
    }

    private void Back() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question2.this, Question1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void Next(View view) {
        Intent intent = new Intent(Question2.this, PickDailyGoalActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}