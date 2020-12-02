package DucThuan.duolingo.Utils;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Random;

import DucThuan.duolingo.UI.activity.LessonCompletedActivity;
import DucThuan.duolingo.UI.activity.LessonListActivity;
import DucThuan.duolingo.UI.tasks.MutipleChoice;
import DucThuan.duolingo.UI.tasks.TSTaskActivity;
import DucThuan.duolingo.UI.tasks.WordTask.WordTaskActivity;

public class ActivityNavigation {

    static ActivityNavigation INSTANCE;

    Context context;

    ArrayList<Class> activities = new ArrayList<>();

    Random random = new Random();

    public ActivityNavigation(Context context) {

         this.context = context;

        initData();
    }

    public static ActivityNavigation getInstance(Context context) {

        if (INSTANCE == null) {

            INSTANCE = new ActivityNavigation(context);
        }

        return INSTANCE;
    }

    private void initData() {
        activities.add(MutipleChoice.class);
        activities.add(TSTaskActivity.class);
        activities.add(WordTaskActivity.class);
    }

    public void takeToRandomTask() {

        int randomIndex = random.nextInt(activities.size());

        Intent intent = new Intent(context, activities.get(randomIndex));
        context.startActivity(intent);
    }

    public void lessonCompleted() {
        Intent intent = new Intent(context, LessonCompletedActivity.class);
        context.startActivity(intent);
    }
}

