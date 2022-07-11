package Methods;

import java.util.Scanner;

public class a04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String myPassword = scanner.nextLine();

        checkPassword(myPassword);
    }

    public static void checkPassword(String myPassword) {
        int invalidCharacters = 0;
        int digits = 0;
        int checkForSmallLetters = 0;
        int checkForBigLetters = 0;

        if (myPassword.length() < 6 || myPassword.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        for (int i = 0; i < myPassword.length(); i++) {
            if (myPassword.charAt(i) < 48) {
                invalidCharacters = 1;
            }
            if ((myPassword.charAt(i) < 48) || (myPassword.charAt(i) > 57)) {
                if ((myPassword.charAt(i) < 65) || (myPassword.charAt(i) > 90)){
                    if ((myPassword.charAt(i) < 97) || (myPassword.charAt(i) > 122)){
                        invalidCharacters = 1;
                    }
                }

            }
            if ((myPassword.charAt(i) > 48) && (myPassword.charAt(i) <= 57)) {
                digits++;
            }
        }

        if (invalidCharacters == 1) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (digits < 2)  {
            System.out.println("Password must have at least 2 digits");
        }

        if ((digits > 2) && (invalidCharacters == 0) && (myPassword.length() > 6 && myPassword.length() < 10)) {
            System.out.println("Password is valid");
        }
    }
}
