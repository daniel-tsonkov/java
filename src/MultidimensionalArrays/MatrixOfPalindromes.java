package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] myMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            char leter = (char)(row + 97);
            for (int col = 0; col < cols; col++) {

                char palindom = (char)(row + col + 97);
                String word = "" + leter + palindom + leter;
                myMatrix[row][col] = word;
            }

        }

        for (int rol = 0; rol < rows; rol++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(myMatrix[rol][col] + " ");
            }
            System.out.println();
        }
    }
}
