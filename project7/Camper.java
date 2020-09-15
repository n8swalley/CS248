import java.util.*;

//**************************************************
// 
// Author: N8 Swalley
// Date: Monday, 6-April 2020
//
// 
//**************************************************

public class Camper implements Comparable // sorta similar to Fish.java
{
    int age;
    char diet;
    String name;
    
    public Camper()
	{
        age = 0;
        diet = 'A';
        name = "";
    }
    
    public Camper(int Age, char Diet, String Name)
	{
        age = Age;
        diet = Diet;
        name = Name;
    }
    
    public Camper(Scanner file)
	{
        name = file.next();
        age = file.nextInt();
        diet = file.next().charAt(0);
    }
	@Override
    public int compareTo(Object camper)
	{
        if (camper instanceof Camper)
		{
            Camper camperCamper = (Camper)camper;
            return this.name.compareTo(camperCamper.name); // comparing campers by name
        }
        else
		{
            System.out.println("Error: Not a Camper.");
        }
        return 0;
    }
    
    public int getAge(){
        return age;
    }
    
    public char getDiet(){
        return diet;
    }
    
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return ("Name: "+name+" Age: "+age+" Diet: "+diet);
    }
}