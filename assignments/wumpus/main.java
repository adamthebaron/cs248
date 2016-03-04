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
		/* use arraylist to store room # for wumpus/spider/pit
		   to allow for unique random number generation
		   0. wumpus room
		   1. spider room 1
		   2. spider room 2
		   3. pit room 1
		   4. pit room 2 */
		ArrayList<Integer> wsp = new ArrayList<Integer>();
		for (int i = 0; i <= 4; i++)
			wsp.add(new Integer(i));
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Scanner scan = new Scanner(new FileReader("roomlayout.txt"));
        Room[] rooms = new Room[scan.nextInt()];
		while(true) {
			wumpus = rand.nextInt(rooms.length + 1);
			spiders[0] = rand.nextInt(rooms.length + 1);
			spiders[1] = rand.nextInt(rooms.length + 1);
			pits[0] = rand.nextInt(rooms.length + 1);
			pits[1] = rand.nextInt(rooms.length + 1);
			if(wumpus == spiders[0] || wumpus == spiders[1] || 

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(scan);
        }

        for (;;) {
            /* print current info */
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
                System.out.println("You attempt to shoot an arrow into the room.");

                if (player.shoot(player.currentRoom, wumpus, spiders, 
								 rooms[player.currentRoom - 1]) == 1) {
                    System.out.println("You are out of arrows!\nYou lose.");
                    break;
                }
                
                System.out.println("You shoot into room " + charput);
            }
            
            /* handle move option */
            else if (charput == 'M' || charput == 'm') {
                System.out.print("Which room?: ");
                intput  = scanner.nextInt();
                player.move(intput, rooms[player.currentRoom - 1]);
            }
            
            /* handle unknown charput */
            else
                System.out.println("Unknown option.");
        }

		System.out.println("You win!");
	}
}
