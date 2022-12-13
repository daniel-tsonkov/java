package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] myMatrix = new String[rows][cols];

        fillMatrix(myMatrix, scanner);
        String command = scanner.nextLine();

        while (!command.equals("END")) {

            if (!validator(command, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String[] commandPart = command.split("\\s+");
                int row1 = Integer.parseInt(commandPart[1]);
                int col1 = Integer.parseInt(commandPart[2]);
                int row2 = Integer.parseInt(commandPart[3]);
                int col2 = Integer.parseInt(commandPart[4]);

                String tempElement = myMatrix[row1][col1];
                myMatrix[row1][col1] = myMatrix[row2][col2];
                myMatrix[row2][col2] = tempElement;

                printMatrix(myMatrix, rows, cols);
            }

            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] myMatrix, Scanner scanner) {
        for (int rows = 0; rows < myMatrix.length; rows++) {
            myMatrix[rows] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean validator(String command, int rows, int cols) {
        String[] commandPart = command.split("\\s+");

        if (commandPart.length != 5) {
            return false;
        }

        if (!commandPart[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandPart[1]);
        int col1 = Integer.parseInt(commandPart[2]);
        int row2 = Integer.parseInt(commandPart[3]);
        int col2 = Integer.parseInt(commandPart[4]);

        return row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;
    }
}
