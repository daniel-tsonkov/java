package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        /*for (String word : strings) {
            print.accept(word);
        }*/

        Consumer<String> print = word -> System.out.println(word);
        Arrays.stream(strings).forEach(print);
    }
}
