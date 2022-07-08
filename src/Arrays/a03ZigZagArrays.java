package Arrays;

import java.util.Scanner;

public class a03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 1; i <= n; i++) {
            String[] temArray = scanner.nextLine().split(" ");

            if ((i + 1) % 2 == 0) {
                firstArr[i - 1] = temArray[0];
                secondArr[i - 1] = temArray[1];
            } else {
                firstArr[i - 1] = temArray[1];
                secondArr[i - 1] = temArray[0];
            }
        }

        for (String first : firstArr) {
            System.out.print(first + " ");
        }
        System.out.println();

        for (String second : secondArr) {
            System.out.print(second + " ");
        }
    }
}
