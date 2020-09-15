import java.io.*;
import java.util.*;
//**************************************************
// 
// Author: N8 Swalley
// Date: Tuesday, 29-January 2020
//
// 
//**************************************************

public class Mando_Main {
    public static void main(String[] args) throws IOException { 

        System.out.println("Welcome to Hunt the Wumpus -> Mandalorian Edition!"); 
        System.out.println("You're a Mandalorian. One of the strongest fighters in the galaxy!"); 
        System.out.println("Somehow, you've managed to get yourself stuck on a New Republic prison ship.");
        System.out.println("Your job is to search for the exit and save Baby Yoda, but watchout for the obstacles in your path!");
        System.out.println("There are mercenaries running lose in the prison."); //obstacle 1 = spiders
        System.out.println("There are sentry droids all over the ship that will relocate you."); // obstacle 2 = bats
        System.out.println("One of the rooms is a trash compactor");// obstacle 3 = pitfall
        System.out.println("Your blaster is not up to the times and can only withstand 3 shots before overheating."); // arrows = blaster shots
        System.out.println("To cooldown your blaster, find the security room."); // refill room = security room
        System.out.println("You can only move into rooms that are open");// explain why you can only go to three rooms
        System.out.println("Watch out for the evil Ice Age Baby. He's very hungry!"); //Ice Age Baby = wumpus
        System.out.println("Good Luck!");
        System.out.println("");

        //Creating the prison ship layout from Mandalorian S1E6
        Scanner file = new Scanner(new FileReader("MandoText.txt"));
        int rooms;
        rooms = file.nextInt();

        Prison_Ship_Rooms[] floor;
        floor= new Prison_Ship_Rooms[rooms];

        for (int i = 0; i < floor.length; i++) 
        {
            floor[i] = new Prison_Ship_Rooms(file);
        }
        //Placing Hazards in rooms
        int hazards_placed = 0;
        while (hazards_placed < 1)
        {
            int x = (int) (Math.random() * (rooms - 1) + 1);

            if (floor[x].getHazard().equals("safe")) {
                floor[x].setHazard("mercenaries");
                hazards_placed++;
            }
        }

        while (hazards_placed < 2 || hazards_placed < 3) 
        {
            int x = (int) (Math.random() * (rooms - 1) + 1);

            if (floor[x].getHazard().equals("safe")) {
                floor[x].setHazard("sentry droids");
                hazards_placed++;
            }
        }

        while (hazards_placed < 3) {
            int x = (int) (Math.random() * (rooms - 1) + 1);

            if (floor[x].getHazard().equals("safe")) 
            {
                floor[x].setHazard("baby");
                    hazards_placed++;
            }
        }
        while (hazards_placed < 4) {
            int x = (int) (Math.random() * (rooms - 1) + 1);

            if (floor[x].getHazard().equals("safe")) {
                floor[x].setHazard("shot refill");
                hazards_placed++;
            }
        }
        while (hazards_placed < 5) {
            int x = (int) (Math.random() * (rooms - 1) + 1);

            if (floor[x].getHazard().equals("safe")) {
                floor[x].setHazard("pit");
                hazards_placed++;
            }
        }

        int player = 1; //1 -> alive, 0 -> dead
        Scanner playerMove = new Scanner(System.in); //Scanner for player moves
        String action;
        int room;
        int blaster_shots = 3;
        int current_room = 0;

        //Continues game while player is alive
        while (player == 1) 
        {
            System.out.println();
            System.out.println("You are in room " + getCurrent(current_room) + ".");
            System.out.println("You have " + blaster_shots + " shots left.");
            System.out.println(floor[current_room].getDescription());
            System.out.println("You can move to rooms " + floor[current_room].getAdjacent());
            getHints(floor, current_room);
            action = nextAction(playerMove);
            room = getRoom(floor, playerMove, current_room);

            if (action.equals("M") || action.equals("m")) 
            {
                current_room = (room - 1);
                
                if (floor[current_room].getHazard().equals("pit"))
                {
                    System.out.println("Oh no! You fell into the trash compactor and died!");
                    player--;
                }
                if (floor[current_room].getHazard().equals("mercenaries")) 
                {
                    System.out.println("The mercenaries killed you!");
                    player--;
                }
                if (floor[current_room].getHazard().equals("droids")) 
                {
                    System.out.println("Sentry droids arrested you!");
                    current_room = (int)(Math.random() * (rooms - 1)+1);
                    System.out.println("You are now moving to "+(current_room + 1)+".");
                }
                if (floor[current_room].getHazard().equals("baby"))
                {
                    System.out.println("Oh no! You walked right into Ice Age Baby and he ate you for dinner.");
                    player--;
                }
                if (floor[current_room].getHazard().equals("shot refill"))
                {
                    blaster_shots = 3;
                    System.out.println("You went to the security room to cool down your blaster. You now have " + blaster_shots + " shots.");
                }
            } 
            else if (action.equals("S") || action.equals("s")) 
            {
                if (blaster_shots != 0) {
                    blaster_shots--;

                    if (floor[room - 1].getHazard().equals("baby")) 
                    {
                        System.out.println("You killed Ice Age Baby! You escaped the prison and saved Baby Yoda, hip hip hooray!");
                        player--;
                    } 
                    else
                    {
                        System.out.println("Your shot missed.");
                    }
                }
            }
        }
    }

    public static int getCurrent(int room) 
    {
        return room + 1;
    }

    private static int getRoom(Prison_Ship_Rooms[] floor, Scanner playerMove, int current_room) 
    {
        System.out.println("Which room?");
        int room = playerMove.nextInt();

        while (room != floor[current_room].adj1 && room != floor[current_room].adj2 && room != floor[current_room].adj3) 
        {
            System.out.println("Too far away! Choose again");
            room = playerMove.nextInt();
        }
        
        return room;
    }
   
    private static String nextAction(Scanner playerMove)
    {
        System.out.println("(M)ove or (S)hoot?");
        String action = playerMove.next();

        while (!(action.equals("M") || action.equals("m") || action.equals("S") || action.equals("s"))) 
        {
            System.out.println("That is not an option. (M)ove or (S)hoot?");
            action = playerMove.next();
        }
        return action;
    }

    private static void getHints(Prison_Ship_Rooms[] floor, int current_room) {
        if (floor[floor[current_room].adj1 - 1].getHazard().equals("mercenaries")
                || floor[floor[current_room].adj2 - 1].getHazard().equals("mercenaries")
                || floor[floor[current_room].adj3 - 1].getHazard().equals("mercenaries")) {
            System.out.println("You hear footsteps nearby.");
        }
        if (floor[floor[current_room].adj1 - 1].getHazard().equals("droids")
                || floor[floor[current_room].adj2 - 1].getHazard().equals("droids")
                || floor[floor[current_room].adj3 - 1].getHazard().equals("droids")) {
            System.out.println("You can sense droids nearby.");
        }
        if (floor[floor[current_room].adj1 - 1].getHazard().equals("baby")
                || floor[floor[current_room].adj2 - 1].getHazard().equals("baby")
                || floor[floor[current_room].adj3 - 1].getHazard().equals("baby")) {
            System.out.println("You hear screaming down the hall. Ice Age Baby is nearby! ");
        }
    }
}