import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class VotingService {
    protected Question question;
    private Vector<String> IDs = new Vector<>();
    private Vector<String> answersVec = new Vector<>();
    private Map<String, String> answersMap = new HashMap<String, String>();
    private Vector<Vector<String>> answersVecMC = new Vector<>();
    private Map<String, String> answersMapMC = new HashMap<String, String>();

    public Question newQuestion(boolean MC, String Qstr, Vector<String> As) {
		Question myQuestion = new Question();
		myQuestion.init(MC, Qstr, As);
        question = myQuestion;
        answersVec = myQuestion.getAnswers();
        return myQuestion;
	}

    // Single-choice
    public Vector<String> getAnswers() {
        return question.getAnswers();
    }
    // Multiple-choice
    public Vector<Vector<String>> getAnswers(Vector<String> answer) {
        Vector<Vector<String>> As = new Vector<>();;
        for (int i = 0 ; i < answer.size(); i++) {
            As.add(question.getAnswers());
        }
        return As;
    }
    
    public void vote(String id, String answer) {
        if (!IDs.contains(id))
            IDs.add(id);
        answersMap.put(id, answer); // Link answer to student's ID
    }
    public void voteMC(String id, String answer) {
        if (!IDs.contains(id))
            IDs.add(id);
        answersMapMC.put(id + answer, answer); // Link answer to student's ID
    }

    public void printResult() {
        // Print Question
        System.out.println("Question: " + question.getQuestion());

        // Loop through Answers
        for (int k = 0; k < answersVec.size(); k++) {
            String currentA = answersVec.get(k);

            // Tally amount of votes for current Answer
            int ansTally = 0;
            for (int j = 0; j < answersMap.size(); j++) {
                if (answersMap.get(IDs.get(j)) == currentA) ansTally++;
            }
            // Print Answer & Tally
            System.out.println("Answer: " + currentA + "\t~\t" + String.valueOf(ansTally) + " answers");
        }
    }
    public void printResultMC() {
        // Print Question
        System.out.println("Question: " + question.getQuestion());

        // Loop through Answers
        for (int k = 0; k < answersVec.size(); k++) {
            String currentA = answersVec.get(k);

            // Tally amount of votes for current Answer
            int ansTally = 0;
            for (int j = 0; j < answersMapMC.size(); j++) {
                int jj = j;
                while (jj >= answersVec.size()) jj -= answersVec.size();
                if (answersMapMC.get(IDs.get(jj) + currentA) == currentA) ansTally++;
            }
            // Print Answer & Tally
            System.out.println("Answer: " + currentA + "\t~\t" + String.valueOf(ansTally) + " answers");
        }
    }
}