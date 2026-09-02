import java.util.Scanner;

public class Main {
     static void main(String[] args) {
        // Create scanner object for input
        Scanner in = new Scanner(System.in); 
        // Variables to store scores
        int[] lst = new int[5];
        int max = 0;
        int min = 0;
        int total = 0;
        // Ask for input
        System.out.print("Enter your 5 test scores with spaces in between: ");
        // Populate initial values
        lst[0] = in.nextInt();
        total += lst[0];
        min = lst[0];
        max = lst[0];
        // Loop through input
        for (int i = 1; i < 5; i++) {
            lst[i] = in.nextInt();
            total += lst[i];
            if (min > lst[i]) { 
                min = lst[i];
            } 
            if (max < lst[i]) {
                max = lst[i];
            }
        }
        // Print new line
        System.out.println();
        // Print results
        System.out.printf("Total: %d%n", total);
        System.out.printf("Average: %d%n", total / 5);
        System.out.printf("Highest: %d%n", max);
        System.out.printf("Lowest: %d%n%n", min);

        // Print values based on scores
        System.out.println("Your values were:");
        for (int i = 0;i < 5; i++) {
            System.out.printf("%d - ", lst[i]);
            if (lst[i] >= 90) {
                System.out.println("A");
            } else if (lst[i] >= 80) {
                System.out.println("B");
            }  else if (lst[i] >= 70) {
                System.out.println("C");
            }  else if (lst[i] >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        }
        in.close();
    }    
}
