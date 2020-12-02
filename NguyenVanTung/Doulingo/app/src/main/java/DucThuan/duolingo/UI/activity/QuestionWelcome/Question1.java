package DucThuan.duolingo.UI.activity.QuestionWelcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
/*creat by Duc Thuan
    27/11/2020
 */
import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.SelectLanguageActivity.SelectLanguageActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Question1 extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.question_1)
    TextView question1;

    @BindView(R.id.question_2)
    TextView question2;

    @BindView(R.id.question_3)
    TextView question3;

    @BindView(R.id.question_4)
    TextView question4;

    @BindView(R.id.question_5)
    TextView question5;

    @BindView(R.id.question_6)
    TextView question6;

    @BindView(R.id.question_7)
    TextView question7;

    @BindView(R.id.question_8)
    TextView question8;

    @BindView(R.id.question_9)
    TextView question9;

    @BindView(R.id.back_button)
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        ButterKnife.bind(this);

        progressBar.setProgress(2);

        Next();
        Back();
    }

    private void Next() {
        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });

        question9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, Question2.class);
                startActivity(intent);
            }
        });
    }

    private void Back(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question1.this, SelectLanguageActivity.class);
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