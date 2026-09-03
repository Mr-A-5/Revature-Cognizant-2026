import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        // Variables for validation
        int numOfCharacters = 0;
        int numOfVowels = 0;
        int numOfConsonants = 0;
        int numOfDigits = 0;
        int numOfSpaces = 0;

        // Ask the user for a password
        System.out.printf("Please input a sentence to be analyzed: ");   
        String sentence = in.nextLine();
        // Go through each character and check their class
        for (int i = 0;i < sentence.length(); i++) {
            // Check if the current character from the string is digit
            if (Character.isDigit(sentence.charAt(i))) {
                numOfDigits++;
            }
            // Check if the current character from the string is space
            if (Character.isSpaceChar(sentence.charAt(i))) {
                numOfSpaces++;
            }
            // Check if the current character from the string is a letter
            if (Character.isLetter(sentence.charAt(i))) {
                // Check if character at index i is a vowel
                if ("aeiou".contains(sentence.substring(i,i +1).toLowerCase())) {
                    numOfVowels++;
                
                } else {
                    numOfConsonants++;
                }
            }
        }
        // Number of characters is simply the size of the string
        numOfCharacters = sentence.length();
        // Output results
        System.out.printf("%nCharacters: %d%n" + //
                        "Vowels: %d%n" + //
                        "Consonants: %d%n" + //
                        "Digits: %d%n" + //
                        "Spaces: %d", numOfCharacters, numOfVowels, numOfConsonants, numOfDigits, numOfSpaces);
        // Close Scanner
        in.close();
    }
}
