package ru.job4j.service;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SettingsTest {
    @Test
    public void whenClassLoader() throws IOException {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            settings.load();
        }
        String value = settings.getValue("url");
        assertThat(value, is("jdbc:postgresql://localhost:5432/idea_db"));
    }
}