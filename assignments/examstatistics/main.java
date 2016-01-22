import java.io.*;
import java.util.*;

class main {

    public static void main(String[] argv) 
    throws IOException {
		Scanner reader = new Scanner(System.in);
        System.out.print("Please enter grade data: ");
        String filename = reader.nextLine();
		reader.close();
		Scanner input = new Scanner(new FileReader(filename));
		int n = Integer.parseInt(input.nextLine());
		Grades grades = new Grades(n);
		getGrades(input, grades);
		int[] gradeArr = grades.sortLetter();
		System.out.print("Minimum score: " + grades.getMin() + "\n" +
						 "Maximum score: " + grades.getMax() + "\n" +
						 "Average score: " + grades.getAvg() + "\n");
		System.out.print("Number of scores by letter grade:\n" +
						 "A: " + gradeArr[0] + "\n" +
						 "B: " + gradeArr[1] + "\n" +
						 "C: " + gradeArr[2] + "\n" +
						 "D: " + gradeArr[3] + "\n" +
						 "F: " + gradeArr[4] + "\n");
	}

	public static void getGrades(Scanner input, Grades grades)
	throws FileNotFoundException {
		for (int i = 0; i < grades.num.length; i++) {
			grades.num[i] = Integer.parseInt(input.nextLine());
		}
	}
}
