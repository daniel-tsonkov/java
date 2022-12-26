package SetsAndMap;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

String[] input = scanner.nextLine().split("\\s+");
        int sizeFirstSet = Integer.parseInt(input[0]);
        int sizeSecondSet = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeFirstSet; i++) {
            int digit = Integer.parseInt(scanner.nextLine());
            firstSet.add(digit);
        }

        for (int i = 0; i < sizeSecondSet; i++) {
            int digit = Integer.parseInt(scanner.nextLine());
            secondSet.add(digit);
        }

        Set<Integer> dublicatedElements = new LinkedHashSet<>();
        for(Integer element : firstSet) {
            if (secondSet.contains(element)) {
                dublicatedElements.add(element);
            }
        }

        dublicatedElements.forEach(e -> System.out.print(e + " "));
    }
}
