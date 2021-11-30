package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    private ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private void run() {
        List<String> botPhrases = readPhrases();
        List<String> log = new ArrayList<>();
        boolean canAnswer = true;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String myPhrase = in.readLine();
            log.add(myPhrase);
            while (!OUT.equals(myPhrase)) {
                if (canAnswer) {
                    String botAnswer = getRandomPhrase(botPhrases);
                    System.out.println("БОТ: " + botAnswer);
                    log.add(botAnswer);
                }
                myPhrase = in.readLine();
                log.add(myPhrase);
                if (STOP.equals(myPhrase)) {
                    canAnswer = false;
                } else if (CONTINUE.equals(myPhrase)) {
                    canAnswer = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveLog(log);

    }

    private String getRandomPhrase(List<String> phrases) {
        Random random = new Random();
        return phrases.get(random.nextInt(phrases.size() - 1));
    }

    private List<String> readPhrases() {
        List<String> answer = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            while (in.ready()) {
                answer.add(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path,
                StandardCharsets.UTF_8))) {
            for (String line : log) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("ConsoleChat.log", "botAnswers.txt");
        cc.run();
    }
}