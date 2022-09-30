import java.util.Vector;

public final class Question {
   String question;
   private Vector<String> answers = new Vector<>();
   private boolean multipleChoice;

   private void setQuestion(String Q) {
      question = Q;
   }
   private void setAnswers(Vector<String> As) {
      answers = As;
   }
   
   public void init(boolean MC, String Q, Vector<String> As) {
      setQuestion(Q);
      setAnswers(As);
      multipleChoice = MC;
   }

   public String getQuestion() {
      return question;
   }
   public String getAnswer(int index) {
      return answers.get(index);
   }
   public Vector<String> getAnswers() {
      return answers;
   }
   public int getAnswerCount() {
      return answers.size();
   }
}