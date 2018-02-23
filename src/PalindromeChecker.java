import java.util.Scanner;

public class PalindromeChecker {


    public static void main(String[] args){
        String input;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase to check if it is a palindrome: ");
        input = scanner.nextLine();
        System.out.print("The input " + (input.contains(" ") ? "phrase" : "word" )
                + " " + (isPalindrome(input) ? "is" : "is not" ) + " a palindrome");
    }

    public static boolean isPalindrome(String str){
        String word = str.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}