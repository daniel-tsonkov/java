package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

import static java.lang.System.in;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> apendSir = name -> System.out.println("Sir " + name);

        Arrays.stream(names).forEach(apendSir);
    }
}
