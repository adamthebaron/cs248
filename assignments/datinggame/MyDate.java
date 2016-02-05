/**
 * MyDate class (implements DateInterface interface)
 * @author Adam Kessler
 */
 
import java.io.*;
import java.util.*;

public class MyDate implements DateInterface {
    
    public int curMonth;
    public int curDay;
    public int curDow;
    public int curYear;
    
    int[] months = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
    };
    
    int[] monthLength = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    
    String[] monthNames = {
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    };
    
    int[] dayofweek = {
        0, 1, 2, 3, 4, 5, 6
    };
    
    int[] days = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
        29, 30, 31
    };
    
    String[] dayNames = {
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday"
    };
    
    public int getDay() { return curDay; }
    
    public int getDow() { return curDow; }
    
    public int getMonth() { return curMonth; }
    
    public int getYear() { return curYear; }
    
    public void set(int m, int d, int y, int dow) {
        curMonth = months[m - 1];
        curDay = days[d - 1];
        curYear = y;
        curDow = dayofweek[dow];
    }
    
    public void tomorrow() {
        if(curYear % 100 == 0 && curYear % 400 == 0 && curYear % 4 == 0)
        /* dealing with a leap year */
            monthLength[1] = 29;
        if (curYear % 4 == 0 && curYear % 100 != 0)
            monthLength[1] = 29;
        else
            monthLength[1] = 28;
            
        if(curDay >= monthLength[curMonth - 1]) {
            curDay = 0;
            curMonth += 1;
        }
        
        if(curMonth >= 12) {
            curYear += 1;
            curMonth = 1;
        }

		if(curDow >= 6)
			curDow = -1;
        
        curDay++;
        curDow++;
    }
    
    public String toString() {
        return dayNames[curDow] + " " +
               monthNames[curMonth - 1] + " " +
               curDay + ", " + curYear;
    }
}