package quiz_maker;


import java.util.Scanner;






public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean exit=true;
		int choice;
		while(exit) {
		System.out.println("Here we go! Start by choosing one option.");
		System.out.println("1. Create a Quiz");
		System.out.println("2. Take a Quiz");
		System.out.println("3. Show my performance");
		System.out.println("4. Quit\n\nInput: ");
		
		choice=s.nextInt();
		
		switch(choice) {
			case 1: System.out.println("Enter the id and title of the quiz");
					
					int id=s.nextInt();
					String title=s.nextLine();
					create_quiz.addQuiz(create_quiz.add_quiz(id,title));
					break;
			case 2: if(create_quiz.len()==0) {
						System.out.println("No quizzes available at the moment.Start by creating quizzes first.\n\n");
						continue;
					}
					System.out.println("Choose from the quizzes:");
					int i=-1;
					while(++i<create_quiz.len()) {
						System.out.println(i+1+"  "+create_quiz.getQuiz(i).title);
					}
					System.out.println("Choose:");
					Take_quiz.giveQuiz(s.nextInt()-1);
					break;
			case 3:	Take_quiz.showPerformance();
					break;
			case 4: exit=false;
					break;
			default : System.out.println("Choose correct option");
		}
	}
	}
}

