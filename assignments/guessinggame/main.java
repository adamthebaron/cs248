import java.io.*;
import java.util.*;

class main {
    String[] insults = {
    "I bet you use IE.",
    "You probably use nano instead of vi.",
    "echo your_life_story.txt > /dev/null.",
    "These insults are about as lame as I was on prom night. Oh, we're supposed to insult the user.",
    "signal 11: segmentation fault (ur a loser).",
    "Might as well call you Deacon Blues... no? No one got that one?"
    };

    /* receive/check input, then ask the user if they want to play again */ 
    private static int guess(Scanner scanner) {
        System.out.println("Guess a number: ");
        int input = scanner.nextInt();
        for (;;) {
        }
    }

    /* main function; greet, init scanner, and call guess() */
    private static int main() {
        System.out.println("Welcome!\n");
        Scanner scanner = new Scanner(System.in);
        guess(scanner);
        return 0;
    }
}
