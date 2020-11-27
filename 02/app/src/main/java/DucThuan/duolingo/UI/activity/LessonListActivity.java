package DucThuan.duolingo.UI.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.orhanobut.hawk.Hawk;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.tasks.MutipleChoice;
import DucThuan.duolingo.UI.tasks.WordTask.WordTaskActivity;
import DucThuan.duolingo.Utils.ActivityNavigation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonListActivity extends AppCompatActivity {

    @BindView(R.id.basic1)
    Button basic1;

    ActivityNavigation activityNavigation;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        ButterKnife.bind(this);

        openTask();

    }

    private void openTask() {
        basic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LessonListActivity.this, MutipleChoice.class);
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