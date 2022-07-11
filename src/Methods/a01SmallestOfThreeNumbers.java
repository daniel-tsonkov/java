package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class a01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] myArray = new int[3];

        for (int i = 0; i < 3; i++) {
            myArray[i] = Integer.parseInt(scanner.nextLine());
        }

        sortArray(myArray);
    }

    public static  void sortArray(int...numbers) {
        Arrays.sort(numbers);
        System.out.print(numbers[0]);
    }
}
