package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class a08MagicSum {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        String[] myArray = scanner.nextLine().split(" ");
        int[] myArrayInt = Arrays.stream(myArray).mapToInt(Integer::parseInt).toArray();
        int mySum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < myArray.length - 1; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if ((myArrayInt[i] + myArrayInt[j]) == mySum) {
                    System.out.println(myArrayInt[i] + " " + myArrayInt[j]);
                }
            }
        }
    }
}
