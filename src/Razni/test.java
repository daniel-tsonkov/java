package Razni;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstS = scanner.nextLine().split(" ");
        String[] secondS = scanner.nextLine().split(" ");

        for (String second : secondS) {
            for (int j = 0; j < firstS.length; j++) {
                if(second.equals(firstS[j])) {
                    System.out.print(second + " ");
                }
            }
        }
    }
}
