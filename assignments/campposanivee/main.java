import java.io.*;
import java.util.*;

class main {
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

  static void handleW(String[] line, BST campers) {
	camper Camper = new camper();
	Camper.name = line[1];
	campers.delete(Camper);
	String gender = (Camper.sex == 'F') ? "female" : "male";
	System.out.println("Removing camper " + line[1]);
  }

  static void handleD(String[] line, BST campers) {
	camper Camper = new camper();
	Camper.name = line[1];
	camper displayCamper = (camper) campers.search(Camper);
	String gender = (displayCamper.sex == 'F') ? "female" : "male";
	System.out.println("Displaying: " + displayCamper.name + " is "
						+ displayCamper.age + " years old and is "
						+ gender);
  }

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

  static void handleL(BST campers) {

  }

  static void handleS(BST campers) {
		int boys = 0;
		int girls = 0;
		campers.reset(BST.PREORDER);
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

  static void handleP(BST campers) {
	  System.out.println("Campers in preorder:");
	  campers.reset(BST.PREORDER);
	  while(campers.hasNext())
		  System.out.println(((camper) (campers.getNext())).name);
  }

  static void handleQ() {
		System.out.println("Finished managing campers.");
		System.exit(0);
  }
}
