import java.util.Scanner;

public class a08TriangleOfNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String myNumber = scanner.nextLine();

        for (int i = 1; i <= Integer.parseInt(myNumber); i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
