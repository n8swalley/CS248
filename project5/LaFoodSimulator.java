import java.io.*;
import java.util.*;

public class LaFoodSimulator {
    //Queue for Waiting List Customers
    public Queue WaitingList = new QueueLL();
    //Queue for Checked-in Customers
    public Queue CheckIn = new QueueLL();
    //Array of Tables
    public int[] Tables = new int[3];
    
    //Customer Count
    public int CurrentCustomerTotal = 0;
    //Wait Time Count
    public int WaitTime = 0;
    
    /**
     * Simulator Program
     * @throws IOException 
     */
    public void start()
        throws IOException
    {
        //Opening
        System.out.println("***Welcome to the LaFood Restaurant Simulator***");
        
        //Reading File
        readFile();
        
        //Current Time and Table Count
        int cTime = 0;
        int tcount = 0;
        
        //Restaraunt is open until time 20
        //People are sent to the bar to wait to be seated
        //When a table opens people are seated
        while (cTime <= 20)  {
            
            //Sends people to the bar when they arrive 
            if (!WaitingList.isEmpty() && cTime == ((Customer)WaitingList.getFront()).getArrivalTime()){
                System.out.println("Please wait at the bar,");
                System.out.println("Party "+((Customer)WaitingList.getFront()).toString()+".");
                
                CheckIn.enqueue(new Customer((Customer)WaitingList.getFront()));
                WaitingList.dequeue();
            }
            
            //Prints out table call and takes them off Check In List
            //Computes current Average Wait Time Sum
            //Computes Total Number of Customers
            else if (cTime == Tables[tcount]){
                System.out.println("Table for "+(((Customer)CheckIn.getFront()).getName())+"!");
                
                AverageWait(((Customer)CheckIn.getFront()).groupNumber, ((Customer)CheckIn.getFront()).getArrivalTime(), cTime);
                CurrentCustomerTotal += ((Customer)CheckIn.getFront()).groupNumber;
                
                CheckIn.dequeue();
                tcount++;
            }
            //Uncomment for debugging
            //else
                //System.out.println("Time: "+CurrentTime);
            
            cTime++;            
        }  
        
        //Simulation finishes running
        System.out.println("**Simulation Terminated**");
        System.out.println();
        
        //Uncomment for debugging
        //System.out.println("Time Waited: " +TimeWaited+ " Customers Seated: "+CheckIn);
        
        //Computing average wait time
        double average = ((double)WaitTime/(double)CurrentCustomerTotal);
        System.out.println("The average wait time was: "+average+ " minutes.");
        
        //Finds unseated parties
        if(!CheckIn.isEmpty()){
            System.out.println("The following parties were not seated: ");
            
            while(!CheckIn.isEmpty()){
                System.out.println(((Customer)CheckIn.getFront()).toString());
                CheckIn.dequeue();
            }
        }
    } 

    //File Reader
    // Sets actions for A, T, and Q prompts
    public void readFile()
        throws IOException
    {   //Get File Name
        System.out.println("Please enter the name of the data file: ");
        Scanner cin = new Scanner(System.in);
        String name;
        name = cin.next();
        
        //File Scanner
        Scanner file;
            file = new Scanner(
                new FileReader(name));
        
        int count = 0;
        boolean closed = false;
        String action;
        
        //Goes until Closing Queue
        while (!closed){
            action = file.next();
            
            if (action.equals("A")){
                WaitingList.enqueue(new Customer(file.nextInt(), file.nextInt(), file.nextLine()));
                
                //Uncomment for debuggging
                //System.out.println("Enqueued: " +(((Customer)WaitList.getBack()).toString()));
            }
            else if (action.equals("T")){
                Tables[count] = file.nextInt();
                
                //Uncomment for debugging
                //System.out.println("Table: " +(count + 1)+ "Time: " +Tables[count]);
                
                count++;
            }
            else if (action.equals("Q")){
                closed = true;
                return;
            }
            else
                System.out.println("Error! Unknown action: " +action);
        }
    }
    
    //Sum of Wait Times
    public void AverageWait(int PartySize, int ArriveTime, int SeatTime){
        WaitTime += PartySize*(SeatTime - ArriveTime);
    }
}
