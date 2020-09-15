import java.io.*;
import java.util.*;

class Fishmain2
{
	public static Comparable max(Comparable [] list)
	{
		Comparable maxsofar=list[0];
		for(int i=1; i<list.length; i++)
		{
			if(list[i].compareTo(maxsofar)>0)
			{ maxsofar=list[i]; }
		}
		return maxsofar;
	}
	
	public static final int FEEDINGFRENZYSIZE=13;
	static void feedingfrenzy(Fish [] Xavier)
	{
		for(int i=0; i<FEEDINGFRENZYSIZE; i++)
		{
			int target=(int)(Xavier.length*Math.random());
			Xavier[target].sharkAttack();
		}
	}
	public static void main(String [] args) throws IOException
	{
		Scanner fishreader=
		  new Scanner(new FileReader("fishfile.txt"));
		int fishcount=fishreader.nextInt();
		
		Fish [] school;
		school=new Fish[fishcount];
		
		for(int i=0; i<school.length; i++)
		{
			school[i]=new Fish(fishreader);
		}
		for(int i=0; i<school.length; i++)
		{
			school[i].print();
		}
		System.out.println("Oh no, sharks!");
		feedingfrenzy(school);
		for(int i=0; i<school.length; i++)
		{
			school[i].print();
		}
		
		Fish big;
		big=(Fish)max(school);
		big.print();
	}
}