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
  /* bubble, insertion, selection, quicksort, shell */
  void sort(Integer[] numbers, boolean print) {
    handleSort("bubble", numbers, print);
    handleSort("insertion", numbers, print);
    handleSort("selection", numbers, print);
    handleSort("quicksort", numbers, print);
    handleSort("shell", numbers, print);
  }

  void handleSort(String sort, Integer[] numbers) {
    int before = 0;
    int after = 0;
    Comparable[] Sort = new Comparable[];
    System.out.print(sort + " sort running time: ");
    switch (sort) {
      case "bubble":
        before = (int) System.currentTimeMillis();
        Sort = bubble(numbers);
        after = (int) System.currentTimeMillis();
        System.out.println(after - before);
        if (print)
          System.out.println(Sort);
      case "insertion":
        before = (int) System.currentTimeMillis();
        Sort = insertion(numbers);
        after = (int) System.currentTimeMillis();
        System.out.println(after - before);
        if (print)
          System.out.println(Sort);
      case "selection":
        before = (int) System.currentTimeMillis();
        Sort = selection(numbers);
        after = (int) System.currentTimeMillis();
        System.out.println(after - before);
        if (print)
          System.out.println(Sort);
      case "quicksort":
        before = (int) System.currentTimeMillis();
        Sort = quicksort(numbers);
        after = (int) System.currentTimeMillis();
        System.out.println(after - before);
        if (print)
          System.out.println(Sort);
      case "shell":
        before = (int) System.currentTimeMillis();
        Sort = shell(numbers);
        after = (int) System.currentTimeMillis();
        System.out.println(after - before);
        if (print)
          System.out.println(Sort);
    }
  }
}
