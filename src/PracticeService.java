import java.util.Vector;

public final class PracticeService extends VotingService {
    String question;
    Vector<String> answers = new Vector<>();

    public void init() {
        answers.add("ans A");
        answers.add("ans B");
        answers.add("ans C");
        answers.add("ans D");
        newQuestion("This is a question?", answers);
        answers.clear();
        
        answers.add("ans 1");
        answers.add("ans 2");
        answers.add("ans 3");
        answers.add("ans 4");
        newQuestion("This is a question!!", answers);
    }
}