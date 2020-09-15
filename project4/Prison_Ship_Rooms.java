import java.io.*;
import java.util.*;
//**************************************************
// 
// Author: N8 Swalley
// Date: Tuesday, 29-January 2020
//
// 
//**************************************************

public class Prison_Ship_Rooms 
{
    int room, adj1, adj2, adj3;
    String room_description;
    String hazard = "safe";

    public Prison_Ship_Rooms(int R1, int nxtR, int nxtR2, int nxtR3, String rd) {
      room=R1; adj1=nxtR; adj2=nxtR2; adj3=nxtR3; room_description=rd;
    }
    
    public Prison_Ship_Rooms(Scanner r) {
      room=r.nextInt();
    adj1=r.nextInt();
    adj2=r.nextInt();
    adj3=r.nextInt();
    room_description=r.next() + r.nextLine();
    }
    
    public String toString() 
    {
      return room+": adjacent rooms= "+adj1+" "+adj2+" "+adj3+" Description= "+room_description;
    }
    
    public String getAdjacent()
      {return adj1+", "+adj2+", and "+adj3+"."; }
  
    public String getDescription()
      {return room_description; } 
  
    public String getHazard() 
      {return hazard;}
  
      public void setHazard(String hazard) 
      {
          this.hazard = hazard;
      } 
  }