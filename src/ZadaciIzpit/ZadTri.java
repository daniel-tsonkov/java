package ZadaciIzpit;

import java.util.Scanner;

public class ZadTri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tanciori = Integer.parseInt(scanner.nextLine());
        double tochki = Double.parseDouble(scanner.nextLine());
        String sezon = scanner.nextLine();
        String miasto = scanner.nextLine();

        double nagrada = 0;
        double moneyDancer;

        if(miasto.equals("Bulgaria")) {
            if(sezon.equals("summer")){
                nagrada = (tanciori * tochki) * 0.95;
            } else {
                nagrada = (tanciori * tochki) * 0.92;
            }

        }else {
            if(sezon.equals("summer")){
                nagrada = ((tanciori * tochki) * 1.5) * 0.9;
            } else {
                nagrada = ((tanciori * tochki) * 1.5) * 0.85;
            }
        }
        double charity = nagrada * 0.75;
        nagrada = nagrada - charity;
        moneyDancer = nagrada / tanciori;
        System.out.printf("Charity - %.2f%n", charity);
        System.out.printf("Money per dancer - %.2f", moneyDancer);
    }
}
