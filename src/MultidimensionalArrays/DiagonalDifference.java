package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int [][] myMatrix = new int[matrixSize][matrixSize];
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        //String[] entryDate = scanner.nextLine().split("\\s+");

        for (int rol = 0; rol < matrixSize; rol++) {

            for (int col = 0; col < matrixSize; col++) {
                myMatrix[rol][col] = scanner.nextInt();
            }
            //entryDate = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < matrixSize; i++) {
            primaryDiagonal += myMatrix [i][i];
        }

        for (int i = matrixSize - 1; i >= 0 ; i--) {
            secondaryDiagonal += myMatrix[matrixSize - 1 - i][i];
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }
}
