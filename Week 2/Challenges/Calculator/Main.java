import java.text.ListFormat.Style;

public class Main {
    public static void main(String[] args) {
        double num1 = 7;
        double num2 = 0;
        char operator = '/';
        String again = "y";
        System.out.print("Result: ");
        while (again.equals("y")) {
            if (operator == '+') {
                System.out.printf("%.1f%n",num1 + num2);
            } else if (operator == '-') {
                System.out.printf("%.1f%n", num1 - num2);
            } else if (operator == '/') {
                if ( num2 == 0) {
                    System.out.println("Cannot divide by zero");
                } else { 
                    System.out.printf("%.1f%n",num1 / num2);
                }
            } else if (operator == '*') {
                System.out.printf("%.1f%n",num1 * num2);

            }
            again = "n";
        }
        System.out.print("Thank you for using the calculator.");
    }
}
