package List;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class a02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> myList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commands = command.split(" ");
            if (commands[0].equals("Delete")) {
                for (int i = 0; i < myList.size(); i++) {
                    if (myList.get(i) == Integer.parseInt(commands[1])) {
                        myList.remove(i);
                    }
                }
            } else {
                myList.add(Integer.parseInt(commands[2]), Integer.parseInt(commands[1]));
            }
            command = scanner.nextLine();
        }

        for (int vagon: myList) {
            System.out.print(vagon + " ");
        }
    }
}
