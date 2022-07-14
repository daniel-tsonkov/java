package List;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class a03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        List<String> listGuests = new ArrayList<>();


        for (int i = 0; i < guests; i++) {
            String[] commands = scanner.nextLine().split(" ");
            boolean isAdded = false;

            if (commands[2].equals("going!")) {
                for (String listGuest : listGuests) {
                    if (listGuest.equals(commands[0])) {
                        isAdded = true;
                        break;
                    }
                }

                if (!isAdded) {
                    listGuests.add(commands[0]);
                } else {
                    System.out.println(commands[0] + " is already in the list!");
                }
            } else {
                for (String listGuest : listGuests) {
                    if (listGuest.equals(commands[0])) {
                        isAdded = true;
                        break;
                    }
                }

                if (!isAdded) {
                    System.out.println(commands[0] + " is not in the list!");
                } else {
                    listGuests.remove(commands[0]);
                }
            }
        }
        for (String myGuests: listGuests) {
            System.out.println(myGuests);
        }
    }
}
