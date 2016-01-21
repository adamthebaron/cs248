import java.io.*;
import java.util.*;

class main {
    FileReader fr = null;
    FileWriter output = null;
    Scanner input = null;
    Grades grades = new Grades();

    public void main(String[] argv) 
    throws IOException {
        input = new Scanner(System.in);
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
                System.out.print("File not Found.\n");
            }
            finally {
                input.close();
                break;
            }
        } while (true);
    }
}
