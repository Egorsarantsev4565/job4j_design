package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListTest {
    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<String> linked = new SimpleLinkedList<>();
        linked.add("one");
        linked.add("two");
        linked.add("three");
        assertThat(linked.get(0), is("one"));
        assertThat(linked.get(1), is("two"));
        assertThat(linked.get(2), is("three"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<String> linked = new SimpleLinkedList<>();
        linked.add("one");
        linked.add("two");
        linked.add("three");
        Iterator<String> it = linked.iterator();
        assertThat(it.next(), is("one"));
        assertThat(it.next(), is("two"));
        assertThat(it.next(), is("three"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> linked = new SimpleLinkedList<>();
        linked.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> linked = new SimpleLinkedList<>();
        linked.add("one");
        linked.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> linked = new SimpleLinkedList<>();
        linked.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> linked = new SimpleLinkedList<>();
        linked.add("one");
        Iterator<String> it = linked.iterator();
        linked.add("two");
        it.next();
    }
}