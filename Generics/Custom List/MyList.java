package Generics.P07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> data;

    public MyList() {
        this.data = new ArrayList<>();
    }

    public List<T> getData() {
        return data;
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public T remove(int index) {
        data.remove(index);
        return data.get(index);
    }

    public boolean contains(T element) {
        if (data.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        T current = this.data.get(firstIndex);
        data.set(firstIndex, data.get(secondIndex));
        data.set(secondIndex, current);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T el : data) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return Collections.max(this.data);
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    public int size() {
        return this.data.size();
    }

    public void print() {
        this.data.forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
//        return this.data.iterator();

        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
