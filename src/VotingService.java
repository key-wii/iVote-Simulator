import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class VotingService {
    private Vector<Question> questions = new Vector<>();
    Map<String, String> answers = new HashMap<String, String>();
    Map<Vector<Question>, Map<String, String>> QnA = new HashMap<Vector<Question>, Map<String, String>>();
    private Vector<String> IDs = new Vector<>();

    protected void newQuestion(String Q, Vector<String> As) {
		Question myQuestion = new Question();
		myQuestion.init(Q, As);
        questions.add(myQuestion);
	}

    public Question pickQuestionRan() { 
        int ranIndex = (int)(Math.random() * questions.size());
        return questions.get(ranIndex);
    }
    
    public void vote (String id, String answer) {
        if (!IDs.contains(id))
            IDs.add(id);
        answers.put(id, answer); // Link answer to student's ID
        QnA.put(questions, answers);
    }

    public void printResults() {
        // Loop through Questions
        for (int i = 0; i < questions.size(); i++) {
            // Print Question
            Question currentQ = questions.get(i);
            System.out.println("Question: " + currentQ.getQuestion());

            // Loop through Answers
            for (int k = 0; k < currentQ.getAnswerCount(); k++) {
                // Print current Answer
                String currentA = currentQ.getAnswer(k);
                System.out.println("Answer: " + currentA);

                // Tally amount of votes for current Answer
                int ansTally = 0;
                for (int j = 0; j < answers.size(); j++) {
                    if (answers.get(IDs.get(j)) == currentA) ansTally++;
                }
                // Print Tally
                System.out.println("Total: " + String.valueOf(ansTally));
            }
        }
    }
}