package DucThuan.duolingo.Data.Local;

import java.util.ArrayList;
import java.util.Random;

import DucThuan.duolingo.Data.DataSource;
import DucThuan.duolingo.Model.PairModel;
import DucThuan.duolingo.Model.QuestionModel;

public class QuestionDataSource implements DataSource.Local {

    private static QuestionDataSource INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();
    ArrayList<String> choice1 = new ArrayList<>();
    ArrayList<String> choice2 = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSource getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSource();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("Họ ăn cơm");
        question.add("Chúng tôi ăn bánh mì");
        question.add("Anh ấy ăn bánh");
        question.add("Cô ấy ăn cơm");
        question.add("Tôi thích cà phê");
        question.add("Họ thích trà");
        question.add("Họ thích cơm");
        question.add("Anh ấy thích nước cam");
        question.add("Tôi thích trà");

        //Answer
        answer.add("They eat rice");
        answer.add("We eat bread");
        answer.add("He eats cake");
        answer.add("She eats rice");
        answer.add("I like coffee");
        answer.add("They like tea");
        answer.add("They like rice");
        answer.add("He likes orange juice");
        answer.add("I like tea");

        choice1 = answer;
        choice2 = answer;

        int randomIndex = random.nextInt(question.size());

        int randomIndex1 = random.nextInt(question.size());
        while (randomIndex1 == randomIndex){
            randomIndex1 = random.nextInt(question.size());
        }

        int randomIndex2 = random.nextInt(question.size());
        while (randomIndex2 == randomIndex || randomIndex2 == randomIndex1){
            randomIndex2 = random.nextInt(question.size());
        }

        questionModel = new QuestionModel(
                question.get(randomIndex),
                answer.get(randomIndex),
                choice1.get(randomIndex1),
                choice2.get(randomIndex2));

        return questionModel;
    }

    @Override
    public ArrayList<PairModel> getPairs() {

        ArrayList<PairModel> pairs = new ArrayList<>();

        pairs.add(new PairModel("táo", "apple"));
        pairs.add(new PairModel("sữa", "milk"));
        pairs.add(new PairModel("bread", "bánh mì"));
        pairs.add(new PairModel("He", "Anh ấy"));
        pairs.add(new PairModel("Cô ấy", "she"));
        pairs.add(new PairModel("a", "một"));
        pairs.add(new PairModel("cơm", "rice"));
        pairs.add(new PairModel("girl", "cô  gái"));
        pairs.add(new PairModel("các", "the"));
        pairs.add(new PairModel("bạn", "you"));
        pairs.add(new PairModel("uống", "drink"));
        pairs.add(new PairModel("nước", "water"));

        return pairs;
    }

    @Override
    public ArrayList<String> getAnswer() {
        return answer;
    }

    @Override
    public ArrayList<String> getChoice1() {
        return choice1;
    }

    @Override
    public ArrayList<String> getChoice2() {
        return choice2;
    }

}