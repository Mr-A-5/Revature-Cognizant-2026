import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object to read input
        Scanner in = new Scanner(System.in);
        // Print initial message
        System.out.println("Welcome to my REPL App!");
        String action;
        do {
            System.out.print("Please input a command(Enter 'help' for available commands): ");
            // Read action
            action = in.nextLine().trim();
            // Move output to a new line
            System.out.println();
            // Evaluate action to be taken
            if (action.equals("help")) {
                // Print possible commands
                System.out.printf("Available commands:%n" + //
                                        "  add%n" + //
                                        "  subtract%n" + //
                                        "  multiply%n" + //
                                        "  divide%n" + //
                                        "  random%n" + //
                                        "  reverse%n" + //
                                        "  quit%n%n");
            } else if (action.equals("add")) {
                // Ask the user for two numbers to add
                System.out.print("First number: ");
                int num1 = in.nextInt();
                System.out.print("Second number: ");
                int num2 = in.nextInt();
                // Flush new line 
                in.nextLine();
                // Show the results
                System.out.println("Result: " + (num1 + num2));
            } else if (action.equals("subtract")) {
                // Ask the user for two numbers to subtract
                System.out.print("First number: ");
                int num1 = in.nextInt();
                System.out.print("Second number: ");
                int num2 = in.nextInt();
                // Flush new line 
                in.nextLine();
                // Show the results
                System.out.println("Result: " + (num1 - num2));
            } else if (action.equals("multiply")) {
                // Ask the user for two numbers to add
                System.out.print("First number: ");
                int num1 = in.nextInt();
                System.out.print("Second number: ");
                int num2 = in.nextInt();
                // Flush new line 
                in.nextLine();
                // Show the results
                System.out.println("Result: " + (num1 * num2));
            } else if (action.equals("divide")) {
                // Ask the user for two numbers to divide
                System.out.print("First number: ");
                int num1 = in.nextInt();
                System.out.print("Second number: ");
                int num2 = in.nextInt();
                // Flush new line 
                in.nextLine();
                // Check if num2 is not 0
                if (num2 == 0) {
                    System.out.print("Invalid Operation. ");
                } else {
                    System.out.println("Result: " + (num1 / num2));
                }
            } else if (action.equals("reverse")) {
                // Ask the user for a string to reverse
                System.out.print("Enter text: ");
                String text = in.nextLine().trim();
                // Reverse using string builder
                text = new StringBuilder(text).reverse().toString();
                // Output reversed string
                System.out.println("\n" + text);
            } else if (action.equals("random")) {
                // Ask the user for the range of the random number
                System.out.print("Minimum: ");
                int min = in.nextInt();
                System.out.print("Maximum: ");
                int max = in.nextInt();
                // Flush new line 
                in.nextLine();
                if (min > max) { 
                    System.out.print("Invalid Operation. ");
                } else {
                    Random rnd = new Random();
                    System.out.println("Random number: " + (rnd.nextInt(min,max + 1)));
                }
            } else if( action.equals("quit")) {
                continue;
            }else {
                System.out.print("Invalid command. ");
            }
        } while (!action.equals("quit"));
        // Close loop
        System.out.println("Goodbye!");
        // Close scanner
        in.close();
    }
}
