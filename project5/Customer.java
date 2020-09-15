/**
 * Customer Object Class
 * @author Rachel Burke
 */
import java.util.*;

public class Customer {
    //Variable Definitions
    int arrivalTime = 0;
    int groupNumber = 0;
    String name = " ";

    /**
     * Define Customer Object
     * @param atime Arrival Time
     * @param gnum Group Number
     * @param n Name
     */
    public Customer(int atime, int gnum, String n){
        arrivalTime = atime;
        groupNumber = gnum;
        name = n;
    }

    /**
     * Enqueue Customers in Check-In Queue
     * @param c 
     */
    public Customer(Customer c){
        arrivalTime = c.arrivalTime;
        groupNumber = c.groupNumber;
        name = c.name;
    }

    /**
     * Returns Arrival Time
     * @return arrivalTime
     */
    public int getArrivalTime()
        { return arrivalTime; }

    /**
     * Returns Group Number
     * @return groupNumber
     */
    public int getGroupNumber()
        { return groupNumber; }

    /**
     * Returns Party Name
     * @return name
     */
    public String getName()
        { return name; }
    
    /**
     * Returns Name of Party and Group Number as a String
     * @return String
     */
    public String toString(){
        return (name + " of " + groupNumber + " people");
    }
}