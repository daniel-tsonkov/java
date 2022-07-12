package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class a11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] myArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] commands = scanner.nextLine().split(" ");

        while (!commands[0].equals("end")) {
            switch (commands[0]) {
                case "exchange" :
                    exchangeIndex(Integer.parseInt(commands[1]), myArray);
                    break;
                case "max" :
                    maxEvenOdd(commands[1], myArray);
                    break;
                case "min" :
                    minEvenOdd(commands[1], myArray);
                    break;
                case "first" :
                    firstTwo(commands[2], myArray);
                    break;
                case "last" :
                    lastTwo(commands[2], myArray);
                    break;
            }
            commands = scanner.nextLine().split(" ");
        }
    }

    public static void exchangeIndex(int index, int...newArray) {
        if (index > newArray.length) {
            System.out.print("Invalid index");
        } else {
            System.out.print("[");
            for (int i = index; i < newArray.length; i++) {
                System.out.print(newArray[i] + ", ");
            }
            for (int i = 0; i < newArray.length / 2 - 1; i++) {
                if (newArray[i] != index) {
                    System.out.print(newArray[i]);
                } else {
                    System.out.print(newArray[i] + ", ");
                }
            }
            System.out.print("]");
        }
    }

    public static void maxEvenOdd(String evenOdd, int...newArray) {
        int result = 0;
        int indexOfElement = 0;

        switch (evenOdd) {
            case "even": //нечетно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 != 0 && newArray[i] > result) {
                        result = newArray[i];
                        indexOfElement = i;
                    }
                }
                break;
            case "odd": //четно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 == 0 && newArray[i] > result) {
                        result = newArray[i];
                        indexOfElement = i;
                    }
                }
                break;
        }

        if (result == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(indexOfElement);
        }
    }

    public static void minEvenOdd(String evenOdd, int...newArray) {
        int result = 0;
        int indexOfElement = 0;

        switch (evenOdd) {
            case "even": //нечетно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 != 0 && newArray[i] < result) {
                        result = newArray[i];
                        indexOfElement = i;
                    }
                }
                break;
            case "odd": //четно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 == 0 && newArray[i] < result) {
                        result = newArray[i];
                        indexOfElement = i;
                    }
                }
                break;
        }

        if (result == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(indexOfElement);
        }
    }

    public static void firstTwo(String oddOrEven, int...newArray) {
        int firstDigit = 0;
        int secondDigit = 0;
        int sumOfDigit = 0;

        switch (oddOrEven) {
            case "even": //нечетно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 == 0 && sumOfDigit != 2) {
                        if (sumOfDigit == 0) {
                            firstDigit = newArray[i];
                            sumOfDigit++;
                        } else {
                            secondDigit = newArray[i];
                            sumOfDigit++;
                        }
                    }
                }
                break;
            case "odd": //нечетно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 != 0 && sumOfDigit != 2) {
                        if (sumOfDigit == 0) {
                            firstDigit = newArray[i];
                            sumOfDigit++;
                        } else {
                            secondDigit = newArray[i];
                            sumOfDigit++;
                        }
                    }
                }
                break;
        }
        System.out.print("[" + firstDigit + " " + secondDigit + "]");
    }

    public static void lastTwo(String oddOrEven, int...newArray) {
        int firstDigit = 0;
        int secondDigit = 0;
        int sumOfDigit = 0;

        switch (oddOrEven) {
            case "even": //нечетно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 == 0 && sumOfDigit != 2) {
                        if (sumOfDigit == 0) {
                            firstDigit = newArray[i];
                            sumOfDigit++;
                        } else {
                            secondDigit = newArray[i];
                            sumOfDigit++;
                        }
                    }
                }
                break;
            case "odd": //нечетно
                for (int i = 0; i < newArray.length; i++) {
                    if (newArray[i] % 2 != 0 && sumOfDigit != 2) {
                        if (sumOfDigit == 0) {
                            firstDigit = newArray[i];
                            sumOfDigit++;
                        } else {
                            secondDigit = newArray[i];
                            sumOfDigit++;
                        }
                    }
                }
                break;
        }
        System.out.print("[" + firstDigit + " " + secondDigit + "]");
    }
}
