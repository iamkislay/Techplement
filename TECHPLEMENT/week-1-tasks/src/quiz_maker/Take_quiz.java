package quiz_maker;

import java.util.ArrayList;
import java.util.Scanner;


import quiz_maker.create_quiz.Question;;

class Take_quiz { 
	static ArrayList<performance> performances = new ArrayList<>();
	static class performance{
		String quizTitle;
		int quizId;
		double score;
		double MaxScore;
		
		public performance(String quizTitle,int quizId,double score,double MaxScore) {
			this.quizTitle=quizTitle;
			this.quizId=quizId;
			this.score=score;
			this.MaxScore=MaxScore;
			
		}
	}
	
	
	static void giveQuiz(int index) {
	ArrayList<String> feedback= new ArrayList<>();
	double marks=0;
	double penalty=-0.25;
	 Scanner sc =  new Scanner(System.in);
	 ArrayList<Question>  ques= create_quiz.getQuiz(index).questions;
	 System.out.println(create_quiz.getQuiz(index).title);
	 for(Question q:ques) {
		 int choosen=6;
		 System.out.println("Q no."+q.qno+". "+q.ques);
		 int i=1;
		 for(String option:q.options) {
			 System.out.println(i+". "+option);
			 i++;
		 }
		 System.out.println("For evaluation ,choice must be between 1-4 . Enter other integers to skip the question.\nCorrect:+4\tIncorrect:-0.25\nInput: ");
		 choosen=sc.nextInt();
		 int curSol=create_quiz.getQuiz(index).getSol(q);
		 if(choosen==curSol) {
			 marks+=1;
			 feedback.add("Correct answer");
		 }
		 else if(choosen>4  || choosen<=0) {
			 
		 }
		 else {
			 marks+=penalty;
			 feedback.add("Wrong answer! Correct answer is option "+curSol+".");
		 }
	 }
	 for(int j=0;j<feedback.size();j++) {
		 System.out.println("Feedback: \nQ no."+j+1+". "+feedback.get(j));
	 }
		 
	 performances.add(new performance(create_quiz.getQuiz(index).title,create_quiz.getQuiz(index).id,marks,create_quiz.getQuiz(index).questions.size()));
	 System.out.println("Total marks obtained: "+marks+" out of "+create_quiz.getQuiz(index).questions.size()+"\n\n");
	 
	}
	
	static void showPerformance() {
		if(performances.size()==0) {
			System.out.println("Opps..No quizzes taken yet!\n\n");
			return;
		}
		System.out.println("Your Performace Report!\nQuizID"+"  "+"QuizTitle"+"  "+"ScoreObtained"+"  "+"MaxMarks");
		for(performance p:performances) {
			
			System.out.println(p.quizId+"\t  "+p.quizTitle+"\t   "+p.score+" \t    "+p.MaxScore+"\n\n");
		}
	}
	
	
}
