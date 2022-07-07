package DataTypesVariables;

import java.util.Scanner;

public class a07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int iteracions = Integer.parseInt(scanner.nextLine());
         int liters = 0;

        for (int i = 0; i < iteracions; i++) {
            int iteration = Integer.parseInt(scanner.nextLine());
            if (liters + iteration <= 255) {
                liters += iteration;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(liters);
    }
}
