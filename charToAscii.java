import java.util.Scanner;

public class charToAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oneChar = scanner.nextLine().charAt(1);

        System.out.println(oneChar);
    }
}
