package ZadaciIzpit;

import java.util.Scanner;

public class ZadDve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double shirtPrice = Double.parseDouble(scanner.nextLine());
        double targetPrice = Double.parseDouble(scanner.nextLine());

        double shortsPrice = shirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.2;
        double shoesPrice = (shirtPrice + shortsPrice) * 2;

        double finalPrice = shirtPrice + shortsPrice + socksPrice + shoesPrice;
        double discountedPrice = finalPrice - (finalPrice * 0.15);

        if(discountedPrice >= targetPrice) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", discountedPrice);
        }else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", targetPrice - discountedPrice);
        }
    }
}
