package ru.job4j.collection;

import java.util.*;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Map<User, Object> usermap = new HashMap<>(3);
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
