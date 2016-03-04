/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Player {

    int arrows = 3;
    int currentRoom = 1;

	int shoot() {
		if(arrows != 0)
            arrows -= 1;
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
