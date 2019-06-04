package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L_CountUppercaseWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> asd = Arrays.stream(sc.nextLine().split("\\s+")).filter(e -> Character.isUpperCase(e.charAt(0))).collect(Collectors.toList());
        System.out.println(asd.size());
        System.out.println(String.join(System.lineSeparator(), asd));
    }
}
