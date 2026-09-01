public class Main {
    public static void main(String[] args) {
        // Integers used during operations
        int a = 20;
        int b = 10;

        // Print the result of addition
        System.out.print("Addition: ");
        System.out.println(a + b);

        // Print the result of subtraction
        System.out.print("Subtraction: ");
        System.out.println(a - b);

        // Print the result of multiplication
        System.out.print("Multiplication: ");
        System.out.println(a * b);

        // Print the result of division
        System.out.printf("Division: ");
        System.out.println(a / b);

        // Check if A is greater than B, store the result, and then print to stout
        boolean aGreaterThanB = a > b;
        System.out.print("Is a greater than b? ");
        System.out.println(aGreaterThanB);

        // Check if A is greater than B and B is greater than 0, store the result, and then print to stout
        boolean bBetween0AndA = aGreaterThanB && b > 0; 
        System.out.print("Is a > b and b > 0? ");
        System.out.println(bBetween0AndA);
        
        
        
        

    }
}
