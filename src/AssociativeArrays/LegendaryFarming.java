package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasWinner = false;
        Map<String, Integer> items = new LinkedHashMap<>();

        while (!hasWinner) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length - 1; i += 2) {
                int quantity = Integer.parseInt(data[i]);
                String resouce = data[i + 1];
                items.putIfAbsent(resouce, 0);
                items.put(resouce, items.get(resouce) + quantity);
            }
        }
    }
}
