package ru.job4j.generics;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whensSet() {
        SimpleArray simpleArray = new SimpleArray(4);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.set(3, 5);
        assertThat(simpleArray.get(3), is(5));
    }

    @Test
    public void whensRemove() {
        SimpleArray simpleArray = new SimpleArray(4);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.remove(2);
        assertThat(simpleArray.get(2), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenException() {
        SimpleArray simpleArray = new SimpleArray(4);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.get(5);
    }
}