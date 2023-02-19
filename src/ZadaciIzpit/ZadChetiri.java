package ZadaciIzpit;

import java.util.Scanner;

public class ZadChetiri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double kilometers = Double.parseDouble(scanner.nextLine());
        double sumKM = kilometers;

        int percent;

        for (int i = 0; i < days; i++) {
            System.out.println(i);
            percent = Integer.parseInt(scanner.nextLine());
            sumKM = sumKM + (sumKM / 100 * percent);
            kilometers = kilometers + sumKM;
        }
        //kilometers = Math.ceil(kilometers);
        //System.out.println(obshto);
        if(kilometers < 1000){
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", 1000 - kilometers);
        }else{
            System.out.printf("You've done a great job running %.0f more kilometers!", kilometers - 1000);
        }
    }
}
