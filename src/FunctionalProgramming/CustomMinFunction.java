package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.in;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> minNumber = arr -> Arrays.stream(arr)
                .mapToInt(e -> e)
                .min()
                .getAsInt();

        Integer myMinNumber = minNumber.apply(numbers);
        System.out.println(myMinNumber);
    }
}
