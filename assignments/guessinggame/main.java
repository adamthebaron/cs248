/* @author Adam Kessler */
import java.io.*;
import java.util.*;

class main {
    /* array of insults used for guess response */
    static String[] insults = {
        "I bet you use IE.",
        "You probably use nano instead of vi.",
        "echo your_life_story.txt > /dev/null.",
        "These insults are about as lame as I was on prom night. Oh, we're supposed to insult the user.",
        "signal 11: segmentation fault (what are you thinking?).",
        "Might as well call you Deacon Blues... no? No one got that one?"
    };
    
    /* Scanner instance used for user input */
    static Scanner stdin = new Scanner(System.in);

    /* ask user if they wish to play again or quit, then return to guess() or main() accordingly.
     * assume any answer that starts with y or n means "yes" or "no" respectively.
     * @param scanner global scanner used for user input
     * @return        return 0 to go to main */ 
    private static int response(Scanner scanner) {
        System.out.print("Would you like to play again?: ");
        String answer = scanner.nextLine(); 
        if (answer.startsWith("y") || answer.startsWith("Y"))
            guess(scanner);
        else if (answer.startsWith("n") || answer.startsWith("N")) {
            return 0;
		}
        else {
            System.out.print("Not sure what you mean, please answer yes or no.\n");
            response(scanner);
        }
        return -1;
    }

    /* receive/check input, then ask the user if they want to play again and call response() 
     * @param scanner global scanner used for user input
     * @return        0 to go to main */
    private static int guess(Scanner scanner) {
        int number = (int) (1 + 100 * Math.random()); // cast as int due to Math.random() returning double
		int input = 0;
    	for (int i = 1; ; i++) {
			System.out.print("What is your guess?: ");
		    while (!scanner.hasNextInt()) {
		    	System.out.print("Please enter a number from 1 to 100.\n");
			    System.out.print("What is your guess?: ");
		    	scanner.next();
		    }
			input = scanner.nextInt();
            if (input < number)
				System.out.print("Too low! " + insults[(int) (0 + 5 * Math.random())] + "\n");
            else if (input > number)
            	System.out.print("Too high! " + insults[(int) (0 + 5 * Math.random())] + "\n");
            else if (input == number) {
            	System.out.print("Correct!\nIt took you " + i + " tries to find the right number.\n");
				break;
			}
		}
        if (response(scanner) == 1)
            guess(scanner);
        return 0;
    }

    /* main function; greet, init scanner, and call guess() */
    public static void main(String[] args) {
        System.out.print("Welcome!\nTry to guess a number between 1 and 100.\n");
        if (guess(stdin) == 0) {
			stdin.close();
            System.out.print("Thanks for playing!\n");
		}
    }
}
