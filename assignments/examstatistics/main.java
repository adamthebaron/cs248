import java.io.*;
import java.util.*;

class main {
	/* Grades object used to store and parse grade scores */
    static Grades grades = new Grades();

    public static void main(String[] argv) 
    throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter grade data: ");
        String filename = input.nextLine();
        input.close();
        if (grades.getGrades(filename) == 0) {
            System.out.print("Min score: " + grades.getMin() + "\n" +
                             "Max score: " + grades.getMax() + "\n" +
                             "Avg score: " + grades.getAvg() + "\n" +
                             "Med score: " + grades.getMed() + "\n");
        }
    }
}
