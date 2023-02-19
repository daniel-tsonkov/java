package ZadaciIzpit;

import java.util.Scanner;

public class ZadDve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double teniska = Integer.parseInt(scanner.nextLine());
        int procent = Integer.parseInt(scanner.nextLine());
        double shorti = teniska * 0.75;
        double chorapi = shorti * 0.2;
        double butonki = (teniska + shorti) * 2;

        double obsto = teniska + shorti + chorapi + butonki;
        double sOtsupka = obsto - (obsto * 0.15);

        if(sOtsupka >= procent) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is " + sOtsupka + " lv.");
        }else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", procent - sOtsupka);
        }
    }
}
