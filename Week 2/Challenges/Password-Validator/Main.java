import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        // Variables for validation
        boolean meetsUpperCaseReq;
        boolean meetsLowerCaseReq;
        boolean meetsNumberReq;
        boolean meetsMinSizeReq;
        boolean passwordMeetsReq = false;
        
        // Loop while password is not valid
        do {
            // Set requirements to false initially
            meetsUpperCaseReq = false;
            meetsLowerCaseReq = false;
            meetsNumberReq = false;
            meetsMinSizeReq = false;
            // Ask the user for a password
            System.out.printf("Please input a password. The password must be: %n%nBe at least 8 characters%n" +
            "Contain at least one uppercase letter%n" + 
            "Contain at least one lowercase letter%n" + 
            "Contain at least one number" + 
            "%n%n Password - "
            );   
            String password = in.nextLine().trim();
            // Validate password size
            meetsMinSizeReq = password.length() >= 8;
            // Go through each character and validate them
            for (int i = 0;i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    meetsUpperCaseReq = true;
                }
                if (Character.isLowerCase(password.charAt(i))) {
                    meetsLowerCaseReq = true;
                }
                if (Character.isDigit(password.charAt(i))) {
                    meetsNumberReq = true;
                }
            }
            if ((meetsMinSizeReq && meetsLowerCaseReq) && (meetsUpperCaseReq && meetsNumberReq)) {
                // Password was valid, output it 
                System.out.println("Password accepted!");
                passwordMeetsReq = true;
            } else {
                // Output requirements not met
                System.out.println("Password rejected: ");
                if (meetsMinSizeReq == false) {
                    System.out.println("- Must be at least 8 characters");
                } 
                if (meetsLowerCaseReq == false) {
                    System.out.println("- Must contain a lowercase letter");
                }
                if (meetsUpperCaseReq == false) {
                    System.out.println("- Must contain an uppercase letter");
                }
                if (meetsNumberReq == false) {
                    System.out.println("- Must contain a number");
                }
                System.out.println();
            }
        } while (!passwordMeetsReq);

        // Close Scanner
        in.close();
    }
}
