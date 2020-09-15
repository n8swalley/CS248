import java.io.*;
import java.util.*;

//**************************************************
// 
// Author: N8 Swalley
// Date: Monday, 6-April 2020
//
// 
//**************************************************

public class Camp_Jobs
{

    public static void help() 
	{
		System.out.println("Command List:");
        System.out.println();
        System.out.println("H - Help: print a list of commands");
        System.out.println("E <name> <age> <sex> - Enroll a new camper");
        System.out.println("W <name> - Withdraw a camper");
        System.out.println("D <name> - Display the age and diet of a camper");
        System.out.println("A - Print the average age of the campers");
        System.out.println("L - List all campers names in alphabetical order");
        System.out.println("S - Print the number of vegan campers");
        System.out.println("P - List all campers names in preorder");
        System.out.println("Q - Quit");
        System.out.println();
    }

    public static void enroll(BST camp, Scanner file) 
	{
        camp.insert(new Camper(file));
        System.out.println("New camper added.");
    }
	
	  
    public static void withdraw(BST camp, Camper camper)
	{
        camp.delete(camper);
        System.out.println("Camper withdrawn.");
    }
	
	 public static void display(Camper camper)
	{
        System.out.println("Name: "+camper.name);
        System.out.println("Age: "+camper.age);
        System.out.println("Diet: "+camper.diet);
    }
    
    public static Camper camperSearch(BST camp, Scanner file)
	{
        String search = file.next();
        Camper camper = new Camper(0, 'A', search);
        
        Camper lookup = (Camper)
        camp.lookup(
		camper);
        
        if (lookup == null)
		{
			System.out.println(lookup+" is not here.");
            return null;
        }
        else
		{
            return lookup;
		} 
    }

    public static void average(BST camp) // calculates avg age of campers
	{
        camp.reset(BST.INORDER);
        
        double totalAge = 0;
        double count = 0;
        
        while(camp.hasNext())
		{
            totalAge += (double)getAge((Camper)camp.getNext());
            count++;
        }
        if(count > 0)
		{
            double average = (double)totalAge/count;
            System.out.println("The average age is "+average+" years old.");
        }
        else
		{
            System.out.println("There are no campers.");
		}
    }
    
    public static int getAge(Camper camper)
	{
        return camper.age;
    }
    
    public static void alphabetize(BST camp) 
	{
        camp.reset(BST.INORDER);
        
        ArrayList<String> alphalist = new ArrayList<String>(); // Using array list here becuase I think its better. (more dynamic, easy to compare/sort)
        while (camp.hasNext())
		{
            alphalist.add(((Camper)(camp.getNext())).name);
        }
        
        Collections.sort(alphalist); // I learned about ArrayLists in High School and fell in love w their functions
        
        System.out.println("Alphabetical List of Campers:");
        for(int i=0; i<alphalist.size(); i++)
		{
            System.out.println(alphalist.get(i));
		}
    }

    public static void veganCounts(BST camp) // vegan camper counter
	{
        int veganCount = 0;
        
        camp.reset(BST.INORDER);
        
        while(camp.hasNext())
		{
            if((((Camper)(camp.getNext())).diet)=='V' )
			{
                veganCount++;
            }
        }
        System.out.println("Vegan Camper count: "+veganCount);
    }

    public static void preorder(BST camp)
	{
        camp.reset(BST.PREORDER);
        
        System.out.println("Preorder Traversal: ");
        while (camp.hasNext())
		{
            System.out.println(((Camper)(camp.getNext())).name);
        }
            
    }
    
}