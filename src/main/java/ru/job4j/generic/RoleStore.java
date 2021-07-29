package ru.job4j.generic;

public class RoleStore implements Store<Role> {

    private final Store<Role> role_store = new MemStore<>();

    @Override
    public void add(Role model) {
        role_store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return role_store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return role_store.delete(id);
    }

    @Override
    public Role findById(String id) {
        return role_store.findById(id);
    }
}
