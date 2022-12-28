package SetsAndMap;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] chemicalElements = scanner.nextLine().split("\\s+");

            uniqueElements.addAll(Arrays.asList(chemicalElements));
        }

        uniqueElements.forEach(e -> System.out.print(e + " "));
    }
}
