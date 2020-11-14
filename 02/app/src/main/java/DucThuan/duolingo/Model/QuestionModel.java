package DucThuan.duolingo.Model;

public class QuestionModel {

    String question;
    String answer;
    String choice1;
    String choice2;

    public QuestionModel(String question, String answer, String choice1, String choice2) {
        this.question = question;
        this.answer = answer;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getChoice1() { return choice1; }
    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() { return choice2; }
    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

}
