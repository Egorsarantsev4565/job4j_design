package ru.job4j.map;

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


    public static void main (String[] args) {
        final Map<User, Object> usermap = new HashMap<>();
        User userOne = new User("Egor", 1, new GregorianCalendar(2001, Calendar.MARCH,27));
        User userTwo = new User("Egor", 1, new GregorianCalendar(2001, Calendar.MARCH,27));

        usermap.put(userOne,new Object());
        usermap.put(userTwo,new Object());


        for(Map.Entry<User, Object> entry: usermap.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());




    }
}
