import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class VotingService {
    private Vector<Question> questions = new Vector<>();
    private Vector<Vector<String>> answersVec = new Vector<>();
    private Map<String, String> answersMap = new HashMap<String, String>();
    private Vector<String> IDs = new Vector<>();

    protected void newQuestion(String Q, Vector<String> As) {
		Question myQuestion = new Question();
		myQuestion.init(Q, As);
        questions.add(myQuestion);
	}

    public Question pickQuestionRan() { 
        int ranIndex = (int)(Math.random() * questions.size());
        Question Q = questions.get(ranIndex);
        answersVec.add(Q.getAnswers());
        return Q;
    }
    
    public void vote (String id, String answer) {
        if (!IDs.contains(id))
            IDs.add(id);
        answersMap.put(id, answer); // Link answer to student's ID
    }

    public void printResults() {
        // Loop through Questions
        for (int i = 0; i < questions.size(); i++) {
            // Print Question
            Question currentQ = questions.get(i);
            System.out.println("Question: " + currentQ.getQuestion());

            // Loop through Answers
            for (int k = 0; k < answersVec.get(i).size(); k++) {
                // Print current Answer
                String currentA = (answersVec.get(i)).get(k);
                System.out.println("Answer: " + currentA);

                // Tally amount of votes for current Answer
                int ansTally = 0;
                for (int j = 0; j < answersMap.size(); j++) {
                    if (answersMap.get(IDs.get(j)) == currentA) ansTally++;
                }
                // Print Tally
                System.out.println("Total: " + String.valueOf(ansTally));
            }
        }
    }
}