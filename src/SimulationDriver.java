import java.util.Vector;

public class SimulationDriver
{
	public static void main(String[] args)
	{
		// Set up
		PracticeService myPracticeService = new PracticeService();
		myPracticeService.init();
		Question Q = myPracticeService.pickQuestionRan();
		Vector<String> answers = Q.getAnswers();

		int min = 10;
		int max = 12;
		double ran = Math.random() * (max - min);
		// Automate student answers
		for (int i = 0; i < min + ran; i++) {
			Student myStudent = new Student();
			myStudent.init(String.valueOf(i));
			myPracticeService.vote(myStudent.getId(), myStudent.pickAnswerRan(answers));
		}

		myPracticeService.printResults();
	}
}