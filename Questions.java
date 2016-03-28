import java.io.*;
import java.util.*;
import java.text.*;

	public class Questions
	{
		private int a, correct, tt = 0, tc = 0, g = 0, na; //total tried, total correct, guess, number answered
		private String [] ans;
		private String q, ca; //questions, correct answer
		private double percent;
		private Scanner input = new Scanner(System.in);
		private DecimalFormat p = new DecimalFormat("#.00");
		 
		public Questions(String ques, int numA, String [] answer, int numR, int total, int numC)
		{
			q = ques; //questions
			ans = new String [numA]; //answers
			na = numA; //number answered
			correct = numR; //number correct
			tt = total; //times tried
			tc = numC; //total correct
			ans = answer; //answer
		}
		
		public double percent()
		{
			percent = (float)tc/(float)tt; 
			percent = percent * 100;
			return percent;
		}
		//times tried
		public int total()
		{
			++tt;
			return tt;
		}
		
		public void correct()
		{
			if (g == correct)
			{
				++tc;
			}
		}
		//if the answer is correct
		public int isCorrect()
		{
			if (g == correct)
			{
				a = 1;
			} else {
				a = 0;
			}
			return a;
		}
		
		public int guess()
		{
			do {
			System.out.println("Your answer (enter a number): ");
			g = input.nextInt();
			} while (g<= 0 || g>na);
			return g;
		}
		
		public String display()
		{
			StringBuilder dis = new StringBuilder(" " + q);
			for (int i = 0; i < na; i++)
			{
				dis.append("\n" + (i+1) + ": " + ans[i]);
			}
			return dis.toString();
		}
		
		public String result(){
			StringBuilder ansInfo = new StringBuilder("Question: " + q + "\nAnswer Given: " + ans[g-1] + "\nCorrect Answer: " + ans[correct-1]); 
		 	if (g == correct)
		 	{
		 		ansInfo.append("\nResult: Correct");
		 	} else { ansInfo.append("\nResult: Wrong");
		 	
		 	}
		 	return ansInfo.toString();
		 }
		 
		 public String stats()
		 {
		 	StringBuilder statInfo = new StringBuilder("Question: " + q + "\nTimes Tried: " + tt + "\nTimes Correct: " + tc + "\nPercent Correct: " + p.format(percent) + "%");
		 	return statInfo.toString();
		 }
		 //questions
		 public String ques()
		 {
		 	return q;
		 }
		 //amount correct
		 public int corr ()
		 {
		 	return correct;
		 }
		 //total tried
		 public int tot ()
		 {
		 	return tt;
		 }
		 //number answered
		 public int number () 
		 {
		 	return na;
		 }
		 
		 public int totalCorrect ()
		 {
		 	return tc;
		 }

		 public String aw(int i){
		 	ca = ans[i];
		 	return ca;
		 }
	}
