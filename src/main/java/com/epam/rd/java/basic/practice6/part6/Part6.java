package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class Part6 {

    public static void main(String[] args) {
        String fileName = "";
        String taskName = "";
        // using ArrayList just because SONAR dislikes
        // changing indexing variable inside of loop,
        // and arrays don't have iterators
        Iterator<String> it = Arrays.asList(args).iterator();
        while (it.hasNext()) {
            String arg = it.next().toLowerCase();
            switch (arg) {
                case "--input":
                case "-i":
                    fileName = it.next();
                    break;
                case "--task":
                case "-t":
                    taskName = it.next().toLowerCase();
                    break;
                default:
                    printUsage();
                    return;
            }
        }
        if (fileName.isEmpty() || taskName.isEmpty()) {
            printUsage();
            return;
        }
        List<String> words = getListOfWords(fileName);
        switch (taskName) {
            case "frequency":
                Part61.work(words);
                break;
            case "length":
                Part62.work(words);
                break;
            case "duplicates":
                Part63.work(words);
                break;
            default:
                printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("Use --input, -i to specify input file.");
        System.out.println("Use --task, -t to specify task.");
        System.out.println("Task is one of: frequency, length, duplicates.");
        System.out.println("For example:");
        System.out.println("Part6 -i part6.txt --task length");
    }

    public static List<String> getListOfWords(String fileName) {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
            scanner.close();
        } catch (IOException ex) {
            Logger.getGlobal().severe(ex.getMessage());
        }
        return words;
    }

}
