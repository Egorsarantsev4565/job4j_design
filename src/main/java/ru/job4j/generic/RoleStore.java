package ru.job4j.generic;

public class RoleStore implements Store<Role> {

    private final Store<Role>  camelCase = new MemStore<>();

    @Override
    public void add(Role model) {
        camelCase.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return  camelCase.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return  camelCase.delete(id);
    }

    @Override
    public Role findById(String id) {
        return  camelCase.findById(id);
    }
}
