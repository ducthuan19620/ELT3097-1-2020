package DucThuan.duolingo.UI.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

import DucThuan.duolingo.Data.Repository;
import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.QuestionWelcome.Direction;
import DucThuan.duolingo.Utils.ActivityNavigation;
import DucThuan.duolingo.Utils.Injection;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PickDailyGoalActivity extends AppCompatActivity {

    @BindView(R.id.back_button)
    Button backButton;

    @BindView(R.id.casual)
    RelativeLayout casualGoal;

    @BindView(R.id.casual_goal)
    TextView casual_goal;

    @BindView(R.id.five_min)
    TextView five_min;

    @BindView(R.id.regular)
    RelativeLayout regularGoal;

    @BindView(R.id.regular_goal)
    TextView regular_goal;

    @BindView(R.id.ten_min)
    TextView ten_min;

    @BindView(R.id.serious)
    RelativeLayout seriousGoal;

    @BindView(R.id.serious_goal)
    TextView serious_goal;

    @BindView(R.id.fif_min)
    TextView fif_min;

    @BindView(R.id.insane)
    RelativeLayout insaneGoal;

    @BindView(R.id.insane_goal)
    TextView insane_goal;

    @BindView(R.id.twen_min)
    TextView twen_min;

    @BindView(R.id.continue_button)
    Button continueButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    int checkedButton;

    Repository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_daily_goal);

        ButterKnife.bind(this);

        repository = Injection.provideRepository();
        progressBar.setProgress(4);

        continueListener();
    }

    private void continueListener() {

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dailyGoal = 2;

                if(checkedButton == 3) dailyGoal = 50; else dailyGoal = (checkedButton + 1) * 10;

                repository.setDailyGoal(dailyGoal);

                Intent intent = new Intent(PickDailyGoalActivity.this, Direction.class);
                startActivity(intent);
            }
        });
    }

    public void casual_selected(View view) {
        casualGoal.setBackground(getDrawable(R.drawable.question_first_selected));
        casual_goal.setTextColor(getColor(R.color.blue_stock));
        five_min.setTextColor(getColor(R.color.blue_stock));

        regularGoal.setBackground(getDrawable(R.drawable.question_view));
        regular_goal.setTextColor(getColor(R.color.custom_view_text_color));
        ten_min.setTextColor(getColor(R.color.custom_view_text_color));

        seriousGoal.setBackground(getDrawable(R.drawable.question_view));
        serious_goal.setTextColor(getColor(R.color.custom_view_text_color));
        fif_min.setTextColor(getColor(R.color.custom_view_text_color));

        insaneGoal.setBackground(getDrawable(R.drawable.question_end));
        insane_goal.setTextColor(getColor(R.color.custom_view_text_color));
        twen_min.setTextColor(getColor(R.color.custom_view_text_color));
    }

    public void regular_selected(View view) {
        casualGoal.setBackground(getDrawable(R.drawable.question_first));
        casual_goal.setTextColor(getColor(R.color.custom_view_text_color));
        five_min.setTextColor(getColor(R.color.custom_view_text_color));

        regularGoal.setBackground(getDrawable(R.drawable.question_view_selected));
        regular_goal.setTextColor(getColor(R.color.blue_stock));
        ten_min.setTextColor(getColor(R.color.blue_stock));

        seriousGoal.setBackground(getDrawable(R.drawable.question_view));
        serious_goal.setTextColor(getColor(R.color.custom_view_text_color));
        fif_min.setTextColor(getColor(R.color.custom_view_text_color));

        insaneGoal.setBackground(getDrawable(R.drawable.question_end));
        insane_goal.setTextColor(getColor(R.color.custom_view_text_color));
        twen_min.setTextColor(getColor(R.color.custom_view_text_color));
    }

    public void serious_selected(View view) {
        casualGoal.setBackground(getDrawable(R.drawable.question_first));
        casual_goal.setTextColor(getColor(R.color.custom_view_text_color));
        five_min.setTextColor(getColor(R.color.custom_view_text_color));

        regularGoal.setBackground(getDrawable(R.drawable.question_view));
        regular_goal.setTextColor(getColor(R.color.custom_view_text_color));
        ten_min.setTextColor(getColor(R.color.custom_view_text_color));

        seriousGoal.setBackground(getDrawable(R.drawable.question_view_selected));
        serious_goal.setTextColor(getColor(R.color.blue_stock));
        fif_min.setTextColor(getColor(R.color.blue_stock));

        insaneGoal.setBackground(getDrawable(R.drawable.question_end));
        insane_goal.setTextColor(getColor(R.color.custom_view_text_color));
        twen_min.setTextColor(getColor(R.color.custom_view_text_color));
    }

    public void insane_selected(View view) {
        casualGoal.setBackground(getDrawable(R.drawable.question_first));
        casual_goal.setTextColor(getColor(R.color.custom_view_text_color));
        five_min.setTextColor(getColor(R.color.custom_view_text_color));

        regularGoal.setBackground(getDrawable(R.drawable.question_view));
        regular_goal.setTextColor(getColor(R.color.custom_view_text_color));
        ten_min.setTextColor(getColor(R.color.custom_view_text_color));

        seriousGoal.setBackground(getDrawable(R.drawable.question_view));
        serious_goal.setTextColor(getColor(R.color.custom_view_text_color));
        fif_min.setTextColor(getColor(R.color.custom_view_text_color));

        insaneGoal.setBackground(getDrawable(R.drawable.question_end_selected));
        insane_goal.setTextColor(getColor(R.color.blue_stock));
        twen_min.setTextColor(getColor(R.color.blue_stock));
    }
}
