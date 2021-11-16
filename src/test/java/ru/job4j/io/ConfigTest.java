package ru.job4j.io;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.IOException;
public class ConfigTest {

    /** в первом тесте добавил ==
     * во втором тесет убрал значение
     * в третьем тесте убрал значение*/

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutComment() {
        Config config = new Config(
                "Data\\app.properties");
        try {
            config.load();
        } catch (IOException e) {
            Assert.fail();
        }
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        throw new IllegalArgumentException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithComment() {
        Config config = new Config(
                "Data\\nocomment.properties");
        try {
            config.load();
        } catch (IOException e) {
            Assert.fail();
        }
        assertThat(config.value("hibernate.connection.password"), is("password"));
        throw new IllegalArgumentException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithourPair() {
        Config config = new Config(
                "Data\\nopair.properties");
        try {
            config.load();
        } catch (IOException e) {
            Assert.fail();
        }
        assertThat(config.value(null), is("postgres"));
        throw new IllegalArgumentException();
    }
}
