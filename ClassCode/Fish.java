import java.util.*;
/** @author Jon */
public class Fish implements Comparable
{
	// data members
	String name;
	String color;
	String species;
	int fins;
	
	static int count=0;
	
	// methods
	
	// constructor
	/** @param n The fish name
	    @param c The color of the fish
		@param s The species of the fish
		@param f The number of fins */
	public Fish(String n,String c,String s,int f)
	{
		name=n;
		color=c;
		species=s;
		fins=f;
		count++;
	}
	
	public Fish(Scanner anything)
	{
		name=anything.next();
		color=anything.next();
		species=anything.next();
		fins=anything.nextInt();
		count++;
	}
	
	// observers
	public void print()
	{
		System.out.println("Fish: "+name+" species="+species
		  +" color="+color+"  #fins="+fins);
	}
	
	/** @return the name of the fish */
	public String getName() { return name; }
	/** @return the species of the fish */
	public String getSpecies() { return species; }
	public String getColor() { return color; }
	public int getFins() { return fins; }
	
	public int compareTo(Object x)
	{
		// is it really a fish?
		if(x instanceof Fish)
		{
			Fish f=(Fish)x;
			// by name
			//return name.compareTo(f.getName());
			// by fins
			if(fins<f.getFins()) return -1;
			if(fins==f.getFins()) return 0;
			return 1;
		}
		else // panic
		{
			System.out.println("Error: you can only compare to Fish!");
			System.exit(1); // terminates the program
		}
		return 0; // to make the compiler happy
	}
	
	// mutator
	
	public void sharkAttack()
	{
		if(fins>0) fins--;
	}
	public void toxicWaste()
	{
		fins++;
	}
	
}
