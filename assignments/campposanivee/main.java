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
		if(line.charAt(0) == 'H')
			handleH();
		else if(line.charAt(0) == 'E')
			handleE(curline, campers);
		else if(line.charAt(0) == 'W')
			handleW(curline, campers);
		else if(line.charAt(0) == 'D')
			handleD(curline, campers);
		else if(line.charAt(0) == 'A')
			handleA(campers);
		else if(line.charAt(0) == 'L')
			handleL(campers);
		else if(line.charAt(0) == 'S')
			handleS(campers);
		else if(line.charAt(0) == 'P')
			handleP(campers);
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
	System.out.println("Removing camper " + line[1]
			 + " with the age " + line[2]
			 + " who is " + gender);
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

  static int handleA(BST campers) {
    float total = 0;
    camper Camper = new camper();
	while(campers.search(Camper) != null)
		total += (float) Camper.age;
	System.out.println("Average age is: " + (int) total);
	return (int) (total/campers.size());
  }

  static void handleL(BST campers) {

  }

  static void handleS(BST campers) {
		int boys = 0;
		int girls = 0;
		camper Camper = new camper();
		while(campers.search(Camper) != null) {
			if (Camper.sex == 'F')
				girls++;
			if (Camper.sex == 'M')
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
		  System.out.println(campers.getNext());
  }

  static void handleQ() {
		System.out.println("Finished managing campers.");
		System.exit(0);
  }
}
