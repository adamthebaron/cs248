/** @author Adam Kessler */

import java.io.*;
import java.util.*;

class main {
    public static void main(String[] args) {
        String file;
        Scanner scan = new Scanner(System.in);
        System.out.print("La Food restaurant simulator\nPlease enter datafile: ");
        file = scan.next();
        scan.close();
        scan = new Scanner(file);
        QueueArray queue = new QueueArray(100);
        while (scan.nextLine() != "Q") {
            
        }
    }
}
