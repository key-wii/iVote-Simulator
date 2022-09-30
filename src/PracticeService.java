import java.util.Vector;

public final class PracticeService extends VotingService {
    private Vector<String> answers = new Vector<>();

    public void askQuestion(boolean mc, String q, String a, String b) {
        answers.clear();
        answers.add(a);
        answers.add(b);
        question = newQuestion(mc, q, answers);
    }
    public void askQuestion(boolean mc, String q, String a, String b, String c) {
        answers.clear();
        answers.add(a);
        answers.add(b);
        answers.add(c);
        question = newQuestion(mc, q, answers);
    }
    public void askQuestion(boolean mc, String q, String a, String b, String c, String d) {
        answers.clear();
        answers.add(a);
        answers.add(b);
        answers.add(c);
        answers.add(d);
        question = newQuestion(mc, q, answers);
    }
    public void askQuestion(boolean mc, String q, String a, String b, String c, String d, String e) {
        answers.clear();
        answers.add(a);
        answers.add(b);
        answers.add(c);
        answers.add(d);
        answers.add(e);
        question = newQuestion(mc, q, answers);
    }

    public Vector<String> getAnswers() {
        return question.getAnswers();
    }
}