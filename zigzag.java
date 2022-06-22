import java.util.Scanner;

public class zigzag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrlenght = Integer.parseInt(scanner.nextLine());

        String[] firstArr = new String[arrlenght];
        String[] secArr = new String[arrlenght];

        for (int i = 1; i <= arrlenght / 2; i++) {
            if (i % 2 == 0) {
                firstArr[i - 1] = scanner.nextLine();
                secArr[i - 1] = scanner.nextLine();
            } else {
                secArr[i - 1] = scanner.nextLine();
                firstArr[i - 1] = scanner.nextLine();
            }
        }
        for (String arra : firstArr){
            System.out.print(arra + " ");
        }
        System.out.println();
        for (String arrb : secArr){
            System.out.print(arrb + " ");
        }
    }
}