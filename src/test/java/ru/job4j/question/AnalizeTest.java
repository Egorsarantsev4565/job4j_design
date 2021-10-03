package ru.job4j.question;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void test1() {
        Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "first"),
                new Analize.User(2, "second"),
                new Analize.User(3, "third"),
                new Analize.User(4, "fourth"),
                new Analize.User(5, "fifth")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "first"),
                new Analize.User(2, "second"),
                new Analize.User(3, "third"),
                new Analize.User(4, "fourth"),
                new Analize.User(5, "fifth"),
                new Analize.User(6, "sixth"),
                new Analize.User(7, "seventh"),
                new Analize.User(8, "eight")
        );

        Analize.Info result = analize.diff(previous, current);

        assertThat(result.getAdded(), is(3));
    }

    @Test
    public void test2() {
        Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "first"),
                new Analize.User(2, "second"),
                new Analize.User(3, "third"),
                new Analize.User(4, "fourth"),
                new Analize.User(5, "fifth")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "first"),
                new Analize.User(2, "second"),
                new Analize.User(4, "fourth"),
                new Analize.User(5, "fifth")
        );

        Analize.Info result = analize.diff(previous, current);

        assertThat(result.getDeleted(), is(1));
    }

    @Test
    public void test3() {
        Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "first"),
                new Analize.User(2, "second"),
                new Analize.User(3, "third"),
                new Analize.User(4, "fourth"),
                new Analize.User(5, "fifth")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "one"),
                new Analize.User(2, "second"),
                new Analize.User(3, "third"),
                new Analize.User(4, "fourth"),
                new Analize.User(5, "fifth")
        );

        Analize.Info result = analize.diff(previous, current);

        assertThat(result.getChanged(), is(1));
    }

}