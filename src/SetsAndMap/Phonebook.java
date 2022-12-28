package SetsAndMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String data = scanner.nextLine();

        while (!data.equals("search")) {
            String name = data.split("-")[0];
            String phoneNumer = data.split("-")[1];
            phonebook.put(name, phoneNumer);
            data = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }

            name = scanner.nextLine();
        }
    }
}
