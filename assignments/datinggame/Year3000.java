import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Jon Sorenson
*/
public class Year3000
{
    public static void main(String[] args) 
    throws IOException
    {
        DateInterface d = new MyDate();
        d.set(1, 25, 2015, 0);
        while(d.getYear() < 3000)
        {
            d.tomorrow();
            //System.out.println(d);
        }
        // at this point, d represents January 1, 3000
        System.out.println(d);
    }
}
