import java.io.*;
import java.util.*;

public class Grades {

	public int[] num;
	public Grades(int size) {
		num = new int[size];
	}

	/* array to hold scores and grade constants */
    //public int[] num = new int[lines];
	
	/** file containing grade scores */
	public String filename;
	
	/** grade constants for comparison */
	public final int A = 90;
	public final int B = 80;
	public final int C = 70;
	public final int D = 60;
	public final int F = 59;

	/** 
		get median score
		@return median median score value 
	*/
    public int getMed() {
		Arrays.sort(num);
		int median = (num.length % 2);
		return median;
    }
	
	/** 
		get average score
		@return average average score value
	*/
    public float getAvg() {
		float average = 0;
		float total_score = 0;
		for (int i = 0; i <= num.length; i++) {
			if (i + 1 < num.length)
				total_score = num[i] + num[i + 1];
			else
				total_score += num[i];
			average = total_score / num.length;
		}
		return average;
    }

    public int getMin() {
		Arrays.sort(num);
		return num[0];
    }

    public int getMax() {
		Arrays.sort(num);
		return num[num.length];
    }
	
	public void sortLetter() {
		/* int[0] = A grades, int[1] = B grades, etc. */
		int[] gradeArr = { 0, 0, 0, 0 };
		for (int i = 0; i <= num.length; i++) {
			if (num[i] >= 90)
				gradeArr[0] += 1;
			else if (num[i] >= 80 && num[i] < 90)
				gradeArr[1] += 1;
			else if (num[i] >= 70 && num[i] < 80)
				gradeArr[2] += 1;
			else if (num[i] >= 60 && num[i] < 70)
				gradeArr[3] += 1;
			else
				gradeArr[4] += 1;
		}
	}
}
