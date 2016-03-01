/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class main {
	public static void main(String[] args) throws IOException {
	    int totalRooms = 0;
		String line = null;
        String[] adjRooms = null;
        int i = 0;
        char input;
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
		BufferedReader read = new BufferedReader(new FileReader("roomlayout.txt"));
		totalRooms = Integer.parseInt(read.readLine());
		Room[] rooms = new Room[totalRooms - 1];
		/* start on line 2 */
        while ((line = read.readLine()) != null && i <= (totalRooms - 1)) {
			/* first line assigns adjacent rooms */
            adjRooms = line.split(" ");
            for (int j = 0; j < adjRooms.length; j++)
                    rooms[i].adjacentRooms[j] = Integer.parseInt(adjRooms[j]);
            /* second line assigns room description */
            line = read.readLine();
            rooms[i].description = line;
		}
        for (;;) {
            System.out.println("You are in room " + player.currentRoom);
            System.out.println(rooms[player.currentRoom - 1].description);
            System.out.println("You have " + player.arrows + " arrows left.");
            System.out.println("There are tunnels to rooms " + 
                                rooms[player.currentRoom].adjacentRooms.toString() + ".");
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
            if (input == 'M' || input == 'm') {
                System.out.print("Which room?: ");
                input = scanner.next().charAt(0);
                if(player.move(input) == 1)
                    break;
                else
                    player.move(input);
            }
            /* handle unknown input */
            else {
                System.out.println("Unknown option.");
                break;
            }
        }
	}
}
