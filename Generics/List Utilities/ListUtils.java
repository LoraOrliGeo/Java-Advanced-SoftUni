package Generics.ListUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list){
        return list.stream().min((e1, e2) -> e1.compareTo(e2)).get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        return list.stream().max((e1, e2) -> e1.compareTo(e2)).get();
    }
}
