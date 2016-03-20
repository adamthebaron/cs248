/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Player {

    int arrows = 3;
    int currentRoom = 1;

	boolean shoot(int room, int wumpus, Room roomObj) {
		if (arrows > 0) {
            arrows -= 1;
			if ((room == roomObj.adjroom1 ||
            	room == roomObj.adjroom2 ||
            	room == roomObj.adjroom3) && room == wumpus) {
					System.out.println("You hit the wumpus!");
                    return true;
                }
                return false;
			}
			else
				System.out.println("You can't shoot an arrow there.");

        return false;
	}

	boolean move(int room, int wumpus, int[] spiders, int[] pits, Room roomObj) {
    	if (this.singleCheck(room, roomObj))
            currentRoom = room;
 		else
			System.out.println("You cannot go there from here.");
        if (this.singleCheck(wumpus, roomObj))
            System.out.println("\nYou smell a wumpus nearby.");
        if (this.multiCheck(spiders, roomObj))
            System.out.println("\nYou hear a spider nearby.");
        if (this.multiCheck(pits, roomObj))
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

    boolean singleCheck(int room, Room roomObj) {
        if (room == roomObj.adjroom1 ||
            room == roomObj.adjroom2 ||
            room == roomObj.adjroom3)
                return true;
        else
                return false;
    }

    boolean multiCheck(int[] rooms, Room roomObj) {
        for (int i = 0; i <= (rooms.length - 1); i++)
            if (rooms[i] == roomObj.adjroom1 ||
                rooms[i] == roomObj.adjroom2 ||
                rooms[i] == roomObj.adjroom3)
                    return true;

        return false;
    }
}
