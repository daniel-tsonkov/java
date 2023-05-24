package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sets = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(sets[0]);
        int m = Integer.parseInt(sets[1]);

        Set<String> numbeers1 = new LinkedHashSet<>();
        Set<String> numbeers2 = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            numbeers1.add(scanner.nextLine());
        }

        for (int i = 0; i < m; i++) {
            numbeers2.add(scanner.nextLine());
        }

        numbeers1.retainAll(numbeers2);
        String result = String.join(" ", numbeers1);
        System.out.println(result);
    }
}
