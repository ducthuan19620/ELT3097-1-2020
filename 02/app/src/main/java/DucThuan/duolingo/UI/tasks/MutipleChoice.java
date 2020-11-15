package DucThuan.duolingo.UI.tasks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Random;

import DucThuan.duolingo.Data.Repository;
import DucThuan.duolingo.Model.QuestionModel;
import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.LessonListActivity;
import DucThuan.duolingo.UI.tasks.WordTask.WordTaskActivity;
import DucThuan.duolingo.Utils.ActivityNavigation;
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

    @BindView(R.id.close_task)
    Button closeTask;

    @BindView(R.id.choice_1)
    Button choice1;

    @BindView(R.id.choice_2)
    Button choice2;

    @BindView(R.id.choice_3)
    Button choice3;

    @BindView(R.id.task_notice)
    RelativeLayout taskNotice;

    @BindView(R.id.notice)
    TextView notice;

    @BindView(R.id.notice_answer)
    TextView noticeAnswer;

    QuestionModel questionModel;

    int progressBarValue;
    int state1 = 0, state2 = 0, state3 = 0, stateChoose = 0;

    Repository repository;

    Context context = MutipleChoice.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutiple_choice);

        ButterKnife.bind(this);

        initData();
        exitTask();
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
                if (state1 % 2 == 0){
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
                if (state2 % 2 == 0){
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
                if (state3 % 2 == 0){
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

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                choice1.setEnabled(false);
                choice2.setEnabled(false);
                choice3.setEnabled(false);

                if (checkButton.getText().equals("KIỂM TRA")) {

                    if (checkChoice().getCurrentTextColor() == (getColor(R.color.blue_background))) {

                        /*Toast.makeText(context, "You Are Correct!", Toast.LENGTH_SHORT).show();*/

                        taskNotice.setVisibility(view.VISIBLE);
                        taskNotice.setBackgroundColor(getColor(R.color.notice_true));

                        notice.setText("Chính xác!");
                        notice.setTextColor(getColor(R.color.notice_green));

                        noticeAnswer.setVisibility(view.INVISIBLE);

                        checkButton.setBackground(getDrawable(R.drawable.button_continue_true));

                        progressBarValue += 10;

                        progressBar.setProgress(progressBarValue);

                        Hawk.put("progressBarValue", progressBarValue);

                    } else {

                        /*Toast.makeText(context, "That's not correct!" + questionModel.getAnswer(), Toast.LENGTH_SHORT).show();*/

                        taskNotice.setVisibility(view.VISIBLE);
                        taskNotice.setBackgroundColor(getColor(R.color.notice_false));

                        notice.setText("Trả lời đúng:");
                        notice.setTextColor(getColor(R.color.notice_red));

                        noticeAnswer.setText(questionModel.getAnswer());
                        noticeAnswer.setTextColor(getColor(R.color.notice_red));

                        checkButton.setBackground(getDrawable(R.drawable.button_continue_false));


                        /*if (progressBarValue > 10) {

                            progressBarValue -= 10;

                        } else {

                            progressBarValue = 0;
                        }*/

                        progressBar.setProgress(progressBarValue);

                        Hawk.put("progressBarValue", progressBarValue);
                    }

                    checkButton.setText("TIẾP TỤC");
                    checkButton.setTextColor(getResources().getColor(R.color.button_task_continue));

                } else if (checkButton.getText().equals("TIẾP TỤC")) {

                    if (progressBarValue < 100) {

                        ActivityNavigation.getInstance(context).takeToRandomTask();

                    } else {

                        progressBarValue = 0;

                        Hawk.put("progressBarValue", progressBarValue);
                    }

                }
            }
        });
    }

    private void exitTask() {
        closeTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MutipleChoice.this)
                        .title("Bạn có chắc không?")
                        .content("Tất cả tiến trình trong bài học này sẽ bị mất.")
                        .positiveText("THOÁT")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                progressBarValue = 0;

                                Hawk.put("progressBarValue", progressBarValue);

                                Intent intent = new Intent(MutipleChoice.this, LessonListActivity.class);
                                startActivity(intent);
                            }
                        })
                        .negativeText("HỦY")
                        .show();
            }
        });
    }

    @Override
    public void onBackPressed() {

        new MaterialDialog.Builder(this)
                .title("Bạn có chắc không?")
                .content("Tất cả tiến trình trong bài học này sẽ bị mất.")
                .positiveText("THOÁT")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        progressBarValue = 0;

                        Hawk.put("progressBarValue", progressBarValue);

                        Intent intent = new Intent(MutipleChoice.this, LessonListActivity.class);
                        startActivity(intent);
                    }
                })
                .negativeText("HỦY")
                .show();
    }


    @Override
    protected void onStop() {

        progressBarValue = 0;

        Hawk.put("progressBarValue", progressBarValue);

        finish();

        super.onStop();
    }
}
