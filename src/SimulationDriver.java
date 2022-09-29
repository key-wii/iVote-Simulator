import java.util.Vector;

public class SimulationDriver
{
	public static void main(String[] args)
	{
		PracticeService myPracticeService = new PracticeService();
		myPracticeService.init();
		Question Q = myPracticeService.pickQuestionRan();
		Vector<String> answers = Q.getAnswers();

		for (int i = 0; i < 10; i++) {
			Student myStudent = new Student();
			myStudent.init(String.valueOf(i));
			myPracticeService.vote(myStudent.getId(), myStudent.pickAnswerRan(answers));
		}

		myPracticeService.printResults();
	}
}