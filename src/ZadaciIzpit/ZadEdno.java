package ZadaciIzpit;

import java.util.Scanner;

public class ZadEdno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maznini = Integer.parseInt(scanner.nextLine());
        int proteini = Integer.parseInt(scanner.nextLine());
        int vaglehidrati = Integer.parseInt(scanner.nextLine());
        int kalorii = Integer.parseInt(scanner.nextLine());
        int voda = Integer.parseInt(scanner.nextLine());

        double gramoveMaznini = ((kalorii * (maznini * 1.0) / 100) / 9);
        double gramoveProtein = ((kalorii * (proteini * 1.0) / 100) / 4);
        double gramoveVaglehidrati = ((kalorii * (vaglehidrati * 1.0) / 100) / 4);

        double tegloHrana = gramoveMaznini + gramoveProtein + gramoveVaglehidrati;
        double zaEdinGram = kalorii / tegloHrana;

        double bezVoda = (zaEdinGram * (100 - voda)) / 100 ;
        System.out.printf("%.4f", bezVoda);
    }
}
