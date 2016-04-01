import java.io.*;
import java.util.*;

class main {
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
    
    static void sort(Integer[] numbers, boolean print, int n) {
        bubbleSort(numbers, print, n);
        insertionSort(numbers, print, n);
        selectionSort(numbers, print, n);
        quickSort(numbers, print, n);
        shellSort(numbers, print, n);
    }

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
