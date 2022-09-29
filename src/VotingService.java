import java.util.Vector;

public class VotingService {
    private Vector<Question> questionsVec = new Vector<>();
    private Vector<String> answersVec = new Vector<>();
    private Vector<String> IDs = new Vector<>();

    protected Question newQuestion(String Q, Vector<String> As) {
		Question myQuestion = new Question();
		myQuestion.init(Q, As);
        questionsVec.add(myQuestion);
        return myQuestion;
	}

    public Question pickQuestionRan() { 
        int ranIndex = (int)(Math.random() * questionsVec.size());
        return questionsVec.get(ranIndex);
    }
    
    public void vote (String id, String answer) {
        if (IDs.contains(id)) { //Already answered
            int idIndex = IDs.indexOf(id);
            answersVec.set(idIndex, answer); //Replace old answer
        } else { //Has not answered yet
            IDs.add(id);
            answersVec.add(answer); //Append new answer
        }
    }

    public void printResults() {
        for (int i = 0; i < questionsVec.size(); i++) {
            //Print Question
            Question currentQ = questionsVec.get(i);
            System.out.println("Question: " + currentQ.getQuestion());
            //System.out.println("\n");

            for (int k = 0; k < currentQ.getAnswerCount(); k++) {
                //Print Answer
                String currentA = currentQ.getAnswer(k);
                System.out.println("Answer: " + currentA);
                //System.out.println("\t\t\t");

                int ansTally = 0;
                for (int j = 0; j < answersVec.size(); j++) {
                    //Tally amount of votes for Answer
                    if (answersVec.get(j) == currentA) ansTally++;
                }
                //Print Tally
                System.out.println("Total: " + String.valueOf(ansTally));

                //System.out.println("\n");
            }
        }
    }
}