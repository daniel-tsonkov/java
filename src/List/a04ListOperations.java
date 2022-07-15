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
                    if (Integer.parseInt(commands[2]) > myInteger.size()) {
                        System.out.println("Invalid index");
                    } else {
                        myInteger.add(Integer.parseInt(commands[2]), Integer.parseInt((commands[1])));
                    }
                    break;
                case "Remove":
                    if (Integer.parseInt(commands[1]) > myInteger.size()) {
                        System.out.println("Invalid index");
                    } else {
                        myInteger.remove(Integer.parseInt((commands[1])));
                    }
                    break;
                case "Shift":
                    int tempvalue;
                    if (commands[1].equals("left")) {
                        int shiftValue = Integer.parseInt(commands[2]);
                        for (int i = 0; i < shiftValue; i++) {
                            tempvalue = myInteger.get(0);
                            myInteger.remove(0);
                            myInteger.add(tempvalue);
                        }

                    } else {
                        int shiftValue = Integer.parseInt(commands[2]);
                        for (int i = 0; i < shiftValue; i++) {
                            tempvalue = myInteger.get(myInteger.size() - 1);
                            myInteger.remove(myInteger.size() - 1);
                            myInteger.add(0, tempvalue);
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
