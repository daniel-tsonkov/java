package basicSintax;

import java.util.Scanner;

public class a02Division {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int myNumber = Integer.parseInt(scanner.nextLine());
        String dividet = "Not divisible";

        if (myNumber % 2 == 0){
            dividet = "The number is divisible by 2";
        }
        if (myNumber % 3 == 0) {
            dividet = "The number is divisible by 3";
        }
        if (myNumber % 6 == 0) {
            dividet = "The number is divisible by 6";
        }
        if (myNumber % 7 == 0) {
            dividet = "The number is divisible by 7";
        }
        if (myNumber % 10 == 0) {
            dividet = "The number is divisible by 10";
        }

        System.out.println(dividet);
    }
}
