import java.util.Scanner;

public class a06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int myNumber = Integer.parseInt(scanner.nextLine());
        int mynewNumber = myNumber;
        int factorial = 1;
        int tempSum = 0;

        while(myNumber > 0) {
            int tempNumber = myNumber % 10;
            factorial = 1;
            myNumber = myNumber / 10;

            for (int i = 1; i <= tempNumber; i++) {
                factorial = factorial * i;
            }
            tempSum += factorial;
        }
        if (mynewNumber == tempSum) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
