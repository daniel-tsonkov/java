package StaksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split("\\s+");

        ArrayDeque <String> stack = new ArrayDeque<>();

        for (String number : inputNumbers) {
            stack.push(number);
        }

        for (String element : stack) {
            System.out.printf("%s ",stack.pop());
        }
    }
}
