package Methods;

import java.util.Scanner;

public class a07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        printMatrix(sizeMatrix);
    }

    public static void printMatrix(int sizeMatrix) {
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                System.out.print(sizeMatrix + " ");
            }
            System.out.println();
        }
    }
}
