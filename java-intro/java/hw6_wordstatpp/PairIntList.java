package hw6_wordstatpp;

import java.util.*;
public class PairIntList {
    private Pair1[] elementData;
    private int size;
    private int capacity;

    public PairIntList() {
        size = 0;
        capacity = 10;
        elementData = new Pair1[capacity];
    }

    public void add(Pair1 x) {
        if (size == capacity) {
            capacity = capacity + (capacity >> 1);
            elementData = Arrays.copyOf(elementData, capacity);
        }
        elementData[size++] = x;
    }

    public int size() {
        return size;
    }

    public Pair1 get(int i) {
        return elementData[i];
    }    
}
