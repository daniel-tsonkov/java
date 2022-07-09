package Arrays;

import java.util.Scanner;

public class a04ArrayRotation {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        String[] myArray = scanner.nextLine().split(" ");
        int numberOfRotation = Integer.parseInt(scanner.nextLine());
        String[] temArray = new String[myArray.length];

        for (int j = 0; j < numberOfRotation; j++) {
            for (int i = 0; i < myArray.length; i++) {
                if (i + 1 == myArray.length) {
                    temArray[i] = myArray[0];
                } else {
                    temArray[i] = myArray[i + 1];
                }
            }
            for (int i = 0; i < myArray.length; i++) {
                myArray[i] = temArray[i];
            }
        }

        for (String digit : myArray) {
            System.out.print(digit + " ");
        }
    }
}
