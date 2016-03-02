/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class main {
	public static void main(String[] args) throws IOException {
        int totalRooms = 0;
		String line = null;
        String[] adjRooms = null;
        char input;
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
            System.out.println("There are tunnels to rooms " + rooms[player.currentRoom].adjroom1
                                + ", " + rooms[player.currentRoom].adjroom2 + ", and " 
                                + rooms[player.currentRoom].adjroom3 + ".");
            System.out.println("You have " + player.arrows + " arrows left.");
            System.out.print("What will you do? (S to Shoot, M to Move): ");
            input = scanner.next().charAt(0);
            
            /* handle shoot option */
            if (input == 'S' || input == 's') {
                System.out.print("Which room?: ");
                input = scanner.next().charAt(0);
                
                if (player.shoot() == 1) {
                    System.out.println("You are out of arrows!");
                    break;
                }
                
                System.out.println("You shoot into room " + input);
            }
            
            /* handle move option */
            else if (input == 'M' || input == 'm') {
                System.out.print("Which room?: ");
                input = scanner.next().charAt(0);
                
                if(player.move(input) == 1)
                    System.out.println("You are already in this room");
                
            }
            
            /* handle unknown input */
            else
                System.out.println("Unknown option.");
        }
	}
}
