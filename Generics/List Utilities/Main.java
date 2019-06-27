package Generics.ListUtilities;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 50, -15, 1, 1500);

        int minNum = ListUtils.getMin(numbers);
        System.out.println(minNum);

        int maxNum = ListUtils.getMax(numbers);
        System.out.println(maxNum);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minString = ListUtils.getMin(strings);
        System.out.println(minString);

        String maxString = ListUtils.getMax(strings);
        System.out.println(maxString);
    }
}
