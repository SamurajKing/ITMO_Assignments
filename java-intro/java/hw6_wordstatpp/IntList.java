package hw6_wordstatpp;

import java.util.*;
public class IntList {
    private int[] elementData;
    private int size;
    private int capacity;

    public IntList() {
        size = 0;
        capacity = 10;
        elementData = new int[capacity];
    }

    public void add(int x) {
        if (size == capacity) {
            capacity = capacity + (capacity >> 1);
            elementData = Arrays.copyOf(elementData, capacity);
        }
        elementData[size++] = x;
    }

    public int size() {
        return size;
    }

    public int get(int i) {
        return elementData[i];
    }
}
