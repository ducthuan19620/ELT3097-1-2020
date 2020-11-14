package DucThuan.duolingo.UI.tasks.WordTask;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.nex3z.flowlayout.FlowLayout;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import DucThuan.duolingo.Data.Repository;
import DucThuan.duolingo.Model.QuestionModel;
import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.tasks.CustomWord;
import DucThuan.duolingo.Utils.ActivityNavigation;
import DucThuan.duolingo.Utils.Injection;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WordTaskActivity extends AppCompatActivity {

    private static final String TAG = "WordTaskActivity";

    @BindView(R.id.sentence_line)
    FlowLayout sentenceLine;

    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;

    @BindView(R.id.answer_container)
    RelativeLayout answerContainer;

    @BindView(R.id.check_button)
    Button checkButton;

    @BindView(R.id.question)
    TextView tvQuestion;

    @BindView(R.id.task_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.task_notice)
    RelativeLayout taskNotice;

    @BindView(R.id.notice)
    TextView notice;

    @BindView(R.id.notice_answer)
    TextView noticeAnswer;

    private CustomWord customWord;

    private CustomLayout customLayout;

    QuestionModel questionModel;

    ArrayList<String> words = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();

    Random random = new Random();

    int progressBarValue;

    Context context = WordTaskActivity.this;

    ActivityNavigation activityNavigation;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_task);

        ButterKnife.bind(this);

        initCustomLayout();
        initData();
    }

    private class TouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN && !customLayout.empty()) {

                customWord = (CustomWord) view;
                customWord.goToViewGroup(customLayout, sentenceLine);

                checkChildCount();

                return true;
            }

            return false;
        }
    }

    private void initData() {

        checkButton.setEnabled(false);

        repository = Injection.provideRepository();

        answers = repository.getAnswer();
        questionModel = repository.getRandomQuestionObj();

        Hawk.init(this).build();

        progressBarValue = 0;

        if (Hawk.get("progressBarValue") != null) {

            progressBarValue = Hawk.get("progressBarValue");

            progressBar.setProgress(progressBarValue);
        }

        tvQuestion.setText(questionModel.getQuestion());

        randomizeCustomWords();

        activityNavigation = ActivityNavigation.getInstance(this);

        checkAnswer();
    }

    private void initCustomLayout() {

        customLayout = new CustomLayout(this);
        customLayout.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        answerContainer.addView(customLayout, params);
    }

    private void checkAnswer() {

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder answer = new StringBuilder();

                if (checkButton.getText().equals("KIỂM TRA")) {

                    for (int i = 0; i < sentenceLine.getChildCount(); i++) {

                        customWord = (CustomWord) sentenceLine.getChildAt(i);

                        answer.append(customWord.getText().toString() + " ");
                    }

                    if (answer.toString().equals(questionModel.getAnswer() + " ")) {

                        /*Toast.makeText(WordTaskActivity.this, "You Are Correct!", Toast.LENGTH_SHORT).show();*/

                        taskNotice.setVisibility(view.VISIBLE);
                        taskNotice.setBackgroundColor(getColor(R.color.notice_true));

                        notice.setText("Chính xác!");
                        notice.setTextColor(getColor(R.color.notice_green));

                        noticeAnswer.setVisibility(view.INVISIBLE);

                        checkButton.setBackground(getDrawable(R.drawable.button_continue_true));

                        progressBarValue += 10;

                        progressBar.setProgress(progressBarValue);

                        Hawk.put("progressBarValue", progressBarValue);

                        lockViews();

                    } else {

                        /*Toast.makeText(WordTaskActivity.this, "That's Not Correct. \n" + questionModel.getAnswer(), Toast.LENGTH_SHORT).show();*/

                        taskNotice.setVisibility(view.VISIBLE);
                        taskNotice.setBackgroundColor(getColor(R.color.notice_false));

                        notice.setText("Trả lời đúng:");
                        notice.setTextColor(getColor(R.color.notice_red));

                        noticeAnswer.setText(questionModel.getAnswer());
                        noticeAnswer.setTextColor(getColor(R.color.notice_red));

                        checkButton.setBackground(getDrawable(R.drawable.button_continue_false));


                       /* if (progressBarValue > 10) {

                            progressBarValue -= 10;

                        } else {

                            progressBarValue = 0;
                        }*/

                        progressBar.setProgress(progressBarValue);

                        Hawk.put("progressBarValue", progressBarValue);

                        lockViews();
                    }

                    checkButton.setText("TIẾP TỤC");
                    checkButton.setTextColor(getResources().getColor(R.color.button_task_continue));

                } else if (checkButton.getText().equals("TIẾP TỤC")) {

                    if (progressBarValue < 100) {

                        activityNavigation.takeToRandomTask();

                    } else {

                        progressBarValue = 0;

                        activityNavigation.lessonCompleted();

                        Hawk.put("progressBarValue", progressBarValue);
                    }
                }
            }
        });
    }

    private void checkChildCount() {

        if (sentenceLine.getChildCount() > 0) {

            checkButton.setBackground(getDrawable(R.drawable.button_continue_true));
            checkButton.setTextColor(getResources().getColor(R.color.button_task_continue));

            checkButton.setEnabled(true);

        } else {

            checkButton.setBackground(getDrawable(R.drawable.button_check));
            checkButton.setTextColor(getResources().getColor(R.color.button_task_check));

            checkButton.setEnabled(false);
        }
    }

    private void lockViews() {

        for (int i = 0; i < sentenceLine.getChildCount(); i++) {

            customWord = (CustomWord) sentenceLine.getChildAt(i);

            customWord.setEnabled(false);
        }

        for (int i = 0; i < customLayout.getChildCount(); i++) {

            customWord = (CustomWord) customLayout.getChildAt(i);

            customWord.setEnabled(false);
        }

    }

    private void randomizeCustomWords() {

        String[] wordsFromSentence = questionModel.getAnswer().split(" ");

        Collections.addAll(words, wordsFromSentence);

        int sentenceWordsCount = wordsFromSentence.length;

        //Declare how many words left to complete our layout
        int leftSize = 7 - sentenceWordsCount;

        //Pick a random number from "leftSize" and add 2
        int leftRandom = random.nextInt(leftSize) + 2;

        while (words.size() - leftSize < leftRandom) {

            addArrayWords();
        }

        Collections.shuffle(words);

        for (String word : words) {

            CustomWord customWord = new CustomWord(getApplicationContext(), word);

            customWord.setOnTouchListener(new TouchListener());

            customLayout.push(customWord);
        }
    }

    private void addArrayWords() {

        String[] wordsFromAnswerArray = answers.get(random.nextInt(answers.size())).split(" ");

        for (int i = 0; i < 2; i++) {

            String word = wordsFromAnswerArray[random.nextInt(wordsFromAnswerArray.length)];

            if (!words.contains(word)) {

                words.add(word);
            }
        }
    }

    @Override
    public void onBackPressed() {

        new MaterialDialog.Builder(this)
                .title("Are you sure about that?")
                .content("All progress in this lesson will be lost.")
                .positiveText("QUIT")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        progressBarValue = 0;

                        Hawk.put("progressBarValue", progressBarValue);

                        finish();
                    }
                })
                .negativeText("CANCEL")
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

