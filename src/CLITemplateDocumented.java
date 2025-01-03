import java.util.Scanner;

/**
 * Very barebones template for a CLI-based program.
 * A version of this without documentation and the example command can be found in the same file,
 * this one mainly serves as a demonstration.
 *
 * @author ultranine
 * @version 1.0.0
 */
public class CLITemplateDocumented {
    /**
     * Main method.
     *
     * @param args Command line arguments (unused in this template).
     */
    public static void main(String[] args) {
        // Initialize persistent variables
        Scanner userInput = new Scanner(System.in); // Scanner for user commands.
        boolean hasTerminated = false; // Break condition for main loop.
        // Insert any other variables that should be persistent here.

        // Main program loop.
        // Startup message, you can expand on or replace this.
        System.out.println("Enter a commmand or type \"help\" for a list of commands.");
        while (!hasTerminated) { // Loops as long as hasTerminated is false.
            /*
            Splits the next line of user input into an argument array.
            If there is an argument that might be split by this function
            (ex, a filepath that may have a space or two in it) you can reattach it using a for loop,
            such as this one:

            String argument = usercmd[{starting arg index}];
            for (byte/short i = {starting arg index + 1}; i < usercmd.length; i++) {
                argument = argument.concat(usercmd[i]);
            }

            Obviously, this should only be used if the split argument is the last in the list.
             */
            String[] usercmd = userInput.nextLine().split(" ");

            /*
             Processes the command according to the first argument.
             If the user presses enter without doing anything, the empty string will still
             produce a one entry array, so it will not break the program.
             */
            switch (usercmd[0]) {
                /*
                This example command shows how to create a multi-argument command,
                and how to handle an argument that may have potentially been split by the above parser.
                */
                case "example": {
                    /*
                    This statement checks to make sure the input command has enough arguments,
                    as if it doesn't, any code attempting to access arguments beyond what was inputted
                    will result in an out-of-bounds exception. The "2" should be replaced with whatever
                    the minimum argument length for the command is.
                    */
                    if (usercmd.length < 2) {
                        System.out.println("Not enough arguments!");
                        continue; // Skip to next loop iteration, ignoring rest of command.
                    }

                    /*
                     A loop such as this can be used to "reattach" parts of an argument that may have
                     been split off by the input splitter above (such as a filepath). Any argument that uses
                     a loop such as this should be placed at the end of the command sequence, otherwise the loop
                     may concatenate other arguments into the former.
                    */
                    String potentiallySplitArgument = usercmd[1]; // Get first part of argument.

                    /*
                    Start concatenating at next index of command array.
                    If the argument was never split, the condition for this loop will never be met,
                    meaning it will only execute if needed. A byte is used for the index here, which should be enough
                    to cover all but the most complicated of arguments, in which case a short or int can be used
                    instead.
                    */
                    for (byte i = 2; i < usercmd.length; i++) {
                        // Concatenates next parts of argument onto the first, restoring spaces.
                        potentiallySplitArgument = potentiallySplitArgument.concat(" " + usercmd[i]);
                    }

                    // Execute the command.
                    System.out.println(potentiallySplitArgument);
                    // Remember to clean up any persistent variables after a command is executed if needed.
                } break;
                case "help": {
                    System.out.println(
                            """
                            You can put a blurb of text detailing how various commands operate
                            within these triple quotes, and absolutely should if you intend for
                            this program to be used by other people. Blocks such as this automatically
                            handle newlines.
                            """
                    );
                } break;
                case "exit": {
                    // Terminate program loop
                    System.out.println("Program terminated.");
                    hasTerminated = true; // Main loop will stop at the end of this iteration.
                } break;
                default: {
                    // Handle invalid commands.
                    System.out.println("Unknown command.");
                }
            }
        }
    }
}
