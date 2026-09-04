import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Print todays date
        LocalDate today = LocalDate.now();
        System.out.println("Date: " + today);
        // Print todays year
        System.out.println("Year: " + today.getYear());
        // Print todays month
        System.out.println("Month: " + today.getMonth());
        // Print todays day
        System.out.println("Day: " + today.getDayOfMonth());

        // Ask for the users birth date
        System.out.print("\nEnter your birth date( format YEAR-MONTH-DAY): ");
        // Scanner object for input
        Scanner in = new Scanner(System.in);
        String date = in.nextLine().trim();
        // Parse user's birth date
        LocalDate birthDate = LocalDate.parse(date);
        // Get time between dates
        Period age = Period.between(birthDate, today);
        // Print users age
        System.out.println("\nYou are " + age.getYears() + " years old.");

        // Ask for the users birthday
        System.out.print("\nEnter your birthday( format YEAR-MONTH-DAY): ");
        // Scanner object for input
        date = in.nextLine().trim();
        // Parse date
        LocalDate birthday = LocalDate.parse(date);
        // Add one year to date
        LocalDate nextBirthday = birthday.plusYears(1);
        // Get period of time
        Period timeTillBirthday = Period.between(birthDate, nextBirthday);
        // Print days until birthday
        System.out.println("\nDays until your next birthday: " + timeTillBirthday.getDays());



        // Close scanner input
        in.close();
    }
}
