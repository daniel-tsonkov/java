package TextProcessing;

import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        for (String username : data) {
            boolean isValid = true;
            if ((username.length() <= 3) || (username.length() >= 16)) {
                isValid = false;
            }

            for (int i = 0; i < username.length(); i++) {
                //char symbol = username.toLowerCase().charAt(i);
                int symbol = username.toLowerCase().charAt(i);

                if (symbol >= 48 && symbol <= 122) {
                    if (symbol >= 58 && symbol <= 96) {
                        isValid = false;
                        break;
                        if (symbol != 45 || symbol != 95) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            if (isValid) {
                System.out.printf("%s%n", username);
            }
        }
    }
}
