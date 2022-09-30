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

		myPracticeService.askQuestion(false, "q", "A", "B");
		Vector<String> answers = myPracticeService.getAnswers();
		// Automate student answers
		for (int i = 0; i < students; i++) {
			Student currentStudent = new Student();
			currentStudent.init(String.valueOf(i));
			myPracticeService.vote(currentStudent.getId(), currentStudent.pickAnswerRan(answers));
		}
		myPracticeService.printResult();

		myPracticeService.askQuestion(false, "q2", "1", "2", "3");
		answers = myPracticeService.getAnswers();
		// Automate student answers
		for (int i = 0; i < students; i++) {
			Student currentStudent = new Student();
			currentStudent.init(String.valueOf(i));
			myPracticeService.vote(currentStudent.getId(), currentStudent.pickAnswerRan(answers));
		}
		myPracticeService.printResult();

		System.out.println("Students: " +  students);
	}
}