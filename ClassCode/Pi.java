import java.io.*;
import java.util.*;

class Pi
{
	static int getlimit()
	{
		System.out.print("Please enter a limit: ");
		Scanner cin=new Scanner(System.in);	
		int limit=cin.nextInt();
		return limit;
	}
	public static void main(String [] args)
	{
		int limit;
		double sum = 0;
		limit=getlimit();
		
		if (limit <=0)
		{
			System.out.println("Enter in a positive limit you dingus");
			return; //exit the main function
		}
		System.out.println(limit);
		
		for(int i=1; i<=limit; i++)
		{
			sum=sum+1.0/(1.0*i*i);
		}
		
		System.out.println("Sum = "+sum);
		
		double pi;
		pi=Math.sqrt(6*sum);
		System.out.println("Pi = "+pi);
		
	}
	
}