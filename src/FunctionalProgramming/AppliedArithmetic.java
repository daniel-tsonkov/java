package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(num -> num + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplay = list -> list.stream().map(num -> num * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> substract = list -> list.stream().map(num -> num - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(num -> System.out.print(num + " "));

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplay.apply(numbers);
                    break;
                case "subtract":
                    numbers = substract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
