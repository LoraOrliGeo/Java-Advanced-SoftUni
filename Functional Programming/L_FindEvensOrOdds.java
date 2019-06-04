package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class L_FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = tokens[0];
        int upperBound = tokens[1];

        String option = sc.nextLine();

        Predicate<Integer> odd = x -> x % 2 != 0;
        Predicate<Integer> even = x -> x % 2 == 0;

        Predicate<Integer> byType = option.equals("even") ? even : odd;

        IntStream.rangeClosed(lowerBound, upperBound).boxed().filter(byType).forEach(e -> System.out.print(e + " "));
    }
}