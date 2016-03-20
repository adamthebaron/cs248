/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Player {

    int arrows = 3;
    int currentRoom = 1;

	boolean shoot(int room, int wumpus, Room roomObj) {
		if (arrows > 0) {
            arrows -= 1;
			if (room == roomObj.adjroom1 ||
            	room == roomObj.adjroom2 ||
            	room == roomObj.adjroom3) {
				if (room == wumpus) {
					System.out.println("You hit the wumpus!");
                    return true;
                }
			}
			else
				System.out.println("You can't shoot an arrow there.");
		}

        return false;
	}

	boolean move(int room, int wumpus, int[] spiders, int[] pits, Room roomObj) {
    	if (room == roomObj.adjroom1 ||
            room == roomObj.adjroom2 ||
            room == roomObj.adjroom3)
			currentRoom = room;
 		else
			System.out.println("You cannot go there from here.");
       if (wumpus == roomObj.adjroom1 ||
            wumpus == roomObj.adjroom2 ||
            wumpus == roomObj.adjroom3)
            System.out.println("\nYou smell a wumpus nearby.");
        if (spiders[0] == roomObj.adjroom1 ||
            spiders[0] == roomObj.adjroom2 ||
            spiders[0] == roomObj.adjroom3 ||
            spiders[1] == roomObj.adjroom1 ||
            spiders[1] == roomObj.adjroom2 ||
            spiders[1] == roomObj.adjroom3)
            System.out.println("\nYou hear a spider nearby.");
        if (pits[0] == roomObj.adjroom1 ||
            pits[0] == roomObj.adjroom2 ||
            pits[0] == roomObj.adjroom3 ||
            pits[1] == roomObj.adjroom1 ||
            pits[1] == roomObj.adjroom2 ||
            pits[1] == roomObj.adjroom3)
            System.out.println("\nYou hear a rock fall into a pit nearby.");

        if (currentRoom == wumpus) {
            System.out.println("You were attacked by the wumpus!");
            return true;
        }
        else if (currentRoom == pits[0] || currentRoom == pits[1]) {
            System.out.println("You fell into a pit!");
            return true;
        }
        else if (currentRoom == spiders[0] || currentRoom == spiders[1]) {
            System.out.println("You were attacked by a spider!");
            return true;
        }
        else
            return false;
	}
}
