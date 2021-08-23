package ru.job4j.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name) {
        this.name = name;
    }

    public User(int children) {
        this.children = children;
    }

    public User(Calendar birthday) {
        this.birthday = birthday;
    }
}
