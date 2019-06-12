package DefiningClasses.P02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Employee>> departments = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            String email = "";
            int age = 0;

            if (tokens.length > 4) {
                if(tokens.length == 6) {
                    email = tokens[4];
                    age = Integer.parseInt(tokens[5]);
                    Employee employee = new Employee(name, salary, position, department, email, age);
                    departments.putIfAbsent(department, new ArrayList<>());
                    departments.get(department).add(employee);
                } else {
                    if (tokens[4].contains("@")) {
                        email = tokens[4];
                        Employee employee = new Employee(name, salary, position, department, email);
                        departments.putIfAbsent(department, new ArrayList<>());
                        departments.get(department).add(employee);
                    } else {
                        age = Integer.parseInt(tokens[4]);
                        Employee employee = new Employee(name, salary, position, department, age);
                        departments.putIfAbsent(department, new ArrayList<>());
                        departments.get(department).add(employee);
                    }
                }
            } else {
                Employee employee = new Employee(name, salary, position, department);
                departments.putIfAbsent(department, new ArrayList<>());
                departments.get(department).add(employee);
            }
        }

        departments.entrySet().stream().sorted((d1, d2) -> {
            double avg1 = 0;
            double sum1 = d1.getValue().stream().mapToDouble(Employee::getSalary).sum();
            avg1 = sum1 / d1.getValue().size();

            double avg2 = 0;
            double sum2 = d2.getValue().stream().mapToDouble(Employee::getSalary).sum();
            avg2 = sum2 / d2.getValue().size();

            return Double.compare(avg2, avg1);
        }).limit(1).forEach(e -> {
            System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
            e.getValue().stream().sorted((e1, e2) -> {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }).forEach(em -> System.out.println(String.format("%s %.2f %s %d",
                    em.getName(), em.getSalary(), em.getEmail(), em.getAge())));
        });
    }
}
