/** @author Adam Kessler */

import java.io.*;
import java.util.*;

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
			//line = scan.nextLine();
            String[] curLine = line.split(" ");
            if (line.charAt(0) == 'A') {
                Party party = new Party();
                party.time = Integer.parseInt(curLine[1]);
                party.people = Integer.parseInt(curLine[2]);
                party.name = Arrays.toString(Arrays.copyOfRange(curLine, 3, curLine.length));
                System.out.println("Adding party "
                                    + party.name
                                    + " at time "
                                    + Integer.toString(party.time)
                                    + " of size "
                                    + Integer.toString(party.people));
                queue.enqueue(party);
			}
			else if (line.charAt(0) == 'T') {
				Party party = (Party)queue.dequeue();
				curTime = Integer.parseInt(curLine[1]);
				totalTime = totalTime + party.people * (curTime - party.time);
				totalSeated = totalSeated + (party.people);
				System.out.println("Time is " + curLine[1]);
				System.out.println("Seating " + party.name + ".");
			}
			else if (line.charAt(0) == 'Q') {
				System.out.println("Simulation terminated.");
				System.out.println("Total waiting time was " + totalTime + " minutes.");
				System.out.println("Total seated was " + totalSeated + " people.");
				System.out.println("Average waiting time was " 
									+ ((float)totalTime / (float)totalSeated)
									+ " minutes.");
				break;
			}
        }
    }
}
