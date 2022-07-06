package Arrays;

import java.util.Scanner;

public class a06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i < 97 + rotation; i++) {
            //
            for (int j = 97; j < 97 + rotation; j++) {
                //
                for (int k = 97; k < 97 + rotation; k++) {
                    System.out.printf("%c%c%c", i, j, k);
                    System.out.println();
                }
            }
        }
    }
}
