package basicSintax;

import java.util.Scanner;

public class a09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int myCount = Integer.parseInt(scanner.nextLine());
        Double totalPrice = 0.0;

        for (int i = 0; i < myCount; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            double days = Double.parseDouble(scanner.nextLine());
            double CapsulesCount = Double.parseDouble(scanner.nextLine());

            System.out.println(String.format("The price for the coffee is: $%.2f", (days * CapsulesCount) * pricePerCapsule));
            totalPrice += ((days * CapsulesCount) * pricePerCapsule);
        }
        System.out.println(String.format("Total: $%.2f", totalPrice));
    }
}
