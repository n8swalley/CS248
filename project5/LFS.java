import java.io.*;
import java.util.*;

//**************************************************
// 
// Author: N8 Swalley
// Date: Tuesday, 29-January 2020
//
// 
//**************************************************

public class LFS 
{
   
    public int[] Tables = new int[3];
   
    public Queue WaitingList = new QueueLL(); // From 11 am class
   
    public Queue CheckIn = new QueueLL();

    public int CurrentCustomerTotal = 0;

    public int WaitTime = 0;
    
    public void start() throws IOException
    {
        int currentTime = 0; 
        int tableCount = 0; 
		
        System.out.println("***Welcome to the LaFood Restaurant Simulator***");
        
        readFile();
       
        while (currentTime <= 20)  // open until time 20
		{
            if (!WaitingList.isEmpty() && currentTime == ((Customer)WaitingList.getFront()).getArrivalTime())
			{
                System.out.println("Please wait at the bar,"); // as guests arrive, they are sent to wait at the bar
                System.out.println("Party "+((Customer)WaitingList.getFront()).toString()+".");
                CheckIn.enqueue(new Customer((Customer)WaitingList.getFront()));
                WaitingList.dequeue();
            }
            
            else if (currentTime == Tables[tableCount])
			{
                System.out.println("Table for "+(((Customer)CheckIn.getFront()).getName())+"!");      //calls for a table and takes them off Check In List
                
                AverageWait(((Customer)CheckIn.getFront()).groupNumber, ((Customer)CheckIn.getFront()).getArrivalTime(), currentTime);//Computes Average Wait Time
                CurrentCustomerTotal += ((Customer)CheckIn.getFront()).groupNumber; //Computes Total Number of Customers
                
                CheckIn.dequeue();
                tableCount++;
            }
            currentTime++;            
        }  
        
        System.out.println("**Simulation Terminated**");
        System.out.println();
        
        double average = ((double)WaitTime/(double)CurrentCustomerTotal); // computes average wait time 
        System.out.println("The average wait time was: "+average+ " minutes.");
        
        if(!CheckIn.isEmpty()) // checks for unseated guests
		{
            System.out.println("The following parties were not seated:");
            
            while(!CheckIn.isEmpty())
			{
                System.out.println(((Customer)CheckIn.getFront()).toString());
                CheckIn.dequeue();
            }
        }
		System.out.println(" ");
		System.out.println("Have a nice meal!");
    }

    public void AverageWait(int PartySize, int ArriveTime, int SeatTime)
	{
        WaitTime += PartySize*(SeatTime - ArriveTime);
    }	

    public void readFile() throws IOException
    {
        System.out.println("Please enter the name of the data file: "); // file reading stuff
        Scanner cin = new Scanner(System.in);
        String name;
        name = cin.next();
        
        Scanner file;
        file = new Scanner(
        new FileReader(name));
        
        int count = 0;
        boolean closedQueue = false; 
        String action;
       
        while (!closedQueue) //go until queue is closed
		{
            action = file.next();
            
            if (action.equals("A"))
			{
                WaitingList.enqueue(new Customer(file.nextInt(), file.nextInt(), file.nextLine()));
                
            }
            else if (action.equals("T"))
			{
                Tables[count] = file.nextInt();       
                count++;
            }
            else if (action.equals("Q")){
                closedQueue = true;
                return;
            }
            else
                System.out.println("Error! Unknown action: " +action); //error check
        }
    }
}
