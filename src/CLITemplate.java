import java.util.Scanner;

public class CLITemplate {
    public static void main(String[] args) {
        // Initialize persistent variables
        Scanner userInput = new Scanner(System.in);
        boolean hasTerminated = false;

        // Main program loop.
        System.out.println("Enter a commmand or type \"help\" for a list of commands.");
        while (!hasTerminated) {
            String[] usercmd = userInput.nextLine().split(" ");

            switch (usercmd[0]) {
                case "help": {
                    System.out.println(
                            """
                            
                            """
                    );
                } break;
                case "exit": {
                    System.out.println("Program terminated.");
                    hasTerminated = true;
                } break;
                default: {
                    System.out.println("Unknown command.");
                }
            }
        }
    }
}
