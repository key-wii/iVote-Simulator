import java.util.Vector;

public class SimulationDriver
{
	public static void main(String[] args)
	{
		// Set up
		PracticeService myPracticeService = new PracticeService();
		int min = 10;
		int max = 15;
		int students = (int)Math.floor(Math.random() * (max - min + 1) + min); // + 1 is to make up for floor function
		int firstId = (int)Math.floor(Math.random() * (9000 - students) + 1000); // keep IDs between 1000 - 9999
		boolean multipleChoice;
		Vector<String> answers;

		myPracticeService.askQuestion(false, "Vote for President (1 choice)", "Mike", "John");
		answers = myPracticeService.getAnswers();
		// Automate student answers
		for (int i = 0; i < students; i++) {
			Student currentStudent = new Student();
			currentStudent.init(String.valueOf(i + firstId)); // set ID to i + firstId
			myPracticeService.vote(currentStudent.getId(), currentStudent.pickAnswerRan(answers));
		}
		myPracticeService.printResult();

		myPracticeService.askQuestion(true, "Vote for Board Member (multiple choice(s))", "Sally", "Larry", "Bob");
		answers = myPracticeService.getAnswers();
		// Automate student answers
		for (int i = 0; i < students; i++) {
			Student currentStudent = new Student();
			currentStudent.init(String.valueOf(i + firstId)); // set ID to i + firstId
			int answerCount = (int)Math.floor(Math.random() * 4 + 1);
			for (int k = 0; k < answerCount; k++) 
				myPracticeService.voteMC(currentStudent.getId(), currentStudent.pickAnswerRan(answers));
		}
		myPracticeService.printResultMC();

		System.out.println("Students: " +  students);
	}
}