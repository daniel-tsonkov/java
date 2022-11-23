package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<String>> users = new LinkedHashMap<>();

        while (!line.equals("Lumpawaroo")) {
            if (line.contains("|")) {

            } else if (line.contains("->")) {

            }

            line = scanner.nextLine();
        }
    }
}
