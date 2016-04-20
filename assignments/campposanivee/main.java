/** @author Adam Kessler */
import java.io.*;
import java.util.*;

class main {
    /** initialize BST, scan file
      @param args arguments sent to the program
      */
    public static void main(String[] args)
        throws IOException {
        BST campers = new BST();
        Scanner file = new Scanner(new FileReader("camp.txt"));
        String line;
        System.out.println("Welcome to Camp Posanivee.");
        while ((line = file.nextLine()) != null) {
            String[] curline = line.split(" ");
            if (line.charAt(0) == 'H') {
                System.out.println("Command H:");
                handleH();
                System.out.println();
            }
            else if (line.charAt(0) == 'E') {
                System.out.println("Command E:");
                handleE(curline, campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'W') {
                System.out.println("Command W:");
                handleW(curline, campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'D') {
                System.out.println("Command D:");
                handleD(curline, campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'A') {
                System.out.println("Command A:");
                handleA(campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'L') {
                System.out.println("Command L:");
                handleL(campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'S') {
                System.out.println("Command S:");
                handleS(campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'P') {
                System.out.println("Command P:");
                handleP(campers);
                System.out.println();
            }
            else if (line.charAt(0) == 'Q') {
                System.out.println("Command Q:");
                handleQ();
                System.out.println();
            }
        }
    }
    /** print help information
    */
    static void handleH() {
        String help = "H: Print this help\n"
            + "E: Enroll a new camper\n"
            + "W: Withdraw a camper\n"
            + "D: Display the age and gender of a camper\n"
            + "A: Print the average age of the campers\n"
            + "L: List all campers names in alphabetical order\n"
            + "S: Print the number of boy and girl campers\n"
            + "P: List all campers names in preorder\n"
            + "Q: Quit\n";
        System.out.print(help);
    }
    /** Enroll new camper
      @param line command line
      @param campers BST of all enrolled campers
      */
    static void handleE(String[] line, BST campers) {
        camper Camper = new camper();
        Camper.name = line[1];
        Camper.age = Integer.parseInt(line[2]);
        Camper.sex = line[3].charAt(0);
        campers.insert(Camper);
        String gender = (Camper.sex == 'F') ? "female" : "male";
        System.out.println("Adding camper " + line[1]
                + " with the age " + line[2]
                + " who is " + gender);
    }
    /** Withdraw camper
      @param line command line
      @param campers BST of all enrolled campers
      */
    static void handleW(String[] line, BST campers) {
        camper Camper = new camper();
        Camper.name = line[1];
        campers.delete(Camper);
        String gender = (Camper.sex == 'F') ? "female" : "male";
        System.out.println("Removing camper " + line[1]);
    }
    /** Display camper
      @param line command line
      @param campers BST of all enrolled campers
      */
    static void handleD(String[] line, BST campers) {
        camper Camper = new camper();
        Camper.name = line[1];
        String gender = (((camper)(campers.search(Camper))).sex == 'F') ? "female" : "male";
        System.out.println("Displaying: " + ((camper)(campers.search(Camper))).name + " is "
                + ((camper)(campers.search(Camper))).age + " years old and is "
                + gender);
    }
    /** Print average age
      @param campers BST of all enrolled campers
      */
    static void handleA(BST campers) {
        int total = 0;
        campers.reset();
        while(campers.hasNext())
            total += ((camper) (campers.getNext())).age;
        if (campers.size() == 0)
            System.out.println("Average age is: 0");
        else
            System.out.println("Average age is: "
                    + (float) total/campers.size());
    }
    /** List campers in alphabetical order
      @param campers BST of all enrolled campers
      */
    static void handleL(BST campers) {
        campers.reset(BST.INORDER);
        System.out.println("Campers in alphabetical order:");
        while(campers.hasNext())
            System.out.println(((camper) (campers.getNext())).name);
    }
    /** Print number of boy and girl campers
      @param campers BST of all enrolled campers
      */
    static void handleS(BST campers) {
        int boys = 0;
        int girls = 0;
        campers.reset(BST.INORDER);
        camper Camper = new camper();
        while (campers.hasNext()) {
            if (((camper) (campers.getNext())).sex == 'F')
                girls++;
            else
                boys++;
        }
        System.out.println("The number of boy campers is "
                + boys + " and the number of girl campers is "
                + girls);
    }
    /** List campers in preorder
      @param campers BST of all enrolled campers
      */
    static void handleP(BST campers) {
        System.out.println("Campers in preorder:");
        campers.reset(BST.PREORDER);
        while(campers.hasNext())
            System.out.println(((camper) (campers.getNext())).name);
    }
    /** Quit program
    */
    static void handleQ() {
        System.out.println("Finished managing campers.");
        System.exit(0);
    }
}
