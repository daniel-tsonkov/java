package StacksAndQueues;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(stack::push);

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if(stack.contains(x)) {
            System.out.println("true");
        }else{
            System.out.println(Collections.min(stack));
        }

        if(stack.isEmpty()) {
            System.out.println("0");
        }
    }
}
