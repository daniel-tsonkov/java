package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class a05TopIntegers {
    public static  void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        String[] myArray = scanner.nextLine().split(" ");
        int[] myArrayInt = Arrays.stream(myArray).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < myArrayInt.length - 1; i++) {
            boolean tempValue = true;

            for (int j = i + 1; j < myArrayInt.length; j++) {
                if (myArrayInt[i] < myArrayInt[j]) {
                    tempValue = false;
                }
            }
            if (tempValue) {
                System.out.print(myArrayInt[i] + " ");
            }
        }
        System.out.print(myArrayInt[myArrayInt.length - 1]);
    }
}
