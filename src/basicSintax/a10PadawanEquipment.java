package basicSintax;

import java.util.Scanner;

public class a10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float amountOfMoney = Float.parseFloat(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        float priceOflightsabers = Float.parseFloat(scanner.nextLine());
        float priceOfRobes = Float.parseFloat(scanner.nextLine());
        float priceOfBelts = Float.parseFloat(scanner.nextLine());
        float mySum = 0.0f;

        mySum = priceOflightsabers * ((float) (Math.ceil(countOfStudents) * 1.1)) + (countOfStudents * priceOfRobes) + (priceOfBelts * (countOfStudents - (countOfStudents / 6)));

        //System.out.println(priceOflightsabers * (float) (Math.ceil((countOfStudents) * 1.1)));
        float allLightsabers = priceOflightsabers * (float) (Math.ceil((countOfStudents) * 1.1));
        //System.out.println(countOfStudents * priceOfRobes);
        float allRobes = countOfStudents * priceOfRobes;
        //System.out.println(priceOfBelts * (countOfStudents - (countOfStudents / 6)));
        float allBelts = priceOfBelts * (countOfStudents - (countOfStudents / 6));

        mySum = allLightsabers + allRobes + allBelts;
        //System.out.println(mySum);
        if (amountOfMoney - mySum >= 0){
            System.out.println(String.format("The money is enough - it would cost %.2flv.", mySum));
        }else {
            System.out.println(String.format("George Lucas will need %.2flv more.", (mySum - amountOfMoney)));
        }
    }
}
