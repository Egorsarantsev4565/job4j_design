package ru.job4j.collection.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void test1() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(5));
        assertTrue(set.contains(5));
        assertFalse(set.add(5));
    }

    @Test
    public void test2() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(9));
        assertTrue(set.contains(9));
        assertFalse(set.add(9));
    }

}

