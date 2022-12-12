package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] patern = scanner.nextLine().split(", ");
        int size = Integer.parseInt(patern[0]);
        int[][] myMatrix = new int[size][size];

        if (patern[1].equals("A")) {
            fillMatrixPatternA(myMatrix);

        }else {
            fillMatrixPatternB(myMatrix);
        }
        
        printMatrix(myMatrix);
    }

    private static void printMatrix(int[][] myMatrix) {
        for (int[] matrix : myMatrix) {
            for (int col = 0; col < myMatrix.length; col++) {
                System.out.print(matrix[col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternA(int[][] myMatrix) {
        int numberInCell = 1;
        for (int col = 0; col < myMatrix.length; col++) {
            for (int row = 0; row < myMatrix.length; row++) {
                myMatrix[row][col] = numberInCell;
                numberInCell++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] myMatrix) {
        int numberInCell = 1;

        for (int col = 0; col < myMatrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < myMatrix.length; row++) {
                    myMatrix[row][col] = numberInCell;
                    numberInCell++;
                }
            } else {
                for (int row = myMatrix.length - 1; row >= 0 ; row--) {
                    myMatrix[row][col] = numberInCell;
                    numberInCell++;
                }
            }
        }
    }
}
