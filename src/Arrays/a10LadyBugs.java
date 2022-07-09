package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class a10LadyBugs {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        int arrayLenght = Integer.parseInt(scanner.nextLine());
        int[] myArray = new int[arrayLenght];
        int[] bugs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < bugs.length; i++) {
            myArray[bugs[i]] = 1;
        }

        String[] myCommand = scanner.nextLine().split(" ");
        while (myCommand[0].equals("end")) {
            if (Integer.parseInt(myCommand[0]) <= 0 || Integer.parseInt(myCommand[0]) < myArray.length) {

            }
        }
    }
}
