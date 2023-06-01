package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        Predicate<Integer> checkIsDivisible = num -> num % n == 0;
        List<Integer> toRemove = numbers.stream().filter(e -> checkIsDivisible.test(e)).collect(Collectors.toList());

        for(Integer num : toRemove) {
            numbers.remove(num);
        }

        numbers.forEach((e -> System.out.print(e + " ")));
    }
}
