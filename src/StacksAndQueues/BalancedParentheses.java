package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] brackets = scanner.nextLine().split("");

        label:
        for (String bracket : brackets) {
            if(brackets.length % 2 != 0) {
                System.out.println("NO");
                break label;
            }
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[")) {
                stack.push(bracket);
            } else {
                switch (bracket) {
                    case ")":
                        if (!stack.pop().equals("(")) {
                            System.out.println("NO");
                            break label;
                        }
                        break;
                    case "}":
                        if (!stack.pop().equals("{")) {
                            System.out.println("NO");
                            break label;
                        }
                        break;
                    case "]":
                        if (!stack.pop().equals("[")) {
                            System.out.println("NO");
                            break label;
                        }
                        break;
                }
            }
        }

        if(brackets.length % 2 == 0) {
            if(stack.isEmpty()) {
                System.out.println("YES");
            }
        }
    }
}
