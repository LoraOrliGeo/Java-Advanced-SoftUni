package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class L_SumNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> numbers = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());

        Function<String, Integer> parser = Integer::parseInt;

        int sum = 0;
        for (String number : numbers) {
            sum += parser.apply(number);
        }

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);
    }
}
