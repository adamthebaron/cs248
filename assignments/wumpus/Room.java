/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class Room {
        public String description;
        public int roomNum;
        public int adjroom1;
        public int adjroom2;
        public int adjroom3;

        public Room(Scanner scanner) {
                roomNum = scanner.nextInt();
                adjroom1 = scanner.nextInt();
                adjroom2 = scanner.nextInt();
                adjroom3 = scanner.nextInt();
                scanner.nextLine();
                description = scanner.nextLine();
        }
}
