package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(size[0]);
        int c = Integer.parseInt(size[1]);

        String[][] palindromMatrix = new String[r][c];

        fillPalindromMatrix(palindromMatrix, r, c);
        printMatrix(palindromMatrix, c);
    }

    private  static void printMatrix(String[][] palindromMatrix, int c) {
        for (String[] ints : palindromMatrix) {
            for (int j = 0; j < c; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void fillPalindromMatrix(String[][] palindromMatrix, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char firstAndThirdChar = (char) ('a' + i);
                char myChar = (char) (firstAndThirdChar + j);
                String myStringInCell = "" + firstAndThirdChar + myChar + firstAndThirdChar;
                palindromMatrix[i][j] = myStringInCell;
            }
        }
    }
}
