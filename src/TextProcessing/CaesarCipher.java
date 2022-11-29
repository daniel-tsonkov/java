package TextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();

        for (char c : text) {
            System.out.print(Character.toString(c + 3));
        }

    }
}
