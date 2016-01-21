import java.io.*;
import java.util.*;

public class Grades {
	/* array to hold scores and grade constants */
    public int[] num;
	const int A = 90;
	const int B = 80;
	const int C = 70;
	const int D = 60;
	const int F = 59;

	/** 
		get median score
		@param filename file containing scores
		@return median median score value 
	*/
    public int getMedian(String filename) {
		Array.sort(num);
		int median = (num.length % 2);
		return median;
    }
	
	/** 
		get average score
		@param filename file containing scores
		@return average average score value
	*/
    public int getAvg(String filename) {
		float average = null;
		for (int i = 0; i <= num.length; i++) {
			float total_score = num[i] + num[i + 1];
			average = total_score / num.length;
		}
		return average;
    }

    public int getMin(String filename) {
		Array.sort(num);
		return num[0];
    }

    public int getMax(String filename) {
		Array.sort(num);
		return num[num.length];
    }
}
