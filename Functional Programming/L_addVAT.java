package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class L_addVAT {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Double> input = Arrays.stream(sc.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> vats = x -> x = 1.2 * x;

        System.out.println("Prices with VAT:");
        for (Double price : input) {
            System.out.printf("%.2f%n", vats.apply(price));
        }
    }
}