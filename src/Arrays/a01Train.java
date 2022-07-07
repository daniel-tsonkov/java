package Arrays;

import java.util.Scanner;

public class a01Train {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        int numberLines = scanner.nextInt();//Integer.parseInt(scanner.nextLine());
        int mySum = 0;

        int[] myArray = new int[numberLines];

        for (int i = 0; i < numberLines; i++) {
            int oneLine = scanner.nextInt();//Integer.parseInt(scanner.nextLine());
            myArray[i] = oneLine;
        }

        for (int number : myArray)
        {
            mySum += number;
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.print(mySum);
    }
}
