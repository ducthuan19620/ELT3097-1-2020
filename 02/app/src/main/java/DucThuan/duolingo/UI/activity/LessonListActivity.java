package DucThuan.duolingo.UI.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import DucThuan.duolingo.R;

public class LessonListActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        mTextView = (TextView) findViewById(R.id.text);

    }
}