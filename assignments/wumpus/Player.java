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

	int move(int room) {
        if (room == currentRoom) {
            return 1;
        }

        currentRoom = room;
        return 0; 
	}
}
