/* Written by Adam Kessler. 1/11/16 */
import java.io.*;
import java.util.*;

class main {
    static String[] insults = {
    "I bet you use IE.",
    "You probably use nano instead of vi.",
    "echo your_life_story.txt > /dev/null.",
    "These insults are about as lame as I was on prom night. Oh, we're supposed to insult the user.",
    "signal 11: segmentation fault (ur a loser).",
    "Might as well call you Deacon Blues... no? No one got that one?"
    };

    private static int response(Scanner scanner) {
        System.out.println("Would you like to play again?");
        String answer = scanner.nextLine(); 
        if (answer == "yes" || answer == "Yes" || answer == "y" || answer == "Y")
            return 1;
        else if (answer == "no" || answer == "No" || answer == "n" || answer == "N")
            return 0;
        return -1;
    }

    /* receive/check input, then ask the user if they want to play again and call response()
       flexible conditional statements make the program more user friendly */ 
    private static int guess(Scanner scanner) {
        System.out.println("Guess a number: ");
        int number = (int) (1 + 100 * Math.random()); // cast as int due to Math.random() returning double 
        for (int input = scanner.nextInt(); input != number; /* no increment */) {
            if (input < number)
                System.out.println("Too low! " + insults[(int) (0 + 5 * Math.random())]);
            else if (input > number)
                System.out.println("Too high! " + insults[(int) (0 + 5 * Math.random())]);
        } 
        System.out.println("Correct!\n");
        if (response(scanner) == 1)
                guess(scanner);
        else if (response(scanner) == 0)
                return 0;
        return -1;
    }

    /* main function; greet, init scanner, and call guess() */
    public static void main(String[] args) {
        System.out.println("Welcome!\n");
        Scanner scanner = new Scanner(System.in);
        if (guess(scanner) == 0)
            System.out.println("Thanks for playing!");
    }
}
