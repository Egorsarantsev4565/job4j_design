package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int rsl = 0;
                rsl = Integer.parseInt(line);
                if (rsl % 2 == 0) {
                    System.out.println(rsl + " - Четное число");
                } else {
                    System.out.println(rsl + " - Нечетное число");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
