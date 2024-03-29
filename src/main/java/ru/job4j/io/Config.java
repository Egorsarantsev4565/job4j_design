package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            in.lines()
                    .filter(s -> !(s.startsWith("#") || s.isEmpty()))
                    .map(s -> s.split("="))
                    .forEach((strings -> {
                        if (strings.length != 2) {
                            throw new IllegalArgumentException();
                        }
                        values.put(strings[0], strings[1]);
                    }));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Config(
                        "./Data/app.properties"));
    }
}