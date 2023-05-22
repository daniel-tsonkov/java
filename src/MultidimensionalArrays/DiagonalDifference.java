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

        int primariDiagonal = getPrimaryDiagonalValue(myMatrix);
        int secondaryDiagonal = getSecondaryDiagonalValue(myMatrix);

        System.out.println(Math.abs(primariDiagonal - secondaryDiagonal));

    }

    private static int getPrimaryDiagonalValue(int[][] myMatrix) {
        int primariDiagonal = 0;
        for (int i = 0; i < myMatrix.length; i++) {
            primariDiagonal +=  myMatrix[i][i];
        }
        return primariDiagonal;
    }

    private static int getSecondaryDiagonalValue(int[][] myMatrix) {
        int secondaryDiagonal = 0;
        for (int i = 0; i < myMatrix.length; i++) {
            secondaryDiagonal +=  myMatrix[myMatrix.length - i - 1][i];
        }
        return secondaryDiagonal;
    }
}
