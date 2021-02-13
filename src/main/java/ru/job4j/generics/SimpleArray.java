package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] array;
    private int size = 0;

    public SimpleArray(int size) {
       array = new Object[size];
    }

    public void add(T model) {
       array[size++] = model;
}

    public void set(int index, T model) {
      int ind = Objects.checkIndex(index, size);
        array[ind] = model;
    }

    public void remove(int index) {
        int ind = Objects.checkIndex(index, size);
        System.arraycopy(array, ind + 1, array, ind, size - ind - 1);
        array[size - 1] = null;
        size--;

    }

    public T get(int index) {
        int ind = Objects.checkIndex(index, size);
        return (T) array[ind];
    }

    @Override
    public SimpleArrayIterator iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator<T> {
        private int point = 0;

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public T next() {
            return (T) array[point++];
        }
    }
}
