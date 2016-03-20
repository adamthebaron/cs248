/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Player {

    int arrows = 3;
    int currentRoom = 1;

    /**
     * shoots arrow and checks result
     * @param room room to shoot in
     * @param wumpus room where wumpus is located
     * @param roomObj current room info
     * @return true if wumpus is hit
     * @return false if anything else happens
     */
	boolean shoot(int room, int wumpus, Room roomObj) {
        if (arrows == 0)
            return false;
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

    /**
     * move player throughout map
     * @param room room to move to
     * @param wumpus room where wumpus is located
     * @param spiders rooms where spiders are located
     * @param pits  rooms where pits are located
     * @param roomObj current room info
     * @return true if move resulted in losing game
     * @return false if move resulted in not losing game
     */
	boolean move(int room, int wumpus, int[] spiders, int[] pits, Room roomObj) {
    	if (this.singleCheck(room, roomObj))
            currentRoom = room;
 		else
			System.out.println("You cannot go there from here.");

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

    /**
     * check to see if a single room contains something
     * @param room room to check
     * @param roomObj current room info
     * @return true if there is something in room
     * @return false if there is not something in room
     */
    boolean singleCheck(int room, Room roomObj) {
        if (room == roomObj.adjroom1 ||
            room == roomObj.adjroom2 ||
            room == roomObj.adjroom3)
                return true;
        else
                return false;
    }

    /**
     * check to see if multiple rooms contain something
     * @param rooms rooms to check
     * @param roomObj current room info
     * @return true if there is something in a room
     * @return false if there is not something in any room
     */
    boolean multiCheck(int[] rooms, Room roomObj) {
        for (int i = 0; i <= (rooms.length - 1); i++)
            if (rooms[i] == roomObj.adjroom1 ||
                rooms[i] == roomObj.adjroom2 ||
                rooms[i] == roomObj.adjroom3)
                    return true;

        return false;
    }
}
