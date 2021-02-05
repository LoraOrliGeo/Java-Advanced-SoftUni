package java_advanced.linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CustomLinkedList {
    // elements will be represented by Nodes
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private int element;
        private Node next;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (this.head != null) {
            // there are already nodes in CustomLinkedList - just move references of next and prev
            newNode.next = this.head;
            this.head.prev = newNode;
        }

        this.head = newNode;

        if (isEmpty()) {
            // at the beginning tail and head are pointing to the only added node
            this.tail = this.head;
        }

        this.size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("The data structure you're trying to remove from is empty!");
        }

        int removedElement = this.head.element;
        this.head = this.head.next;
        if (this.size > 1) {
            this.head.prev = null;
        }
        this.size--;

        if (this.isEmpty()) {
            this.head = this.tail = null;
        }
        return removedElement;
    }

    public int removeLast() {
        if (this.size < 2) {
            // since there are 1 or no elements, we can call removeFirst() and
            // use that an exception is thrown if collection is empty
            return removeFirst();
        }

        int removedElement = this.tail.element;
        this.tail = this.tail.prev;
        this.tail.next = null;
        this.size--;
        return removedElement;
    }

    public void clear() {
        // additional method implemented, not included in lab description
        if (!this.isEmpty()) {
            Node current = this.head;
            while (current != null) {
                Node next = current.next;
                current.prev = null;
                current.next = null;
                current = next;
            }
            this.size = 0;
            this.head = null;
            this.tail = null;
        }
    }

    public int get(int index) {
        validateIndex(index);

        Node current = this.head;
        int currentIndex = 0;
        int element = 0;

        while (current != null) {
            if (index == currentIndex) {
                element = current.element;
                break;
            }
            currentIndex++;
            current = current.next;
        }

        return element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.head;
        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray() {
        // variant 1 - wth array
        int[] array = new int[this.size];

        Node current = this.head;
        int index = 0;
        while (current != null) {
            array[index++] = current.element;
            current = current.next;
        }
//        return array;

        // variant 2 - with list
        List<Integer> list = new ArrayList<>();
        forEach(list::add);
        return list.stream().mapToInt(e -> e).toArray();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException(
                    String.format("Index: %d, size: %d - There is no such index in data structure.",
                            index,
                            this.size));
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
