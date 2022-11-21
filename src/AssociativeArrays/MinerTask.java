package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String ars[]) {
        Scanner scanner = new Scanner(System.in);

        String resouce = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!resouce.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if(!resources.containsKey(resouce)) {
                resources.put(resouce, quantity);
            } else {
                resources.put(resouce, resources.get(resouce) + quantity);
            }


            resouce = scanner.nextLine();
        }
        resources.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
