import java.io.*;
import java.util.*;

public class Grades {
	/* array to hold scores and grade constants */
    public int[] num;
	
	/** file containing grade scores */
	public String filename;
	
	/** grade constants for comparison */
	const int A = 90;
	const int B = 80;
	const int C = 70;
	const int D = 60;
	const int F = 59;

	/** 
		get median score
		@return median median score value 
	*/
    public int getMedian() {
		Array.sort(num);
		int median = (num.length % 2);
		return median;
    }
	
	/** 
		get average score
		@return average average score value
	*/
    public int getAvg() {
		float average = null;
		float total_score = null;
		for (int i = 0; i <= num.length; i++) {
			if (num[i + 1] != null)
				total_score = num[i] + num[i + 1];
			else
				total_score += num[i];
			average = total_score / num.length;
		}
		return average;
    }

    public int getMin() {
		Array.sort(num);
		return num[0];
    }

    public int getMax() {
		Array.sort(num);
		return num[num.length];
    }
	
	public int sortLetter() {
		/* int[0] = A grades, int[1] = B grades, etc. */
		int[4] gradeArr = null;
		for (int i = 0; i <= num.length; i++) {
			if (num[i] >= 90)
				int[0] += 1;
			else if (num[i] >= 80 && num[i] < 90)
				int[1] += 1;
			else if (num[i] >= 70 && num[i] < 80)
				int[2] += 1;
			else if (num[i] >= 60 && num[i] < 70)
				int[3] += 1;
			else
		}
	}
}
