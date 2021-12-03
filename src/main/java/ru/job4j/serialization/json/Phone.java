package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)

public class Phone {

    @XmlAttribute
    private  boolean broken;
    private  int memory;
    private  String model;

    public Phone() {

    }

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
