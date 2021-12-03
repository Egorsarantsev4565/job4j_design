package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "ph")
@XmlAccessorType(XmlAccessType.FIELD)

public class ChoosePhone {

    @XmlAttribute
    private boolean available;
    private int price;
    private  String collector;
    private  Phone phone;
    @XmlElementWrapper(name = "accessories")
    @XmlElement(name = "accessory")
    private  String[] accessories;

    public ChoosePhone() {

    }

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

    public boolean isAvailable() {
        return available;
    }

    public int getPrice() {
        return price;
    }

    public String getCollector() {
        return collector;
    }

    public Phone getPhone() {
        return phone;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public static void main(String[] args) throws JAXBException {
         ChoosePhone choosePhone = new ChoosePhone(true, 55000, "Mvideo",
                new String[]{"Charger", "Adapter", "Headphones"},
                new Phone(false, 64, "Iphone 7+"));
        Gson gson = new GsonBuilder().create();
        String phJson = gson.toJson(choosePhone);
        System.out.println(phJson);
        ChoosePhone phMod = gson.fromJson(phJson, ChoosePhone.class);
        System.out.println(phMod);

        JAXBContext context = JAXBContext.newInstance(ChoosePhone.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(choosePhone, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
        JSONObject jsonPhone = new JSONObject("{\"phone\":"
                + "{\"broken\":\"false\",\"memory\":\"64\","
                + "\"model\":\"Iphone 7+\"}}");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("available", choosePhone.isAvailable());
        jsonObject.put("price", choosePhone.getPrice());
        jsonObject.put("collector", choosePhone.getCollector());
        jsonObject.put("phone", choosePhone.getPhone());
        jsonObject.put("accessories", choosePhone.getAccessories());
        System.out.println(jsonPhone.toString());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(choosePhone).toString());
    }
}
