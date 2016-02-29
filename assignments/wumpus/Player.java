/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Player {

    int arrows = 3;

	int shoot() {
		if(arrows != 0)
            arrows -= 1;
        else
            return 1;
        return 0;
	}

//	int move() {

//	}
}
