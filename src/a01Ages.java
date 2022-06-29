import java.util.Scanner;

public class a01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ages = Integer.parseInt(scanner.nextLine());

        if (ages <= 2 ) {
            System.out.println("baby");
        }else if (ages > 2 && ages <= 13) {
            System.out.println("child");
        }else if (ages > 13 && ages <= 19) {
            System.out.println("teenager");
        }else if (ages > 19 && ages <= 65) {
            System.out.println("adult");
        }else {
            System.out.println("elder");
        }
    }
}
