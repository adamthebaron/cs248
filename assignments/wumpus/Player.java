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

	void move(int room, Room roomObj) {
		System.out.println(roomObj.adjroom1);
		System.out.println(roomObj.adjroom2);
		System.out.println(roomObj.adjroom3);
    	if (room == roomObj.adjroom1 ||
            room == roomObj.adjroom2 ||
            room == roomObj.adjroom3)
			currentRoom = room;
		else
			System.out.println("You cannot go there from here.");
	}
}
