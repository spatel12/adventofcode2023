package com.example.aoc2023.day1;

import com.example.aoc2023.Utility;

import java.io.IOException;
import java.util.List;

public class Part1 {

    public static int solve(String fileName) {
        try {
            List<String> input = Utility.readFile(fileName);

            return input.stream()
                    .map(s -> s.replaceAll("\\D", ""))
                    .map(s -> s.length() > 1 ? s.substring(0, 1) + s.substring(s.length() - 1) : s + s)
                    .mapToInt(Integer::parseInt)
                    .sum();

        } catch (IOException e) {
            return 0;
        }
    }
}
