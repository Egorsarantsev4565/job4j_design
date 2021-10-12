package ru.job4j.question;
import java.util.Map;
import java.util.Objects;
import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {

        Info info = new Info();

        Map<Integer, String> map = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        for (User index : previous) {
            if (!map.containsKey(index.getId())) {
                info.deleted++;
            } else if (!map.get(index.getId()).equals(index.getName())) {
                info.changed++;
            }
            map.put(index.getId(), index.getName());
        }

        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass())  {
                return false;
            }
            User user = (User) o;
            return id == user.id && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}