/** @author Adam Kessler */
import java.io.*;
import java.util.*;

public class Grades {

    /* int array that contains each individual score */
    public int[] num;
	
    /** constructor
     *  @param size number of grades to analyze */
    public Grades(int size) {
	num = new int[size];
    }
	
    /* file containing grade scores */
    public String filename;
	
    /* grade constants for comparison */
    public final int A = 90;
    public final int B = 80;
    public final int C = 70;
    public final int D = 60;

    /** get median score
	@return median median score value */
    public int getMed() {
    	Arrays.sort(num);
        if (num.length % 2 == 0)
	    return num[num.length / 2] + num[num.length / (2 - 1)] / 2;
        else
            return num[num.length / 2];
    }
	
    /** get average score
	@return average average score value */
    public float getAvg() {
	float average = 0;
	float total_score = 0;
	for (int i : num)
		total_score += i;
	average = total_score / num.length;
	return average;
    }

    /** get minimum score
     *  @return num[0] smallest value in sorted num array */
    public int getMin() {
	Arrays.sort(num);
	return num[0];
    }

    /** get maximum score
     *  @return num[num.length - 1] highest value in sorted num array
     *  (- 1 due to arrays being zero indexed) */
    public int getMax() {
	Arrays.sort(num);
	return num[num.length - 1];
    }
	
    /** sort each grade by letter
     *  @return gradeArr[] array of sorted letter grades */
    public int[] sortLetter() {
	/* int[0] = A grades, int[1] = B grades, etc. */
	int[] gradeArr = { 0, 0, 0, 0, 0 };
	for (int i = 0; i <= (num.length - 1); i++) {
		if (num[i] >= A)
			gradeArr[0] += 1;
		else if (num[i] >= B && num[i] < A)
			gradeArr[1] += 1;
		else if (num[i] >= C && num[i] < B)
			gradeArr[2] += 1;
		else if (num[i] >= D && num[i] < C)
			gradeArr[3] += 1;
		else
			gradeArr[4] += 1;
	}
	return gradeArr;
    }
}
