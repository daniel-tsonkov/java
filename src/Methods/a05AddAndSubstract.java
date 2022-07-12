package Methods;

import  java.util.Scanner;

public class a05AddAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        int thirdDigit = Integer.parseInt(scanner.nextLine());

        int sumOfDigits = sumDigit(firstDigit, secondDigit);
        int extractDigit = extractDigits(sumOfDigits, thirdDigit);

        System.out.println(extractDigit);
    }

    public static int sumDigit(int first, int second) {
        return first + second;
    }

    public  static int extractDigits(int first, int second) {
        return first - second;
    }
}
