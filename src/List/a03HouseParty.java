package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class a03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        List<String> listGuests = new ArrayList<>();
        String[] commands = scanner.nextLine().split(" ");

        for (int i = 0; i < guests; i++) {
            if (commands[2].equals("going!")) {
                boolean isAdded = false;

                for (int j = 0; j < listGuests.size(); j++) {
                    if (listGuests.get(j).equals(commands[0])) {
                        isAdded = true;
                    }
                }

                if (!isAdded) {
                    listGuests.add(commands[0]);
                } else {
                    System.out.println(commands[0] + " is already in the list!");
                }
            } else {
                boolean isNotAdded = true;

                for (int j = 0; j < listGuests.size(); j++) {
                    if (listGuests.get(j).equals(commands[0])) {
                        isNotAdded = false;
                    }
                }

                if (!isNotAdded) {
                    System.out.println(commands[0] + " is not in the list!");
                } else {
                    listGuests.remove(commands[0]);
                }
            }
            commands = scanner.nextLine().split(" ");
        }
        for (String myGuests: listGuests) {
            System.out.println(myGuests);
        }
    }
}
