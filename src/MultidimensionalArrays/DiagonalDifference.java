package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] myMatrix = new int[sizeOfMatrix][sizeOfMatrix];


        for (int i = 0; i < sizeOfMatrix; i++) {
            String[] rowValues = scanner.nextLine().split("\\s+");
            for (int j = 0; j < sizeOfMatrix; j++) {
                myMatrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }

        getDiagonalValue(myMatrix);
    }

    private static void getDiagonalValue(int[][] myMatrix) {

    }
}
