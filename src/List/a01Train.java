package List;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class a01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> vagons = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String myCommand = scanner.nextLine();
        while (!myCommand.equals("end")) {
            String[] data = myCommand.split(" ");

            if(data[0].equals("Add")) {
                vagons.add(Integer.parseInt(data[1]));
            } else {
                for (int i = 0; i < vagons.size(); i++) {
                    if ((vagons.get(i) + (Integer.parseInt(data[0])) <= maxCapacity)) {
                        vagons.set(i, (vagons.get(i) + (Integer.parseInt(data[0]))));
                        break;
                    }
                }
            }

            myCommand = scanner.nextLine();
        }

        for (int vagon: vagons) {
            System.out.print(vagon + " ");
        }
    }
}
