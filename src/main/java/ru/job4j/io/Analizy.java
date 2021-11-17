package ru.job4j.io;

import java.io.*;
import java.util.StringJoiner;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            String line;
            boolean flag = true;
            String start = null;
            String finish = null;
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            while ((line = in.readLine()) != null) {
                if ((line.startsWith("400") || line.startsWith("500")) && flag) {
                    flag = false;
                    start = line.substring(4) + ";";
                } else if ((line.startsWith("200") || line.startsWith("300")) && !flag) {
                    flag = true;
                    finish = start + line.substring(4) + ";";
                }
                if (finish != null) {
                    stringJoiner.add(finish);
                    finish = null;
                }
            }
            out.write(stringJoiner.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analyz = new Analizy();
        analyz.unavailable("./server.log", "./unavailable.csv");
    }
}