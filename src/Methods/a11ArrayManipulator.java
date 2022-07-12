package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class a11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] myArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] commands = scanner.nextLine().split(" ");

        switch (commands[0]) {
            case "exchange" :
                break;
            case "max" :
                break;
            case "min" :
                break;
            case "first" :
                break;
            case "last" :
                break;
        }
    }
}
