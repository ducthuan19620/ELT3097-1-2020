package DucThuan.duolingo.Data;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import DucThuan.duolingo.Model.PairModel;
import DucThuan.duolingo.Model.QuestionModel;
import DucThuan.duolingo.Model.UserData;

public interface DataSource {

    interface Local{

        ArrayList<PairModel> getPairs();

        QuestionModel getRandomQuestionObj();

        ArrayList<String> getAnswer();

        ArrayList<String> getChoice1();

        ArrayList<String> getChoice2();
    }

    interface Remote {

        FirebaseDatabase getDatabaseInstance();

        void setNewLanguage(String language);

        void setDailyXp(int xp);

        void setUserTotalXp(int xp);

        void setLastTimeVisited();

        void setDailyGoal(int dailyGoal);

        void setUserInfo(UserData userData);

        void setLessonComplete(String lesson, boolean completeness);

        void setLessonCompleteDate(String lesson);

        void getDailyGoal();

        void getDailyXp();

        void getWeekXp();

        void getLessonCompleted();
    }
}