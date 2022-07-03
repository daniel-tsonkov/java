package basicSintax;

import java.util.Scanner;

public class a04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int totalSum = 0;

        for (int i = startNumber; i <= endNumber; i++) {
            totalSum += i;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Sum: " + totalSum);
    }
}
