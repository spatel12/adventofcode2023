package com.example.aoc2023.day1;

import com.example.aoc2023.Utility;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Part2 {

    private static final Map<String, String> textToNumberMapping = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    public static int solve(String fileName) {
        try {
            List<String> inputs = Utility.readFile(fileName);

            return inputs.stream()
                    .map(Part2::transform)
                    .map(s -> s.replaceAll("\\D", ""))
                    .map(s -> s.length() > 1 ? s.substring(0, 1) + s.substring(s.length() - 1) : s + s)
                    .mapToInt(Integer::parseInt)
                    .sum();

        } catch (IOException e) {
            return 0;
        }
    }

    private static String transform(String input) {
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length() + 1; j++) {
                if (textToNumberMapping.containsKey(input.substring(i, j))) {
                    finalStr.append(textToNumberMapping.get(input.substring(i, j)));
                    i = j - 1;
                    break;
                }

                if (j == input.length()) {
                    finalStr.append(input.charAt(i));
                }
            }
        }
        return finalStr.toString();
    }
}
