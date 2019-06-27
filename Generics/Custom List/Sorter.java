package Generics.P07_CustomList;

public class Sorter<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void sort(MyList<T> list) {
//        list.getData().sort(T::compareTo);

        //Bubble Sort:

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0){
                    list.swap(i, j);
                }
            }
        }

    }
}
