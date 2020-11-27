package DucThuan.duolingo.UI.activity.QuestionWelcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
/*
    Creat by Duc Thuan
        27/11/2020
 */
import DucThuan.duolingo.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Question2 extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.back_button)
    Button backButton;

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
}