import java.io.*;
import java.util.*;

class main {

    public static void main(String[] argv) 
    throws IOException {
		Scanner reader = new Scanner(System.in);
        System.out.print("Please enter grade data: ");
        String filename = reader.nextLine();
		BufferedReader lines = new BufferedReader(new FileReader(filename));
		int lineno = 0;
		while (lines.readLine() != null)
			lineno++;
		lines.close();
		Grades grades = new Grades();
		getGrades(filename, grades);
	}

	public static void getGrades(String filename, Grades grades)
	throws FileNotFoundException {
		Scanner input = new Scanner(new File(filename));
		String nextline = "";
		int i = 0;
		while ((nextline = input.nextLine()) != null && input.hasNext() == true) {
			grades.num[i] = Integer.parseInt(nextline);
			i += 1;
		}
		System.out.print(Arrays.toString(grades.num));
	}
}
