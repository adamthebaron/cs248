/* Written by Adam Kessler. 1/11/16 */
import java.io.*;
import java.util.*;

class main {
    /* array of insults used for guess response */
    static String[] insults = {
    "I bet you use IE.",
    "You probably use nano instead of vi.",
    "echo your_life_story.txt > /dev/null.",
    "These insults are about as lame as I was on prom night. Oh, we're supposed to insult the user.",
    "signal 11: segmentation fault (ur a loser).",
    "Might as well call you Deacon Blues... no? No one got that one?"
    };

    /* ask user if they wish to play again or quit, then return to guess() or main() accordingly.
     * return 1 = guess()
     * flexible conditional statements make the program more user friendly
     * however are somewhat unecessary */ 
    private static int response(Scanner scanner) {
        System.out.print("Would you like to play again?: ");
        String answer = scanner.nextLine(); 
        if (answer == "yes" || answer == "Yes" || answer == "y" || answer == "Y")
            return 1;
        else if (answer == "no" || answer == "No" || answer == "n" || answer == "N")
            return 0;
        return -1;
    }

    /* receive/check input, then ask the user if they want to play again and call response() */
    private static int guess(Scanner scanner) {
        int number = (int) (1 + 100 * Math.random()); // cast as int due to Math.random() returning double 
        for (;;) {
            System.out.print("Guess a number: ");
            int input = scanner.nextInt();
            if (input < number)
                System.out.print("Too low! " + insults[(int) (0 + 5 * Math.random())] + "\n");
            else if (input > number)
                System.out.print("Too high! " + insults[(int) (0 + 5 * Math.random())] + "\n");
            else if (input == number) {
                System.out.print("Correct!\n");
                break;
            }
        } 
        if (response(scanner) == 1)
            guess(scanner);
        return 0;
    }

    /* main function; greet, init scanner, and call guess() */
    public static void main(String[] args) {
        System.out.print("Welcome!\n");
        Scanner scanner = new Scanner(System.in);
        if (guess(scanner) == 0)
            System.out.print("Thanks for playing!\n");
    }
}
