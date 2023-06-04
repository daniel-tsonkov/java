package DefiningClasses.CompanyRosterI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String department = token[3];

            Employee employee;

            int tokensLength = token.length;
            switch (tokensLength) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (token[4].contains("@")) {
                        employee = new Employee(name, salary, position, department, token[4]);
                    } else {
                        employee = new Employee(name, salary, position, department, Integer.parseInt(token[4]));
                    }
                    break;
                default:
                    employee = new Employee(name, salary, position, department, token[4], Integer.parseInt(token[5]));
                    break;
            }
            employees.add(employee);
        }
        System.out.println();
    }
}
