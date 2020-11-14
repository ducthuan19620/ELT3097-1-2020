package DucThuan.duolingo.UI.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Random;

import DucThuan.duolingo.Data.Repository;
import DucThuan.duolingo.Model.QuestionModel;
import DucThuan.duolingo.R;
import DucThuan.duolingo.Utils.Injection;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MutipleChoice extends AppCompatActivity {

    @BindView(R.id.question)
    TextView tvQuestion;

    @BindView(R.id.check_button)
    Button checkButton;

    @BindView(R.id.task_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.choice_1)
    Button choice1;

    @BindView(R.id.choice_2)
    Button choice2;

    @BindView(R.id.choice_3)
    Button choice3;

    QuestionModel questionModel;

    int progressBarValue;
    int state1 = 0, state2 = 0, state3 = 0, stateChoose = 0;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutiple_choice);

        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        checkButton.setEnabled(false);

        repository = Injection.provideRepository();

        questionModel = repository.getRandomQuestionObj();

        progressBarValue = 0;

        Hawk.init(this).build();

        if (Hawk.get("progressBarValue") != null) {

            progressBarValue = Hawk.get("progressBarValue");

            progressBar.setProgress(progressBarValue);
        }

        tvQuestion.setText(questionModel.getQuestion());

        ArrayList<String> mutipleChoice = new ArrayList<>();

        mutipleChoice.add(questionModel.getAnswer());
        mutipleChoice.add(questionModel.getChoice1());
        mutipleChoice.add(questionModel.getChoice2());

        Random random = new Random();

        int randomIndex = random.nextInt(mutipleChoice.size());
        choice1.setText(mutipleChoice.get(randomIndex));
        mutipleChoice.remove(randomIndex);

        randomIndex = random.nextInt(mutipleChoice.size());
        choice2.setText(mutipleChoice.get(randomIndex));
        mutipleChoice.remove(randomIndex);

        choice3.setText(mutipleChoice.get(0));

        checkChoice();
        chooseChoice();
        checkAnswer();
        enableButton();
    }

    private Button checkChoice() {
        if(choice1.getText().equals(questionModel.getAnswer())){
            return choice1;
        }
        else if(choice2.getText().equals(questionModel.getAnswer())){
            return choice2;
        }
        else {
            return choice3;
        }
    }

    private void chooseChoice() {
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state1 % 2 == 0){
                    choice1.setBackgroundResource(R.drawable.choice_selected);
                    choice1.setTextColor(getColor(R.color.blue_background));

                    choice2.setBackgroundResource(R.drawable.choice_default);
                    choice2.setTextColor(getColor(R.color.custom_view_text_color));

                    choice3.setBackgroundResource(R.drawable.choice_default);
                    choice3.setTextColor(getColor(R.color.custom_view_text_color));

                    checkButton.setBackgroundResource(R.drawable.button_continue_true);
                    checkButton.setTextColor(getColor(R.color.button_task_continue));
                    checkButton.setEnabled(true);

                    state2 = 0;
                    state3 = 0;
                    stateChoose = 1;
                }
                else {
                    choice1.setBackgroundResource(R.drawable.choice_default);
                    choice1.setTextColor(getColor(R.color.custom_view_text_color));

                    checkButton.setBackgroundResource(R.drawable.button_check);
                    checkButton.setTextColor(getColor(R.color.button_task_check));
                    checkButton.setEnabled(false);
                }
                state1++;
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state2 % 2 == 0){
                    choice2.setBackgroundResource(R.drawable.choice_selected);
                    choice2.setTextColor(getColor(R.color.blue_background));

                    choice1.setBackgroundResource(R.drawable.choice_default);
                    choice1.setTextColor(getColor(R.color.custom_view_text_color));

                    choice3.setBackgroundResource(R.drawable.choice_default);
                    choice3.setTextColor(getColor(R.color.custom_view_text_color));

                    checkButton.setBackgroundResource(R.drawable.button_continue_true);
                    checkButton.setTextColor(getColor(R.color.button_task_continue));
                    checkButton.setEnabled(true);

                    state1 = 0;
                    state3 = 0;
                    stateChoose = 2;
                }
                else {
                    choice2.setBackgroundResource(R.drawable.choice_default);
                    choice2.setTextColor(getColor(R.color.custom_view_text_color));

                    checkButton.setBackgroundResource(R.drawable.button_check);
                    checkButton.setTextColor(getColor(R.color.button_task_check));
                    checkButton.setEnabled(false);
                }
                state2++;
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state3 % 2 == 0){
                    choice3.setBackgroundResource(R.drawable.choice_selected);
                    choice3.setTextColor(getColor(R.color.blue_background));

                    choice1.setBackgroundResource(R.drawable.choice_default);
                    choice1.setTextColor(getColor(R.color.custom_view_text_color));

                    choice2.setBackgroundResource(R.drawable.choice_default);
                    choice2.setTextColor(getColor(R.color.custom_view_text_color));

                    checkButton.setBackgroundResource(R.drawable.button_continue_true);
                    checkButton.setTextColor(getColor(R.color.button_task_continue));
                    checkButton.setEnabled(true);

                    state1 = 0;
                    state2 = 0;
                    stateChoose = 3;
                }
                else {
                    choice3.setBackgroundResource(R.drawable.choice_default);
                    choice3.setTextColor(getColor(R.color.custom_view_text_color));

                    checkButton.setBackgroundResource(R.drawable.button_check);
                    checkButton.setTextColor(getColor(R.color.button_task_check));
                    checkButton.setEnabled(false);
                }
                state3++;
            }
        });
    }

    private void checkAnswer() {

    }

    private void enableButton() {

    }
}
