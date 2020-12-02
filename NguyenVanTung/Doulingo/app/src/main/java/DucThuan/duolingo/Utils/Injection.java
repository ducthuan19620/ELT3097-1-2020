package DucThuan.duolingo.Utils;

import DucThuan.duolingo.Data.Local.QuestionDataSource;
import DucThuan.duolingo.Data.Remote.FirebaseDatabaseHelper;
import DucThuan.duolingo.Data.Repository;

public class Injection {

    public static Repository provideRepository() {

        return Repository.getInstance(
                QuestionDataSource.getInstance(),
                FirebaseDatabaseHelper.getHelperInstance());
    }

    public static FirebaseAuthHelper providesAuthHelper() {

        return FirebaseAuthHelper.getClassInstance();
    }
}
