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
            Double tempSum = Double.parseDouble(inputString);
            if (tempSum == 0.1 || tempSum == 0.2 || tempSum == 0.5 || tempSum == 1 || tempSum == 2) {
                mySum += tempSum;
            }else {
                System.out.println("Cannot accept " + tempSum);
            }
        }
        System.out.println(mySum);
    }
}
