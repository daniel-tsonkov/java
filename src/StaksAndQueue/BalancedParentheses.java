package StaksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openBrackhets = new ArrayDeque<>();
        ArrayDeque<Character> closedBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length() - 1; i++) {
            char currentBracket = input.charAt(i);


        }
    }
}
