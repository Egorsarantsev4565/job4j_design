package ru.job4j.io.serialization.json;

import ru.job4j.serialization.json.ChoosePhone;
import ru.job4j.serialization.json.Phone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        ChoosePhone choosePhone = new ChoosePhone(true, 55000, "Mvideo",
                new String[]{"Charger", "Adapter", "Headphones"},
                new Phone(false, 64, "Iphone 7+"));
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(ChoosePhone.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(choosePhone, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            ChoosePhone result = (ChoosePhone) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}