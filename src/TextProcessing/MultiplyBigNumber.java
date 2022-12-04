package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] number = scanner.nextLine().toCharArray();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int rest = 0;
        String result = "";

        for (int i = number.length - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(number[i]));

            if ((digit * multiplier + rest) < 10) {
                result += digit * multiplier + rest;
                rest = 0;

            } else {
                result += (digit * multiplier + rest) % 10;
                rest = (digit * multiplier + rest) / 10;
            }
        }
        if (rest != 0){
            result += rest;
        }
        char[] resultarray = result.toCharArray();
        for (int i = resultarray.length - 1; i >= 0; i--) {
            System.out.print(resultarray[i]);
        }
    }
}
