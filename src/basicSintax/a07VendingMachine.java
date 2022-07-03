package basicSintax;

import java.util.Scanner;

public class a07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = "";
        Double mySum = 0.0;

        while(true){
            inputString = scanner.nextLine();
            if ( inputString.equals("Start")){
                break;
            }
            double tempSum = Double.parseDouble(inputString);
            if (tempSum == 0.1 || tempSum == 0.2 || tempSum == 0.5 || tempSum == 1 || tempSum == 2) {
                mySum += tempSum;
            }else {
                System.out.println(String.format("Cannot accept %.2f", tempSum));
            }
        }
        while(true){
            inputString = scanner.nextLine();

            if ( inputString.equals("End")){
                System.out.println(String.format("Change: %.2f", mySum));
                break;
            }

            if ( inputString.equals("Nuts") || inputString.equals("Water") || inputString.equals("Crisps") || inputString.equals("Soda") || inputString.equals("Coke")){
                double sumProduct = 0.0;

                switch (inputString) {
                    case "Nuts":
                        sumProduct = 2.0;
                         break;
                    case "Water":
                        sumProduct = 0.7;
                         break;
                    case "Crisps":
                        sumProduct = 1.5;
                         break;
                    case "Soda":
                        sumProduct = 0.8;
                         break;
                    case "Coke":
                        sumProduct = 1.0;
                         break;
                }
                if(mySum - sumProduct >= 0) {
                    System.out.println("Purchased " + inputString);
                    mySum -= sumProduct;
                }else {
                    System.out.println("Sorry, not enough money");
                }
            }else {
                System.out.println("Invalid product");
            }
        }
    }
}
