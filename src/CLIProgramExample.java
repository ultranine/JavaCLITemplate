import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * Simple command line image viewer, example of CLI template.
 *
 * @author ultranine
 * @version 1.0.0
 */
public class CLIProgramExample {
    /**
     * Main method.
     *
     * @param args - Command line arguments (unused).
     */
    public static void main(String[] args) {
        // Variable Initialization
        Scanner userInput = new Scanner(System.in); // User input scanner.
        ImageIcon toDisplay; // Image icon variable declaration.
        boolean hasTerminated = false; // Stores if main loop has terminated.
        JLabel label = new JLabel(); // Image display label.
        JFrame display = new JFrame("Image Viewer"); // Display window.
        display.setResizable(false); // Lock window size.
        display.add(label); // Add display label to window.

        // Main program loop
        System.out.println("Enter a command or type \"help\" for a list of commands.");
        while (!hasTerminated) {
            String[] usercmd = userInput.nextLine().split(" "); // Split user input into arguments.

            switch (usercmd[0]) {
                case "display": {
                    if (usercmd.length < 2) {
                        // Prevent execution if no file argument.
                        System.out.println("Syntax Error.");
                    }
                    else {
                        // Reattach any filepath parts that may have been split off.
                        String filepath = usercmd[1];
                        for (byte i = 2; i < usercmd.length; i++) {
                            filepath = filepath.concat(" " + usercmd[i]);
                        }

                        // Check if image actually exists.
                        File image = new File(filepath);
                        if (!image.exists()) {
                            System.out.println(image.getAbsolutePath() + " does not exist!");
                            continue; // Stop command execution if no file found.
                        }

                        // Display image.
                        toDisplay = new ImageIcon(image.getAbsolutePath());
                        label.setIcon(toDisplay);
                        display.setSize(toDisplay.getIconWidth(), toDisplay.getIconHeight());
                        display.setVisible(true);
                    }
                } break;
                case "help": {
                    System.out.println(
                            """
                            Commands:\s
                            display <file>: Displays image.
                            help: Display this list.
                            exit: Terminate program.
                            """
                    );
                } break;
                case "exit": {
                    System.out.println("Program terminated.");
                    hasTerminated = true;
                } break;
                default: {
                    System.out.println("Unknown Command.");
                }
            }
        }
    }
}
