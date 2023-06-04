package DefiningClasses.CompanyRosterI;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //List<Employee> employees = new ArrayList<>();
        Map<String, List<Employee>> employees = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            int tokensLength = token.length;
            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String department = token[3];
            employees.putIfAbsent(department, new ArrayList<>());

            Employee employee;

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
            employees.get(department).add(employee);
        }
        Map.Entry<String, List<Employee>> highestSalaryDepartment =
                employees.entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<String, List<Employee>> department) ->
                        department.getValue().stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .getAsDouble(), Comparator.reverseOrder()))
                .findFirst()
                .orElse(null);
        System.out.printf("Highest Average Salary: %s\n", highestSalaryDepartment.getKey());
        highestSalaryDepartment.getValue()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
