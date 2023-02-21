package FunctionalPrograming;

import java.util.Scanner;

public class TronConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }

        int parisRow = 0;
        int parisCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        while (true) {
            String[] command = scanner.nextLine().split("\\s+");
            String direction = command[0];
            int enemyRow = Integer.parseInt(command[1]);
            int enemyCol = Integer.parseInt(command[2]);

            field[parisRow][parisCol] = '-';
            field[enemyRow][enemyCol] = 'S';

            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < field.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < field.length) {
                        parisCol++;
                    }
                    break;
            }
            if(energy <= 0) {
                parisDead(field, parisRow, parisCol);
                break;
            }

            if(field[parisRow][parisCol] == 'S'){
                energy -=2;
                if(energy <= 0) {
                    parisDead(field, parisRow, parisCol);
                    break;
                }else {
                    field[parisRow][parisCol] = '-';
                }
            }else if(field[parisRow][parisCol] == 'H'){
                field[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                printField(field);
                break;
            }
        }
    }

    public static void parisDead(char[][] field, int parisRow, int pariCol) {
            field[parisRow][pariCol] = 'X';
            System.out.printf("Paris died at %d;%d./n", parisRow, pariCol);
            printField(field);
    }

    private static void printField(char[][] field){
        for (int rows = 0; rows < field.length; rows++) {
            for (int cows = 0; cows < field[rows].length; cows++) {
                System.out.print(field[rows][cows]);
            }
            System.out.println();
        }
    }
}
