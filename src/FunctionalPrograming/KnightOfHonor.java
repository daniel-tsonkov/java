package FunctionalPrograming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] names = scanner.nextLine().split("\\s+");

        Consumer<String> printName = name -> System.out.println("Sir" + name);
        Arrays.stream(names).forEach(printName);
    }
}
