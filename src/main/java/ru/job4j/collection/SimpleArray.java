package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    Object[] container = new Object[10];
    private int modCount = 0;
    private int size = 0;


    public T get(int index) {
        int i = Objects.checkIndex(index, size);
        modCount++;
        return (T) container[i];

    }

    private Object[] newArray() {
        Object[] newArray = new Object[this.newArray().length * 2];
        return newArray = Arrays.copyOf(container, container.length + 1);

    }

    public void add(T model) {
        if (size == container.length) {
            container = newArray();
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator<T> {
        private int point = 0;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[point++];
        }
    }
}