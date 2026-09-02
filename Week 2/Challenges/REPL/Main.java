import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variable to store the balance of the account
        double balance = 0;
        // Create new scanner object for input
        Scanner in = new Scanner(System.in);
        // Variable for the command they want
        int decision;
        // Variable to store the amount to be deposited
        double transaction;
        do {
            // Print actions
            System.out.println("\nPlease enter a number to realize an action");
            System.out.printf("1. Check Balance %n2. Deposit%n3. Withdraw %n4. Exit%n");
            // Read decision from input
            decision = in.nextInt();
            switch (decision) {
                // Print current balance
                case 1:
                    System.out.printf("The current balance is: $%.2f%n", balance);
                    break;
                // Add deposit amount into balance
                case 2:
                    do {
                        // Ask for amount of deposit
                        System.out.print("Please input an amount to deposited: $");
                        // Save amount 
                        transaction = in.nextDouble();
                        // Verify amount is not lower than 0
                        if (transaction < 0) {
                            System.out.print("Invalid amount. ");
                        // Print new balance
                        } else {
                            balance += transaction;
                            System.out.printf("Your new current balance is $%.2f%n", balance);
                        }
                    } while (transaction < 0);
                    break;
                // Withdraw amount from balance
                case 3: 
                    do {
                        // Ask for amount of withdraw
                        System.out.print("Please input an amount to withdrawn: $");
                        // Save amount 
                        transaction = in.nextDouble();
                        // Verify amount is not lower than 0
                        if (transaction < 0) {
                            System.out.print("Invalid amount. ");
                        // Verify there is no overdraft
                        }  else if (0 > balance - transaction) {
                            System.out.print("Invalid amount, transaction overdrafts. ");
                        // Print new balance
                        } else {
                            balance -= transaction;
                            System.out.printf("Your new current balance is $%.2f%n", balance);
                        }
                    } while (transaction < 0 || 0 > balance - transaction);
                    break;
                // Exit from bank
                case 4:
                    System.out.println("Thank you for using our bank");
            }
        } while(decision != 4);
        in.close();
    }
}
