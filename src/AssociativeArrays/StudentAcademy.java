package AssociativeArrays;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentInfo.putIfAbsent(name, new ArrayList<>());
            studentInfo.get(name).add(grade);
        }
        studentInfo.entrySet().stream().filter(s -> s.getValue().stream().mapToDouble(x -> x).average().orElse(0.0) >= 4.50)
                .forEach(entry -> {
                    double averageGrate = entry.getValue().stream().mapToDouble(x -> x).average().orElse(0.0);
                    System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrate);
                });
    }
}
