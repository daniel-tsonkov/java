package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class a06EqualSums {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        String[] myArray = scanner.nextLine().split(" ");
        int[] myArrayInt = Arrays.stream(myArray).mapToInt(Integer::parseInt).toArray();


    }
}
