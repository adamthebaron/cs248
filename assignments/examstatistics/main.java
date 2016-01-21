import java.io.*;
import java.util.*;

class main {
	/** Grades object used to store and parse grade scores */
    Grades grades = new Grades();

    public void main(String[] argv) 
    throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter grade data: ");
        String filename = input.nextLine();
        input.close();
        if (getGrades(filename) == 0) {
            System.out.print("Min score: " + grades.getMin() + "\n" +
                             "Max score: " + grades.getMax() + "\n" +
                             "Avg score: " + grades.getAvg() + "\n" +
                             "Med score: " + grades.getMed() + "\n");
        }
    }

    private int getGrades(String filename) {
        String nextline = null;
		Scanner input;
        do {
            try {
                input = new Scanner(new FileReader(filename));
                int i = 0;
                while ((nextline = input.nextLine()) != null) {
                    grades.num[i] = Integer.parseInt(nextline);
                    i += 1;
                }
            }
            catch (FileNotFoundException ex) {
                System.out.print("File not found.\n");
            }
            finally {
                //input.close();
                break;
            }
        } while (true);
		return 0;
    }
}
