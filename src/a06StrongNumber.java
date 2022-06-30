import java.util.Scanner;

public class a06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int myNumber = Integer.parseInt(scanner.nextLine());
        int myNewNumber = myNumber;
        int tempSum = 0;

        while(myNumber > 0) {
            int digit = myNumber % 10;
            int factorial = 1;
            myNumber /= 10;

            for (int i = 1; i <= digit; i++) {
                factorial = factorial * i;
            }
            tempSum += factorial;
        }
        if (myNewNumber == tempSum) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
