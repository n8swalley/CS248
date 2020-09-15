//**************************************************
// 
// Author: N8 Swalley
// Date: 1/15/2020
//
// This program asks the user to guess a number and insults them when they're too high or low. 
//**************************************************
import java.io.*;
import java.util.*;

class guess
{
	public static void main(String [] args)
	{
		System.out.println("***WELCOME TO THE GUESSING GAME***");
		start();
	}
	static void start()
	{
		System.out.println("I have a number between 1 and 100. Can you guess it? \n");
		int randInt = (int)(1+100*Math.random()); // generates a random value from 1 to 100
		int numGuesses = 0;
		while (numGuesses >= 0)
		{			
			System.out.print("Enter your guess: ");
			int userGuess =getGuess();
			numGuesses++;
			if(userGuess > randInt)
			{
				System.out.println("Too high, " + getInsult() + "\n");
				
			}
			
			else if(userGuess < randInt)
			{
				System.out.println("Too low, "+ getInsult() + "\n");
			}
			
			else 
			{  
				System.out.println("Correct!");
				System.out.println("It only took you " + numGuesses + " guesses, "+ getInsult()+ "\n");
				numGuesses = -1;
			}
		}
		
		System.out.print("Would you like to play again? y/n: ");
		char userResponse = getUserResponse();
		System.out.println(" ");
		if (userResponse == 'y')
		{
			start();
		}
		else
		{
			System.out.println("Goodbye!");
		}
	}
	
	static int getGuess() // gets the users guess
	{
		Scanner cin=new Scanner(System.in);	
		int userGuess=cin.nextInt();
		return userGuess;
	}
	
	static char getUserResponse()
	{
		Scanner cin=new Scanner(System.in);	
		char userResponse=cin.next().charAt(0);
		return userResponse;
	}
	
	static String getInsult()
	{
		int randInt = (int)(1+5*Math.random()); // generates a random value from 1 to 5
		String insult = " ";
		if (randInt == 1)
		{
			insult = "you spoonface!";
			
		}
		else if (randInt == 2)
		{
			insult = "you womp rat!";
			
		}
		else if (randInt ==3)
		{
			insult = "you stinky fart!";
			
		}
		else if (randInt ==4)
		{
			insult = "you specklehead!";
			
		}
		else if (randInt ==5)
		{
			insult = "you no good, filthy rodent!";
			
		}
		return insult;
	}
	
}