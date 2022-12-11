package StaksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();

            int commandNumber = Integer.parseInt(command.split("\\s+")[0]);

            switch (commandNumber) {
                case 1 :
                    textStack.push(currentText.toString());
                    String stringForApend = command.split("\\s+")[1];
                    currentText.append(stringForApend);
                    break;
                case 2 :
                    textStack.push(currentText.toString());
                    int countElementsForDelet = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndexForDelete = currentText.length() - countElementsForDelet;

                    currentText.delete(startIndexForDelete, startIndexForDelete + countElementsForDelet);
                    break;
                case 3 :
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case 4 :
                    if (!textStack.isEmpty()) {
                        currentText = new StringBuilder(textStack.pop());
                    }
                    break;
            }
        }
    }
}
