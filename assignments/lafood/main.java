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
        QueueArray queue = new QueueArray(100);
        String line;
        while ((line = scan.nextLine()) != null) {
            String[] curLine = line.split(" ");
            switch (line.charAt(0)) {
                case 'A':
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
                case 'T':
                    System.out.println("Time is " +  
                case 'Q':
                    break;
            }
        }
    }
}
