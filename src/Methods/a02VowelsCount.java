package Methods;

import java.util.Scanner;

public class a02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String myString = scanner.nextLine();

        vowelsCount(myString);
    }

    public static void vowelsCount(String aString) {
        String myString = aString.toLowerCase();
        int counter = 0;
        for (int i = 0; i < myString.length(); i++) {
            char myChar = myString.charAt(i);

            if (myChar == 'a' || myChar == 'e' || myChar == 'i' || myChar == 'o' || myChar == 'u' || myChar == 'y') {
                counter++;
            }
        }
        System.out.print(counter);
    }
}
