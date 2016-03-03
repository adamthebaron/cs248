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
        if (currentRoom == room)
            System.out.println("You are already here.");
        else if (room == roomObj.adjroom1 ||
                 room == roomObj.adjroom2 ||
                 room == roomObj.adjroom3)
            System.out.println("There is not a tunnel leading to that room.");
        else
            currentRoom = room;
	}
}
