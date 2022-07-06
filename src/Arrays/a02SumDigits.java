package Arrays;

import  java.util.Scanner;

public class a02SumDigits {
    public  static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int temp = 0;

        while (n1 > 0) {
            temp += n1 % 10;
            n1 /= 10;
        }

        System.out.println(temp);
    }
}
