package StaksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallestNumber = 0;
        boolean isTrue = false;

        //String[] commandNumber = scanner.nextLine().split("//s+");
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
            smallestNumber = stack.peek();
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }


        for (Integer number : stack) {
            if (number < smallestNumber) {
                smallestNumber = number;
            }
            if (number == x) {
                isTrue = true;
            }
        }
        if (isTrue) {
            System.out.println("true");
        } else if (stack.size() == 0) {
            System.out.println("0");
        } else {
            System.out.println(smallestNumber);
        }
    }
}
