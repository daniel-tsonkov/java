package DataTypesVariables;

import  java.util.Scanner;

public class a11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberSnowballs = Integer.parseInt(scanner.nextLine());
        int tempSnowballSnow = 0;
        int tempSnowballTime = 0;
        int tempSnowballQuality = 0;

        double maxSnowballValue = 0;

        for (int i = 0; i < numberSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double myresult = Math.pow((snowballSnow / snowballTime), snowballQuality);

            if(myresult > maxSnowballValue) {
                maxSnowballValue = myresult;
                tempSnowballSnow = snowballSnow;
                tempSnowballTime = snowballTime;
                tempSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",tempSnowballSnow, tempSnowballTime, maxSnowballValue, tempSnowballQuality);
    }
}
