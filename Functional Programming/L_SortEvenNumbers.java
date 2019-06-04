package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L_SortEvenNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 == 1);

        System.out.println(numbers.toString().replaceAll("\\]|\\[", ""));

        numbers.sort((n1, n2) -> n1.compareTo(n2));

        System.out.println(numbers.toString().replaceAll("\\]|\\[", ""));
    }
}
