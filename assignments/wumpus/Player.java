/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Player {

    int arrows = 3;
    int currentRoom = 1;

	int shoot(int room, int wumpus, int[] spiders, Room roomObj) {
		if (arrows != 0) {
            arrows -= 1;
			if (room == roomObj.adjroom1 ||
            	room == roomObj.adjroom2 ||
            	room == roomObj.adjroom3) {
				if (room == wumpus)
					System.out.println("You hit the wumpus!");
				else if (room == spiders[0] || room == spiders[1])
					System.out.println("You hit a spider!");
			}
			else
				System.out.println("You can't shoot an arrow there.");
		}
        else
            return 1;
        return 0;
	}

	void move(int room, int wumpus, int[] spiders, Room roomObj) {
    	if (room == roomObj.adjroom1 ||
            room == roomObj.adjroom2 ||
            room == roomObj.adjroom3)
			currentRoom = room;
        if (wumpus == roomObj.adjroom1 ||
            wumpus == roomObj.adjroom2 ||
            wumpus == roomObj.adjroom3)
            System.out.println("You smell a wumpus nearby.");
        if (spiders[0] == roomObj.adjroom1 ||
            spiders[0] == roomObj.adjroom2 ||
            spiders[0] == roomObj.adjroom3 ||
            spiders[1] == roomObj.adjroom1 ||
            spiders[1] == roomObj.adjroom2 ||
            spiders[1] == roomObj.adjroom3)
            System.out.println("You hear a spider nearby.");
		else
			System.out.println("You cannot go there from here.");
	}
}
