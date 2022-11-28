package TextProcessing;

import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        for (String username : data) {
            boolean isValid = true;
            if ((username.length() < 3) || (username.length() > 16)) {
                isValid = false;

            } else {
                for (int i = 0; i < username.length(); i++) {
                    //char symbol = username.toLowerCase().charAt(i);
                    int symbol = username.toLowerCase().charAt(i);

                    if ((symbol >= 48 && symbol <= 57) || (symbol >= 97 && symbol <= 122) || (symbol == 45) || (symbol == 95)) {

                    } else {
                        isValid = false;
                    }
                }
            }

            if (isValid) {
                System.out.printf("%s%n", username);
            }
        }
    }
}
