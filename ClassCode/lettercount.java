import java.io.*;
import java.util.*;

class lettercount
{
	static int Ecount(String x)
	{
		int count=0;
		for(int i=0; i<x.length(); i++)
		{
			char here;
			here=x.charAt(i);
			if(here=='e' || here=='E') count++;
		}
			return count;		
	}
	
	static int [] Allcount(String x)
	{
		int [] count = new int[26];
		for(int i=0; i<x.length(); i++)
		{
			char here;
			here=x.charAt(i);
			if(here>= 'a' && here<='z')
				count[here-'a']++;
			if(here>= 'A' && here<='Z')
				count[here-'A']++;
		}
		
		return count; 
	}
	
	public static void main(String [] args)
	{
		String line;
		Scanner cin=new Scanner(System.in);
		System.out.println("Enter your message: ");
		line=cin.nextLine();
		System.out.println("The number of E's is " + Ecount(line));
		int [] count =Allcount(line);
		for(int i =0; i <26; i++)
		{
			System.out.println((char)('A'+i)+" : "+count[i]);
		}
	}
}