package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[size][size];

        if (type.equals("A")) {
            fillPatternA(matrix);
        } else {
            fillPatternB(matrix);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int fillValue = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = fillValue;
                fillValue++;
            }
        }
    }

    private static void fillPatternB(int[][] matrix) {
        int fillValue = 1;

        for (int i = 0; i < matrix.length; i++) {
            if(i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = fillValue;
                    fillValue++;
                }
            }else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = fillValue;
                    fillValue++;
                }
            }
        }
    }
}
