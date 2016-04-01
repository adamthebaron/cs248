/** @author Adam Kessler */
import java.io.*;
import java.util.*;

class main {
	/**initialize variables, ask for input size, randomize number array, 
		 check for print, call sort 
		 @param args arguments sent to program 
	*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input size (n): ");
        int n = scanner.nextInt();
        Integer[] numbers = populate(n);
        boolean print = false;

        if (n <= 100) {
            System.out.println(Arrays.toString(numbers));
            print = true;
        }

        sort(numbers, print, n);
    }
	
	/**  randomize number array
			@param n input size
			@return numbers random number array */
    static Integer[] populate(int n) {
        ArrayList<Integer> rand = new ArrayList<Integer>();
        Integer[] numbers = new Integer[n];

        for (int i = 0; i <= n; i++)
            rand.add(new Integer(i));

        Collections.shuffle(rand);

        for (int i = 0; i < n; i++)
            numbers[i] = rand.get(i);

        return numbers;
    }
    
	/** call all sort methods
		  @param numbers random number array
		  @param print check to see if array should be printed
		  @param n input size
	*/
    static void sort(Integer[] numbers, boolean print, int n) {
        bubbleSort(numbers, print, n);
        insertionSort(numbers, print, n);
        selectionSort(numbers, print, n);
        quickSort(numbers, print, n);
        shellSort(numbers, print, n);
    }

	/** call bubble sort on number array
		  @param numbers random number array
		  @param print check to see if array should be printed
		  @param n input size
	*/
    static void bubbleSort(Integer[] numbers, boolean print, int n) {
        int before = 0;
        int after = 0;
		Integer[] Sort = new Integer[n];
		for (int i = 0; i < numbers.length; i++)
			Sort[i] = new Integer(numbers[i]);
        System.out.print("bubble sort running time: ");
        before = (int) System.currentTimeMillis();
        Sorts.bubble(Sort);
        after = (int) System.currentTimeMillis();
        System.out.println((after - before) + " milliseconds");
        if (print)
            System.out.println(Arrays.toString(Sort));
    }

	/** call insertion sort on number array
		  @param numbers random number array
		  @param print check to see if array should be printed
		  @param n input size
	*/
    static void insertionSort(Integer[] numbers, boolean print, int n) {
        int before = 0;
        int after = 0;
        Integer[] Sort = new Integer[n];
		for (int i = 0; i < numbers.length; i++)
			Sort[i] = new Integer(numbers[i]);
        System.out.print("insertion sort running time: ");
        before = (int) System.currentTimeMillis();
        Sorts.insertion(Sort);
        after = (int) System.currentTimeMillis();
        System.out.println((after - before) + " milliseconds");
        if (print)
            System.out.println(Arrays.toString(Sort));

    }

	/** call selection sort on number array
		  @param numbers random number array
		  @param print check to see if array should be printed
		  @param n input size
	*/
    static void selectionSort(Integer[] numbers, boolean print, int n) {
        int before = 0;
        int after = 0;
        Integer[] Sort = new Integer[n];
		for (int i = 0; i < numbers.length; i++)
			Sort[i] = new Integer(numbers[i]);
        System.out.print("selection sort running time: ");
        before = (int) System.currentTimeMillis();
        Sorts.select(Sort);
        after = (int) System.currentTimeMillis();
        System.out.println((after - before) + " milliseconds");
        if (print)
            System.out.println(Arrays.toString(Sort));

    }

	/** call quick sort on number array
		  @param numbers random number array
		  @param print check to see if array should be printed
		  @param n input size
	*/
    static void quickSort(Integer[] numbers, boolean print, int n) {
        int before = 0;
        int after = 0;
        Integer[] Sort = new Integer[n];
		for (int i = 0; i < numbers.length; i++)
			Sort[i] = new Integer(numbers[i]);
        System.out.print("quicksort running time: ");
        before = (int) System.currentTimeMillis();
        Sorts.quick(Sort);
        after = (int) System.currentTimeMillis();
        System.out.println((after - before) + " milliseconds");
        if (print)
            System.out.println(Arrays.toString(Sort));

    }

	/** call shell sort on number array
		  @param numbers random number array
		  @param print check to see if array should be printed
		  @param n input size
	*/
    static void shellSort(Integer[] numbers, boolean print, int n) {
        int before = 0;
        int after = 0;
        Integer[] Sort = new Integer[n];
		for (int i = 0; i < numbers.length; i++)
			Sort[i] = new Integer(numbers[i]);
        System.out.print("shellsort running time: ");
        before = (int) System.currentTimeMillis();
        Sorts.shell(Sort);
        after = (int) System.currentTimeMillis();
        System.out.println((after - before) + " milliseconds");
        if (print)
            System.out.println(Arrays.toString(Sort));

    }
}
