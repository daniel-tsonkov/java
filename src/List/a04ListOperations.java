package List;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class a04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> myInteger = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commands = command.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    myInteger.add(Integer.parseInt(commands[1]));
                    break;
                case "Insert":
                    if (Integer.parseInt(commands[2]) < 0 || Integer.parseInt(commands[2]) > myInteger.size()) {
                        System.out.println("Invalid index");
                    } else {
                        myInteger.add(Integer.parseInt(commands[2]), Integer.parseInt(commands[1]));
                    }
                    break;
                case "Remove":
                    if (Integer.parseInt(commands[1]) < 0 || Integer.parseInt(commands[1]) >= myInteger.size()) {
                        System.out.println("Invalid index");
                    } else {
                        myInteger.remove(Integer.parseInt(commands[1]));
                    }
                    break;
                case "Shift":
                    if (commands[1].equals("left")) {
                        int shiftValue = Integer.parseInt(commands[2]);
                        for (int i = 0; i < shiftValue; i++) {
                            myInteger.add(myInteger.get(0));
                            myInteger.remove(0);

                        }

                    } else {
                        int shiftValue = Integer.parseInt(commands[2]);
                        for (int i = 0; i < shiftValue; i++) {
                            myInteger.add(0, myInteger.get(myInteger.size() - 1));
                            myInteger.remove(myInteger.size() - 1);

                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int vagon: myInteger) {
            System.out.print(vagon + " ");
        }
    }
}
