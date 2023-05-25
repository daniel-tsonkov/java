package SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String phoneNumber = phonebook.get(name);
            if(phonebook.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phoneNumber);
            }else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
            name = scanner.nextLine();
        }
    }
}
