/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class main {
    /* 
     * Initialize variables to hold game data,
     * read from input file,
     * run infinite loop to handle user input,
     * and finally exit upon a win or loss
     */
    public static void main(String[] args) throws IOException {
        int totalRooms = 0;
        String line = null;
        String[] adjRooms = null;
        char charput;
        int intput;
        int i;
        int wumpus;
        int[] spiders = new int[2];
        int[] pits = new int[2];
        /* use arraylist to generate room # for wumpus/spider/pit
           to allow for unique random number generation */
        ArrayList<Integer> wsp = new ArrayList<Integer>();

        for (i = 2; i <= 10; i++) {
            wsp.add(new Integer(i));
        }

        Collections.shuffle(wsp);
        wumpus = wsp.get(0);
        spiders[0] = wsp.get(1);
        spiders[1] = wsp.get(2);
        pits[0] = wsp.get(3);
        pits[1] = wsp.get(4);
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Scanner scan = new Scanner(new FileReader("roomlayout.txt"));
        Room[] rooms = new Room[scan.nextInt()];

        for (i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(scan);
        }
        System.out.println(wumpus + " " + Arrays.toString(spiders) + " " + Arrays.toString(pits));
        for (;;) {
            /* print current info */
            System.out.println("You are in room " + player.currentRoom);
            System.out.println(rooms[player.currentRoom - 1].description);
            System.out.println("There are tunnels to rooms " + rooms[player.currentRoom - 1].adjroom1
                    + ", " + rooms[player.currentRoom - 1].adjroom2 + ", and " 
                    + rooms[player.currentRoom - 1].adjroom3 + ".");
            System.out.println("You have " + player.arrows + " arrows left.");

            if (player.singleCheck(wumpus, rooms[player.currentRoom - 1]))
                System.out.println("You smell a wumpus nearby.");

            if (player.multiCheck(spiders, rooms[player.currentRoom - 1]))
                System.out.println("You hear a spider nearby.");

            if (player.multiCheck(pits, rooms[player.currentRoom - 1]))
                System.out.println("You hear a rock fall into a pit nearby");

            System.out.print("What will you do? (S to Shoot, M to Move): ");
            charput = scanner.next().charAt(0);

            /* handle shoot option */
            if (charput == 'S' || charput == 's') {
                System.out.print("Which room?: ");
                intput = scanner.nextInt();
                System.out.println("You attempt to shoot an arrow into the room.");

                if (!player.shoot(intput, wumpus, rooms[player.currentRoom - 1])) {
                    System.out.println("You don't hit anything and lose an arrow.");
                    if (player.arrows == 0) {
                        System.out.println("You are out of arrows!");
                        break;
                    }
                }

                else {
                    System.out.println("You hit the wumpus, you win!");
                    System.exit(0);
                }
            }

            /* handle move option */
            else if (charput == 'M' || charput == 'm') {
                System.out.print("Which room?: ");
                intput = scanner.nextInt();

                if (player.move(intput, wumpus, spiders, pits, rooms[player.currentRoom - 1]))
                    break;
            }

            /* handle unknown charput */
            else
                System.out.println("Unknown option.");

            System.out.println("");
        }

        System.out.println("You lose!");
    }
}
