public class Main {
    public static void main(String[] args) {
        System.out.print("For Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        int num = 1;
        System.out.print("While Loop:");
        while (num <= 5) {
            System.out.print(" " + num++);
        }
        System.out.println();

        num = 1;
        System.out.print("Do-While Loop:");
        do {
            System.out.print( " " + num++);
        } while (num <= 5);
    }
}
