package basicSintax;

import java.util.Scanner;

public class a11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        float headsetPrice = Float.parseFloat(scanner.nextLine());
        float mousePrice = Float.parseFloat(scanner.nextLine());
        float keyboardPrice = Float.parseFloat(scanner.nextLine());
        float displayPrice = Float.parseFloat(scanner.nextLine());

        int headsets = lostGames / 2;
        //System.out.println(headsets);
        int mouses = lostGames / 3;
        //System.out.println(mouses);
        int keyboards = lostGames / 6;
        //System.out.println(keyboards);
        int displays = keyboards / 2;
        //System.out.println(displays);
        float mySum = (headsetPrice * headsets) + (mousePrice * mouses) + (keyboardPrice * keyboards) + (displayPrice * displays);

        System.out.println(String.format("Rage expenses: %.2f lv.", mySum));
    }
}
