package quiz_maker;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;


 class create_quiz {
	 private static ArrayList<Quiz> Quizzes=new ArrayList<>();
		static Quiz getQuiz(int index) {
			return Quizzes.get(index);
		}
		static void addQuiz(Quiz quiz) {
			Quizzes.add(quiz);
		}
		static int len() {
			return Quizzes.size();
		}
		
		
		
	static class Question{
		int qno;
		String ques;
		ArrayList<String> options;
		
		public Question(int qno,String ques,ArrayList<String> options) {
			this.qno=qno;
			this.ques=ques;
			this.options=new ArrayList<>(options);
			
		}
		
		
	}
	
	static class Quiz{
		int id;
		String title;
		ArrayList<Question> questions;
		protected Map<Question,Integer> solution;
		
		public Quiz(int id , String title) {
			this.id=id;
			this.title=title;
			questions=new ArrayList<>();
			solution= new HashMap<Question,Integer>();
		}
		
		
		int getSol(Question q) {
			return solution.get(q);
		}
	}
	
	static Quiz add_quiz(int id , String title) {
		Quiz q = new Quiz(id,title);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of quiz");
		int noOfQuestion=sc.nextInt();
		String tempQues="question";
		ArrayList<String> options = new ArrayList<String>();
		
		for(int i=0;i<noOfQuestion;i++) {
			sc.nextLine();
			System.out.println("Write the question.");
			tempQues=sc.nextLine();
			for(int j=0;j<4;j++) {
				System.out.print(j+1+". ");
				options.add(sc.nextLine());
			}
			
			q.questions.add(new Question(i+1,tempQues,options));
			System.out.println("Enter the correct option :");
			q.solution.put(q.questions.get(i), sc.nextInt());
			tempQues="";
			options.clear();
		}
		//1sc.close();
		return q;
	}
	
	
}
