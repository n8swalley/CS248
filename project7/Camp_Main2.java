import java.io.*;
import java.util.*;

//**************************************************
// 
// Author: N8 Swalley
// Date: Monday, 6-April 2020
//
// 
//**************************************************

public class Camp_Main2
{
    public static void main (String [] args) throws FileNotFoundException
	{
		BST camp = new BST();  // Making the Binary Search Tree
        System.out.println("Welcome to Camp Posanivee!");
        readIn(camp);
        System.out.println(); // Marks end of program
        System.out.println("Command: Q");
        System.out.println("End of Program,");
		System.out.println("Bring plenty of calomine or you'll be itchy!");
	}
    
    public static void readIn(BST camp) throws FileNotFoundException
	{
		Scanner file = new Scanner(new FileReader("camp.txt"));
        char command;
        Camper camper = new Camper();
        
        command = file.next().charAt(0);
        while (command != 'Q')
		{
			System.out.println();
			if (command == 'H')
			{
				System.out.println("Command: H" + file.nextLine());
                Camp_Jobs.help();
				
			}
			else if (command == 'E')
			{
				System.out.println("Command: E");
				Camp_Jobs.enroll(camp, file);
			}
			else if (command == 'W')
			{
				System.out.println("Command: W");
                    camper = Camp_Jobs.camperSearch(camp, file);
                    Camp_Jobs.withdraw(camp, camper);
				
			}
			else if (command == 'D')
			{
				System.out.println("Command: D");
                    camper = Camp_Jobs.camperSearch(camp, file);
                    Camp_Jobs.display(camper);
			}
			else if (command == 'A')
			{
				System.out.println("Command: A");
                    Camp_Jobs.average(camp);
				
			}
			else if (command == 'L')
			{
				 System.out.println("Command: L");
                    Camp_Jobs.alphabetize(camp);
			}
			else if (command == 'V')
			{
				System.out.println("Command: V");
                    Camp_Jobs.veganCounts(camp);
			}
			else if (command == 'P')
			{
				 System.out.println("Command: P");
                    Camp_Jobs.preorder(camp);
			}
            switch (command) // This switch statment is a more efficient way of doing the commands.
			{
				case 'H':
					System.out.println("Command: H");
                    Camp_Jobs.help();
                    break;
                case 'E':
					System.out.println("Command: E");
					Camp_Jobs.enroll(camp, file);
					break;
                case 'W':
                    System.out.println("Command: W");
                    camper = Camp_Jobs.camperSearch(camp, file);
                    Camp_Jobs.withdraw(camp, camper);
                    break;
                case 'D':
                    System.out.println("Command: D");
                    camper = Camp_Jobs.camperSearch(camp, file);
                    Camp_Jobs.display(camper);
                    break;
                case 'A':
                    System.out.println("Command: A");
                    Camp_Jobs.average(camp);
                    break;
                case 'L':
                    System.out.println("Command: L");
                    Camp_Jobs.alphabetize(camp);
                    break;
                case 'V':
                    System.out.println("Command: V");
                    Camp_Jobs.veganCounts(camp);
                    break;
                case 'P':
                    System.out.println("Command: P");
                    Camp_Jobs.preorder(camp);
                    break;
                default:
                    break; // note that the 'Q' command is the default
            }
            
			command = file.next().charAt(0);
        }
    }
}