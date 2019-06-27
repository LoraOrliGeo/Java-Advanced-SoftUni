package Generics.P03_GenericSwapMethodStrings;

import java.util.*;

public class GenericSwapMethod {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String number = sc.nextLine();
            data.add(number);
        }

        int[] indices = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indices[0];
        int secondIndex = indices[1];

//        Collections.swap(data, firstIndex, secondIndex);

        genericSwap(data, firstIndex, secondIndex);

        for (String element : data) {
            System.out.println(element.getClass().getName() + ": " + element);
        }
    }

    public static <T> List<T> genericSwap(List<T> list, int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && firstIndex < list.size() && secondIndex >= 0 && secondIndex < list.size()) {
            T current = list.get(firstIndex);
            list.set(firstIndex, list.get(secondIndex));
            list.set(secondIndex, current);
        }
        return list;
    }
}
