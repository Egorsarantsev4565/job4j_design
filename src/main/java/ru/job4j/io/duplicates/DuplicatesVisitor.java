package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Set<FileProperty> files = new HashSet<>();

     @Override
        public FileVisitResult visitFile(
                Path file, BasicFileAttributes attrs) throws IOException {
            FileProperty element = new FileProperty(
                    file.toFile().length(), file.toFile().getName());
             if (!files.add(element)) {
                System.out.println(file.toFile().getName());
                System.out.println("Дубликат");
                System.out.println(file.toAbsolutePath());
                if (files.contains(element)) {
                    System.out.println(file.toFile().getName());
                    System.out.println("Оригинал");
                    System.out.println(file.toAbsolutePath());

                }
            }
            return super.visitFile(file, attrs);
        }
    }
