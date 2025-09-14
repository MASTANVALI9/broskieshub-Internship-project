
package project1Learning;

import java.util.Scanner;

public class StringOperations {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== String Operations Program ===");
        System.out.println("This program will:");
        System.out.println("1. Take a string input from you");
        System.out.println("2. Reverse the string using StringBuilder");
        System.out.println("3. Count vowels and consonants");
        System.out.println("4. Check if the string is a palindrome");
        System.out.println("5. Display all results");
        System.out.println("=====================================\n");
        
        // Get string input from user
        String inputString = getStringInput();
        
        // Perform all operations
        String reversedString = reverseString(inputString);
        int[] vowelConsonantCount = countVowelsAndConsonants(inputString);
        boolean isPalindrome = checkPalindrome(inputString);
        
        // Display all results
        displayResults(inputString, reversedString, vowelConsonantCount, isPalindrome);
        
        scanner.close();
    }
    
    /**
     * Gets string input from the user
     * @return the input string
     */
    private static String getStringInput() {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().trim();
        
        if (input.isEmpty()) {
            System.out.println("Empty string entered. Using default: 'Hello World'");
            return "Hello World";
        }
        
        return input;
    }
    
    /**
     * Reverses the string using StringBuilder
     * @param input the original string
     * @return the reversed string
     */
    private static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
    
    /**
     * Counts vowels and consonants in the string using a loop
     * @param input the input string
     * @return array with [vowelCount, consonantCount]
     */
    private static int[] countVowelsAndConsonants(String input) {
        int vowelCount = 0;
        int consonantCount = 0;
        
        // Convert to lowercase for easier comparison
        String lowerInput = input.toLowerCase();
        
        for (int i = 0; i < lowerInput.length(); i++) {
            char ch = lowerInput.charAt(i);
            
            // Check if character is a letter
            if (Character.isLetter(ch)) {
                // Check if it's a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        
        return new int[]{vowelCount, consonantCount};
    }
    
    /**
     * Checks if the string is a palindrome (equals its reverse)
     * @param input the input string
     * @return true if palindrome, false otherwise
     */
    private static boolean checkPalindrome(String input) {
        // Remove spaces and convert to lowercase for comparison
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = reverseString(cleanedInput);
        
        return cleanedInput.equals(reversed);
    }
    
    /**
     * Displays all the results in a formatted manner
     */
    private static void displayResults(String original, String reversed, int[] counts, boolean isPalindrome) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                    RESULTS");
        System.out.println("=".repeat(50));
        
        System.out.println("Original String: \"" + original + "\"");
        System.out.println("Reversed String: \"" + reversed + "\"");
        System.out.println("String Length: " + original.length() + " characters");
        
        System.out.println("\nLetter Analysis:");
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        System.out.println("Total Letters: " + (counts[0] + counts[1]));
        
        System.out.println("\nPalindrome Check:");
        if (isPalindrome) {
            System.out.println("✓ The string IS a palindrome!");
        } else {
            System.out.println("✗ The string is NOT a palindrome.");
        }
        
        System.out.println("=".repeat(50));
    }
}
