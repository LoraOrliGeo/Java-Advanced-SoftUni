package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L_FilterByAge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> ages = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(", ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            ages.putIfAbsent(name, age);
        }

        String condition = sc.nextLine();
        int ageFilter = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        switch (condition) {
            case "younger":
                ages.entrySet().stream().filter(a -> a.getValue() <= ageFilter).forEach(kvp -> {
                    printInfo(kvp, format);
                });
                break;
            case "older":
                ages.entrySet().stream().filter(a -> a.getValue() >= ageFilter).forEach(kvp -> {
                    printInfo(kvp, format);
                });
                break;
        }
    }

    public static void printInfo(Map.Entry<String, Integer> kvp, String format) {
        switch (format) {
            case "name":
                System.out.println(String.format("%s", kvp.getKey()));
                break;
            case "age":
                System.out.println(String.format("%d", kvp.getValue()));
                break;
            case "name age":
                System.out.println(String.format("%s - %d", kvp.getKey(), kvp.getValue()));
                break;
        }
    }
}
