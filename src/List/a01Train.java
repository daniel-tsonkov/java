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
                    if ((vagons.indexOf(i) + (Integer.parseInt(data[1])) <= maxCapacity)) {
                        vagons.add(i) = (vagons.indexOf(i) + (Integer.parseInt(data[1])));
                    }
                }
            }

            myCommand = scanner.nextLine();
        }
        System.out.println(vagons + " ");
    }
}
