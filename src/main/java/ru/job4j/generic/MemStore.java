package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;


public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(),model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            mem.get(model);
        }
        return rsl;

    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            mem.remove(index);
        }
        return rsl;
    }


    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

}