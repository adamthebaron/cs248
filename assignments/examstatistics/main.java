import java.io.*;
import java.util.*;

class main {
    FileReader fr = null;
    FileWriter output = null;
    Scanner input = null;
    Grades grades = null;

    public void main(String[] argv) 
    throws IOException {
        input = new Scanner(System.in);
        System.out.print("Please enter grade data: ");
        String filename = input.nextLine();
        String nextline = null;
        input.close();
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
        } while(true);
    }
}
