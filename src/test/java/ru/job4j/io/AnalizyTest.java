package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import javax.imageio.IIOException;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void analiz() throws IIOException {
        File source = new File("source.txt");
        File target = new File("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n"
                    +  "500 10:57:01\n"
                    +  "400 10:58:01\n"
                    +  "500 10:59:01\n"
                    +  "400 11:01:02\n"
                    +  "200 11:02:02");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Analizy analiz = new Analizy();
        analiz.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader readerIn = new BufferedReader(new FileReader(target))) {
            readerIn.lines().forEach(rsl :: append);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(rsl.toString(), is("10:57:01;11:02:02;"));
    }
    }