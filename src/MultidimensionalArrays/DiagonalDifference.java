package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] myMatrix = new int[matrixSize][matrixSize];




        for (int rol = 0; rol < matrixSize; rol++) {

            for (int col = 0; col < matrixSize; col++) {
                myMatrix[rol][col] = scanner.nextInt();
            }
        }

        int sumPrimary = getSumOfPrymary(myMatrix);
        int sumSecondary = getSumOfSecondary(myMatrix);

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumOfSecondary(int[][] myMatrix) {
        int secondaryDiagonal = 0;
        for (int i = myMatrix.length - 1; i >= 0; i--) {
            secondaryDiagonal += myMatrix[myMatrix.length - 1 - i][i];
        }
        return  secondaryDiagonal;
    }

    private static int getSumOfPrymary(int[][] myMatrix) {
        int primaryDiagonal = 0;
        for (int i = 0; i < myMatrix.length; i++) {
            primaryDiagonal += myMatrix[i][i];
        }
        return primaryDiagonal;
    }
}
