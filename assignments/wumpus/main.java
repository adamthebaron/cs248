/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class main {
	public static void main(String[] args) throws IOException {
        int totalRooms = 0;
		String line = null;
        String[] adjRooms = null;
        char charput;
        int intput;
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Scanner scan = new Scanner(new FileReader("roomlayout.txt"));
        Room[] rooms = new Room[scan.nextInt()];

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(scan);
        }

        for (;;) {
            System.out.println("You are in room " + player.currentRoom);
            System.out.println(rooms[player.currentRoom - 1].description);
            System.out.println("There are tunnels to rooms " + rooms[player.currentRoom - 1].adjroom1
                                + ", " + rooms[player.currentRoom - 1].adjroom2 + ", and " 
                                + rooms[player.currentRoom - 1].adjroom3 + ".");
            System.out.println("You have " + player.arrows + " arrows left.");
            System.out.print("What will you do? (S to Shoot, M to Move): ");
            charput = scanner.next().charAt(0);
            
            /* handle shoot option */
            if (charput == 'S' || charput == 's') {
                System.out.print("Which room?: ");
                charput = scanner.next().charAt(0);
                
                if (player.shoot() == 1) {
                    System.out.println("You are out of arrows!");
                    break;
                }
                
                System.out.println("You shoot into room " + charput);
            }
            
            /* handle move option */
            else if (charput == 'M' || charput == 'm') {
                System.out.print("Which room?: ");
                intput  = scanner.nextInt();
                player.move(intput, rooms[player.currentRoom]);
            }
            
            /* handle unknown charput */
            else
                System.out.println("Unknown option.");
        }
	}
}
