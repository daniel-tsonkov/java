package FunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class ApplietArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    Function<List<Integer>, List<Integer>> add = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
                    numbers = add.apply(numbers);
                    break;
                case "multiplay":
                    Function<List<Integer>, List<Integer>> multiplay = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
                    numbers = multiplay.apply(numbers);
                    break;
                case "subtract":
                    Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
