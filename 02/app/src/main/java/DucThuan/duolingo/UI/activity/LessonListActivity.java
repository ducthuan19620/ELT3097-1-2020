package DucThuan.duolingo.UI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.tasks.WordTask.WordTaskActivity;
import DucThuan.duolingo.Utils.ActivityNavigation;
import butterknife.BindView;

public class LessonListActivity extends AppCompatActivity {

    @BindView(R.id.basic1)
    Button basic1;

    ActivityNavigation activityNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        openTask();

    }

    private void openTask() {
        basic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LessonListActivity.this, WordTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}