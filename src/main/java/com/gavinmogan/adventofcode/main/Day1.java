package com.gavinmogan.adventofcode.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public void log(int currentFreq, int deltaFreq) {
        Boolean shouldDebug = Boolean.parseBoolean(System.getProperty("DEBUG"));
        if (shouldDebug) {
            System.out.println(
                    String.format(
                            "Current frequency %2d, change of %2d; resulting frequency %2d",
                            currentFreq,
                            deltaFreq,
                            currentFreq + deltaFreq
                    )
            );
        }
    }

    public ArrayList<Integer> fetchDeltaFrequencies() throws Exception {
        ArrayList<Integer> deltaFrequencies = new ArrayList<Integer>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Day1.txt").getFile());

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int deltaFrequency = Integer.parseInt(line);
            deltaFrequencies.add(deltaFrequency);
        }

        scanner.close();

        return deltaFrequencies;
    }

    public int part1(List<Integer> deltaFrequencies) throws Exception {
        int frequency = 0;

        for (Integer deltaFrequency : deltaFrequencies) {
            log(frequency, deltaFrequency);
            frequency += deltaFrequency;
        }
        return frequency;
    }

    public Integer part2(List<Integer> deltaFrequencies) throws Exception {
        int frequency = 0;
        HashMap<Integer, Integer> seenFreqencies = new HashMap<Integer, Integer>();
        seenFreqencies.put(0, 1);

        while (true) {
            for (Integer deltaFrequency : deltaFrequencies) {
                log(frequency, deltaFrequency);

                frequency += deltaFrequency;
                seenFreqencies.put(frequency, seenFreqencies.getOrDefault(frequency, 0) + 1);

                if (seenFreqencies.get(frequency) >= 2) {
                    return frequency;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Day1 app = new Day1();
        int frequency = app.part2(app.fetchDeltaFrequencies());
        System.out.println(String.format("Final frequency: %d", frequency));
    }
}
