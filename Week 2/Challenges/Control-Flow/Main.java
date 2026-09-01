public class Main {
    public static void main(String[] args) {
        int score = 75;
        char grade = 'B';

        if (score >= 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        System.out.print("Grade: ");
        if (score >= 90)  {
            System.out.println("A");
            grade = 'A';
        } else if (score >= 75){
            System.out.println("B");
            grade = 'B';
       } else if (score >= 60){
            System.out.println("C");
            grade = 'C';
       } else {
            System.out.println("D");
            grade = 'D';
       }
    }
}
