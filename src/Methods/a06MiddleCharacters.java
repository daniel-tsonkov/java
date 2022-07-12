package Methods;

import java.util.Scanner;

public class a06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String myString = scanner.nextLine();

        System.out.print(middleChars(myString));
    }

    public static String middleChars(String myString) {
        if (myString.length() % 2 == 0) {
            return (myString.charAt(myString.length() / 2 - 1) + "" + (myString.charAt(myString.length() / 2)));
        } else {
            return (myString.charAt(myString.length() / 2) + "");
        }
    }
}
