package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class ChoosePhone {
    private boolean available;
    private int price;
    private final String collector;
    private final String[] accessories;
    private final Phone phone;

    public ChoosePhone(boolean available, int price, String collector,
                       String[] accessories, Phone phone) {
        this.available = available;
        this.price = price;
        this.collector = collector;
        this.accessories = accessories;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ChoosePhone{"
                + "available=" + available
                + ", price=" + price
                + ", collector='" + collector + '\''
                + ", phone=" + phone
                + ", accessories=" + Arrays.toString(accessories)
                + '}';
    }

    public static void main(String[] args) {
        final ChoosePhone choosePhone = new ChoosePhone(true, 55000, "Mvideo",
                new String[]{"Charger", "Adapter", "Headphones"},
                new Phone(false, 64, "Iphone 7+"));
        final Gson gson = new GsonBuilder().create();
        String phJson = gson.toJson(choosePhone);
        System.out.println(phJson);
        final ChoosePhone phMod = gson.fromJson(phJson, ChoosePhone.class);
        System.out.println(phMod);
    }

}
