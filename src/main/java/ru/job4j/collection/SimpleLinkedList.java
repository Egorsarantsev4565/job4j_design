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
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        int i = Objects.checkIndex(index, size);
       Node<E> current = first;
        for (int pos = 0; pos < i; pos++) {
           current = current.next;
        }
        return current.item;
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
        private Node<E> point = first;
        private int k = 0;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return k < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

              E value = point.item;
                point = point.next;
                return value;
            }
        }
    }
