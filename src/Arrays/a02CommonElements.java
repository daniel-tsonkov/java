package Arrays;

import java.util.Scanner;

public class a02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");//new int{}
        String[] seccondArray = scanner.nextLine().split(" ");

        for (String wordOne : firstArray) {
            for (String wordTwo : seccondArray) {
                if (wordTwo.equals(wordOne)) {
                    System.out.print(wordTwo + " ");
                }
            }
        }
    }
}
