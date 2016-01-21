import java.io.*;
import java.util.*;

class Grades {

    public int[] num;

    public int getMedian(String filename) {
		Array.sort(num);
		int median = (num.length % 2);
		return median;
    }

    public int getAvg(String filename) {
		for (int i = 0; i <= num.length; i++) {
			float total_score = num[i] + num[i + 1];
			float average = total_score / num.length;
		}
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
