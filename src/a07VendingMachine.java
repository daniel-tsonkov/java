import java.util.Scanner;

public class a07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = "";
        Double mySum = 0.0;
        double tempSum1 = 0.0;

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
                break;
            }

            if ( inputString.equals("Nuts") || inputString.equals("Water") || inputString.equals("Crisps") || inputString.equals("Soda") || inputString.equals("Coke")){
                tempSum1 = mySum;

                switch (inputString) {
                    case "Nuts":
                         mySum -= 2.0;
                         break;
                    case "Water":
                         mySum -= 0.7;
                         break;
                    case "Crisps":
                         mySum -= 1.5;
                         break;
                    case "Soda":
                         mySum -= 0.8;
                         break;
                    case "Coke":
                         mySum -= 1.0;
                         break;
                }
                if(mySum >= 0) {
                    System.out.println("Purchased " + inputString);
                }else {
                    System.out.println("Sorry, not enough money");
                    System.out.println(String.format("Change: %.2f", tempSum1));
                    break;
                }
            }else {
                System.out.println("Invalid product");
            }
        }
    }
}
