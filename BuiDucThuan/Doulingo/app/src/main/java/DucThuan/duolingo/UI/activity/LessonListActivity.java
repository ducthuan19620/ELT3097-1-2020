package DucThuan.duolingo.UI.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orhanobut.hawk.Hawk;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.tasks.WordTask.WordTaskActivity;
import butterknife.BindView;

public class LessonListActivity extends AppCompatActivity {

    @BindView(R.id.basic1)
    Button basic1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);
    }
}