package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class a07MaxSequence {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int tempNumber = 1;
        int maxSequence = 0;
        int digit = 0;

        int[] myArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < myArray.length - 1;) {
            int j = i + 1;
            for (; j < myArray.length; j++) {
                if(myArray[i] == myArray[j]) {
                    tempNumber++;
                } else {
                    break;
                }
            }
            if (tempNumber > maxSequence) {
                maxSequence = tempNumber;
                digit = myArray[i];
            }
            tempNumber = 1;
            i = j;
        }
        for (int j = 0; j < maxSequence; j++) {
            System.out.print(digit + " ");
        }

    }
}
