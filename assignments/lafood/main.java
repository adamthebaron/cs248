/** @author Adam Kessler */

import java.io.*;
import java.util.*;

/*
 * All code is handled in main()
 * initialize program variables and
 * run loop to parse each line of input
 * until 'Q' sentinel or null is found
 */
class main {
  public static void main(String[] args) throws IOException {
    String file;
    Scanner scan = new Scanner(System.in);
    System.out.print("La Food restaurant simulator\nPlease enter datafile: ");
    file = scan.next();
    scan.close();
    scan = new Scanner(new FileReader(file));
    QueueLL queue = new QueueLL();
    String line;
    int curTime = 0;
    int totalTime = 0;
    int totalSeated = 0;
    
    while ((line = scan.nextLine()) != null) {
      /*
       * place current line in string array to
       * handle per element 
       */
      String[] curLine = line.split(" ");
      
      /* handle 'A' lines */
      if (line.charAt(0) == 'A') {
        Party party = new Party();
        party.time = Integer.parseInt(curLine[1]);
        party.people = Integer.parseInt(curLine[2]);
        
        for (int i = 3; i < curLine.length; i++) {
          if (party.name == null)
            party.name = curLine[i];
          else
            party.name += " " + curLine[i];
        }
        
        System.out.println("Adding party "
            + party.name
            + " at time "
            + Integer.toString(party.time)
            + " of size "
            + Integer.toString(party.people));
        queue.enqueue(party);
      }
      
      /* handle 'T' lines */
      else if (line.charAt(0) == 'T') {
        Party party = (Party)queue.dequeue();
        curTime = Integer.parseInt(curLine[1]);
        totalTime = totalTime + party.people * (curTime - party.time);
        totalSeated = totalSeated + (party.people);
        System.out.println("Time is " + curLine[1]);
        System.out.println("Seating " + party.name + ".");
      }
      
      /* handle 'Q' line and break */
      else if (line.charAt(0) == 'Q') {
        System.out.println("Simulation terminated.");
        System.out.println("Total waiting time was " + totalTime + " minutes.");
        System.out.println("Total seated was " + totalSeated + " people.");
        System.out.println("Average waiting time was " 
            + ((float)totalTime / (float)totalSeated)
            + " minutes.");
        System.out.println("The following parties were not seated: ");
        
        while(!queue.isEmpty()) {
          Party party = (Party)queue.dequeue();
          System.out.println(party.name);
        }
        
        break;
      }
    }
  }
}
