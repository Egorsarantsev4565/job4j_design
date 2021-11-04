package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.IOException;
public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        Config config = new Config(
                "C:/Users/Egor/IdeaProjects/job4j_design/app.properties");
        try {
            config.load();
        } catch (IOException e) {
            fail();
        }
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }

    @Test
    public void whenPairWithComment() {
        Config config = new Config(
                "C:/Users/Egor/IdeaProjects/job4j_design/nocomment.properties");

        try {
            config.load();
        } catch (IOException e) {
            fail();
        }
        assertNull(config.value("hibernate.connection.password=password"));
    }

    @Test
    public void whenPairWithourPair() {
        Config config = new Config(
                "C:/Users/Egor/IdeaProjects/job4j_design/nopair.properties");
        try {
            config.load();
        } catch (IOException e) {
            fail();
        }
        assertNull(config.value("5"));
    }
}
