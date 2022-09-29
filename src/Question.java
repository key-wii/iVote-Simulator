import java.util.Vector;

public final class Question {
   String question;
   private Vector<String> answers = new Vector<>();

   private void setQuestion(String Q) {
      question = Q;
   }
   private void setAnswers(Vector<String> As) {
      answers = As;
   }

   /*public void addAnswer(String A) {
      answers.add(A);
   }*/
   
   public void init(String Q, Vector<String> As) {
      setQuestion(Q);
      setAnswers(As);
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