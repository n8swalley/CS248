import java.util.*;
import java.io.*;


class ESP
{
	
	public static void main(String[] args) throws IOException 
	{

		System.out.println("***Welcome to the Exam Statistics Program!!***");
		Scanner cin = new Scanner(System.in); // Scanner for the user input
		System.out.print("Please enter the name of the file: ");
		String fileName = cin.nextLine();
		Scanner g = new Scanner(new FileReader(fileName));
		
		int [] scores = new int[g.nextInt()]; 
		int i = 0;

		while (g.hasNext())
		{
		  scores[i] = g.nextInt();
		  i++;
		}

		Arrays.sort(scores); // Simple way to sort the array in ascending order
		
		System.out.println(" "); // This adds a space to make it look pretty!
		System.out.println("Minimum score: " + scores[0]);
		System.out.println("Maximum score: " + scores[(scores.length - 1)]);


		
		double gradesTotal = 0;	//Calculates the mean
		
		for (i=0; i<scores.length; i++)
		{
			gradesTotal = gradesTotal + scores[i];
		}
		
		double mean = gradesTotal/scores.length;
		System.out.println("Average score: " + mean);

		double median; //Calculates the median
		if (scores.length % 2 == 0)
		{
			median = ((scores[(scores.length/2) - 1]) + scores[(scores.length/2)]) / 2;
		}
		else
		{	
			median = scores[(scores.length/2)];
		}
		System.out.println("Median score: " + median);
		
		ESP.grades(scores);
	}
	
	public static void grades(int scores[])
	{
		int i =0;
		int numScores = 0;
		int gradeA = 0; 
		int gradeB = 0;
		int gradeC = 0;
		int gradeD = 0;
		int gradeF = 0;
		
		for (i=0; i<scores.length; i++)
		{
			numScores++;
			
		  if (scores[i] >= 90)
		  {
			  gradeA++; 
		  }
		  else if (scores[i] <= 89 && scores[i] >=80)
		  {
			  gradeB++; 
		  }
		  else if (scores[i] <= 79 && scores[i] >=70)
		  {
			  gradeC++; 
		  }
		  else if (scores[i] <= 69 && scores[i] >=60)
		  {
			  gradeD++; 
		  }
		  else
		  {
			  gradeF++; 
		  } 
		}
		
	System.out.println(" "); // Prints a space cuz i want it to look pretty
	System.out.println("Number of scores by letter grade:");
	System.out.println("A: " +gradeA);
	System.out.println("B: " +gradeB);
	System.out.println("C: " +gradeC);
	System.out.println("D: " +gradeD);
	System.out.println("F: " +gradeF);
	System.out.println("There are " + numScores + " scores.");
	}

}