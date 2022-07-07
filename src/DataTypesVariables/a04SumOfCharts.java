package DataTypesVariables;

import  java.util.Scanner;

public class a04SumOfCharts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberChars = Integer.parseInt(scanner.nextLine());
        int mySum = 0;

        for (int i = 0; i < numberChars; i++) {
            int charToInt = scanner.next().charAt(0);
            mySum += charToInt;
        }

        System.out.println("The sum equals: " + mySum);
    }
}
