package Razni;

import java.util.Arrays;
import java.util.Scanner;

public class unicPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrlenght = (scanner.nextLine().split(" "));
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arrlenght.length; i++) {
            for (int j = i + 1; j < arrlenght.length; j++) {
                if (Integer.parseInt(arrlenght[i]) + Integer.parseInt(arrlenght[j]) == number) {
                    System.out.println(arrlenght[i] + " " + arrlenght[j]);
                }
            }
        }
    }

    static void asd() {

    }
}
