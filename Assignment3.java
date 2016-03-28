import java.io.*;
import java.util.*;
import java.text.*;

public class Assignment3
{

	public static void main(String [] args) throws IOException
	{
		Scanner nScan = new Scanner(System.in);
		String fileName = args[0];
		File nFile = new File(fileName);
		boolean fileExist = nFile.exists();
		DecimalFormat p = new DecimalFormat("#.00");
		// if the file doesnt exist		 
		while (fileExist == false)
		{
			System.out.println("This file does not exist, please type in a new file name");
			fileName = nScan.nextLine();
			nFile = new File(fileName);
			fileExist = nFile.exists();
		}
		
		System.out.println("Welcome to the Quiz program! May the odds be ever in your favor!");
		
		int counter = 0, a, b, c, d; //keeps track of the quiz questions
		String ques;
		String [] ans;
		Scanner fileIn = new Scanner(nFile);
		ArrayList <Questions> quests = new ArrayList <Questions> ();
		//array for questions
		while (fileIn.hasNextLine()) 
		{
			ques = fileIn.nextLine();
			a = Integer.parseInt(fileIn.nextLine());
			ans = new String[a];
			for (int i = 0; i < a; i++)
			{
				ans[i] = fileIn.nextLine();
			}
			
			b = Integer.parseInt(fileIn.nextLine());
			c = Integer.parseInt(fileIn.nextLine());
			d = Integer.parseInt(fileIn.nextLine());
			
			quests.add(new Questions(ques, a, ans, b, c, d));
			counter++;
		}

		fileIn.close();
		//files now closed
		int correct = 0, incorrect = 0;
		double percent;
		
		for (int i = 0; i < counter ; i++) 
		{
			System.out.println(quests.get(i).display());
			quests.get(i).guess();
			quests.get(i).correct();
			quests.get(i).total();	
		}
	
		System.out.println("\nHere are your results:");
		
		for(int i = 0; i<counter; i++)
		{
			System.out.println(quests.get(i).result());
			System.out.println("\n");
			quests.get(i).percent();
			if(quests.get(i).isCorrect() == 1)
			{
				correct++;
			} else {
				incorrect++;
			}
		}


		System.out.println("This is how you did:");
		percent = (float)correct/(float)counter;
		percent = percent*100;
		System.out.println("\nCorrect: " + correct + " Incorrect: " + incorrect + " Percent: " + p.format(percent) + "%\n\n");

		//gets percentages for the questions
		double max = -1000000, min = 10000000;
		int max1 = 0, min1 = 0;
		for (int i = 0; i < counter; i++) 
		{
			System.out.println(quests.get(i).stats());
			if (quests.get(i).percent() < min)
			{
				min = quests.get(i).percent();
				min1 = i;
			}	
			if (quests.get(i).percent() > max)
			{
				max = quests.get(i).percent();
				max1 = 1;
			}

		}

		System.out.println("\nEasiest Question: ");
		System.out.println(quests.get(max1).stats());
		System.out.println("\nHardest Question: ");
		System.out.println(quests.get(min1).stats());
		//closes file
		PrintWriter fileOut = new PrintWriter(fileName);
		for (int i = 0; i < counter ; i++) 
		{
			fileOut.println(quests.get(i).ques());
			fileOut.println(quests.get(i).number());
			for (int j =0; j < quests.get(i).number() ; j++) 
			{
				fileOut.println(quests.get(i).aw(j));

			}
		fileOut.println(quests.get(i).corr());
		fileOut.println(quests.get(i).tot());
		fileOut.println(quests.get(i).totalCorrect());
		}

		fileOut.close();
		
	}//End Main
	
}//End Class
	
	
	

