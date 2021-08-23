package ru.job4j.map;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        final Map<User, Object> usermap = new HashMap<>(3);
        User userOne = new User("Egor", 1, new GregorianCalendar(2001, Calendar.MARCH, 27));
        User userTwo = new User("Egor", 1, new GregorianCalendar(2001, Calendar.MARCH, 27));

        usermap.put(userOne, new Object());
        usermap.put(userTwo, new Object());

        int hCode1 = (userOne).hashCode();
        System.out.println("hashCode = " + hCode1);

        int hCode2 = (userTwo).hashCode();
        System.out.println("hashCode = " + hCode2);

        for (Map.Entry<User, Object> entry: usermap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
