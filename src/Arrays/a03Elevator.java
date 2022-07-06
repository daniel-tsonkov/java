package Arrays;

import  java.util.Scanner;

public class a03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int person = Integer.parseInt(scanner.nextLine());
        int maxPerson = Integer.parseInt(scanner.nextLine());

        if (person <= maxPerson) {
            System.out.println(1);
        }else {
            if (person % maxPerson != 0) {
                System.out.println(person / maxPerson + 1);
            }else {
                System.out.println(person / maxPerson);
            }

        }
    }
}
