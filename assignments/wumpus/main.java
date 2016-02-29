/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class main {
	public static int main(void) {
	    int totalRooms = 0;
		String line = null;
        String[] adjRooms = null;
        int i = 0;
        int currentRoom = 1;
        char input = null;
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
		BufferedReader read = new BufferedReader(new FileReader("roomlayout.txt"));
		totalrooms = read.readLine();
		Room[] rooms = new Room(totalrooms - 1);
		/* start on line 2 */
        while ((line = read.readLine()) != null && i <= (totalrooms - 1)) {
			/* first line assigns adjacent rooms */
            adjRooms = line.split(" ");
            for (int j = 0; j < adjRooms.length; j++)
                    rooms[i].adjacentRooms[j] = Integer.parseInt(adjRooms[j]);
            /* second line assigns room description */
            line = read.readLine();
            rooms[i].description = line;
		}
        for (;;) {
            System.out.println("You are in room " + currentRoom);
            System.out.println(room[currentRoom - 1].description);
            System.out.println("You have " + player.arrows + " arrows left.");
            System.out.println("There are tunnels to rooms " + rooms.adjacentRooms + ".");
            System.out.print("What will you do? (S to Shoot, M to Move): ");
            input = scanner.next().charAt(0);
            if (input.equals("S") || input.equals("s")) {
                System.out.println("Which room?: ");
                input = scanner.next().charAt(0);

            }
        }
	}
}
