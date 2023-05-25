package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> records = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String email = scanner.nextLine();
            String getExtension =  email.substring(email.lastIndexOf('.') + 1).toLowerCase();

            if(!getExtension.equals("us") && !getExtension.equals("uk") && !getExtension.equals("com")){
                records.put(input, email);
            }

            input = scanner.nextLine();
        }

        records.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));
    }
}
