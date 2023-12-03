package com.example.aoc2023;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static List<String> readFile(String fileName) throws IOException {
        ClassLoader classLoader = Utility.class.getClassLoader();
        Path filePath = Paths.get(classLoader.getResource(fileName).getFile());
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);

        } catch (IOException e) {
            lines = new ArrayList<>();
            e.printStackTrace();
        }

        return lines;
    }
}
