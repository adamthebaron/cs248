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
            try {
                input = new Scanner(new FileReader(filename));
                while ((nextline = input.readLine()) != null) {
                    for (int i = 0; ;i++) {
                        grades.num[i] = nextline;
                    }
                }
            }
        }




        private void write_grades(String filename) 
        throws IOException {
            input = new Scanner(new FileReader(filename));
            String curline;
            while ((curline = input.readLine()) != null) {
                
            }
        }
}
