package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        }
        else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        int i = Objects.checkIndex(index, size);
        E e = null;
        Iterator<E> it = this.iterator();
        int pos = 0;
        while (pos <= i) {
            e = it.next();
            pos++;
        }
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedIterator();
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    public class SimpleLinkedIterator implements Iterator<E> {
        private Node<E> point = null;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return point != last;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (point == null) {
                point = first;
            } else {
                point = point.next;
            }
            return point.item;
        }
    }
}