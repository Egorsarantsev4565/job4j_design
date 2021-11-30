package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Egor Sarantsev";
        double daysToNewYear = 32.0;
        char sex = 'm';
        boolean alive = true;
        short age = 20;
        int year = 2021;
        long day = 30;
        byte month = 11;
        float temperature = 36.6F;

        LOG.debug("User info name : {}, age : {}, sex : {}, alive : {}, temperature : {}",
                name, age, sex, alive, temperature);
        LOG.debug("Date info day : {}, month : {}, year : {}, days to New Year : {}",
                day, month, year, daysToNewYear);
    }
}