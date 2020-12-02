package DucThuan.duolingo.UI.activity.QuestionWelcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.tasks.WordTask.WordTaskActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Direction extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        ButterKnife.bind(this);

        progressBar.setProgress(5);
    }

    public void StartTask(View view) {
        Intent intent = new Intent(Direction.this, WordTaskActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}