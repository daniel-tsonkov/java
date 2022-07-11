package Methods;

import java.util.Scanner;

public class a03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstChar = scanner.nextLine();
        int startValue = firstChar.toCharArray()[0];
        String secondChar = scanner.nextLine();
        int endValue = secondChar.toCharArray()[0];

        printAllChars(startValue, endValue);
    }

    public static void printAllChars(int start, int end) {
        if(start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        for (int i = start + 1; i < end; i++) {
            //char charForPrint = (char) i;
            //System.out.print(charForPrint + " ");
            System.out.printf("%c ", i);
        }
    }
}
