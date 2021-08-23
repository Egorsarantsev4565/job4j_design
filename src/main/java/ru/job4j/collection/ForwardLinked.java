package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
       T t = head.value;
        head = head.next;
        size--;
         return t;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        T t = null;
        for (int index = 0; index < size - 2; index++) {
            tail = tail.next;
        }
        if (size > 1) {
            t = tail.next.value;
            tail.next = null;
        } else {
         t = tail.value;
            head = null;
        }
        size--;
        return  t;
    }

    public void add(T value) {
        Node<T> node = new Node(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void addFirst(T value) {
        Node<T> node = head;
        head = new Node<>(value, null);
        head.value = value;
        head.next = node;

    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> prev = null;
        Node<T> follow = head.next;
        while (follow != null) {
            head.next = prev;
            prev = head;
            head = follow;
            follow = follow.next;
        }
        head.next = prev;
    }

    public boolean isEmpty() {
      return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}