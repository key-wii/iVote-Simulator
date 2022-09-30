import java.util.Vector;

public final class PracticeService extends VotingService {
    private Vector<String> answers = new Vector<>();

    public void askQuestion(boolean MC, String Q, String A, String B) {
        answers.clear();
        answers.add(A);
        answers.add(B);
        question = newQuestion(MC, Q, answers);
    }
    public void askQuestion(boolean MC, String Q, String A, String B, String C) {
        answers.clear();
        answers.add(A);
        answers.add(B);
        answers.add(C);
        question = newQuestion(MC, Q, answers);
    }
    public void askQuestion(boolean MC, String Q, String A, String B, String C, String D) {
        answers.clear();
        answers.add(A);
        answers.add(B);
        answers.add(C);
        answers.add(D);
        question = newQuestion(MC, Q, answers);
    }
}