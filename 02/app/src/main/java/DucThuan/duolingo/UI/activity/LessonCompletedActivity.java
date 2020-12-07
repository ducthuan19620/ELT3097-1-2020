package DucThuan.duolingo.UI.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.LessonListActivity.LessonListActivity;
import DucThuan.duolingo.Utils.ActivityNavigation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonCompletedActivity extends AppCompatActivity {

    @BindView(R.id.continue_button)
    Button continue_button;

    Context context;

    ActivityNavigation activityNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_completed);

        ButterKnife.bind(this);

        back();
    }

    private void back() {
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LessonCompletedActivity.this, LessonListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}