package ru.job4j.serialization.json;

public class Phone {
    private final boolean broken;
    private final int memory;
    private final String model;

    public Phone(boolean broken, int memory, String model) {
        this.broken = broken;
        this.memory = memory;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone {"
                + "model='" + model + '\''
                + ", memory='" + memory + '\''
                + ", broken='" + broken + '\''
                + '}';
    }
}
