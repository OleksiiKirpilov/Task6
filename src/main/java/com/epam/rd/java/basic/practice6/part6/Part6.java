package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Logger;

public class Part6 {

    public static void main(String[] args) {
        String fileName = "";
        String taskName = "";
        for (int i = 0; i < args.length; ++i) {
            String arg = args[i].toLowerCase();
            switch (arg) {
                case "--input":
                case "-i":
                    fileName = args[++i];
                    break;
                case "--task":
                case "-t":
                    taskName = args[++i].toLowerCase();
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
        Class<?> clazz;
        switch (taskName) {
            case "frequency":
                clazz = Part61.class;
                break;
            case "length":
                clazz = Part62.class;
                break;
            case "duplicates":
                clazz = Part63.class;
                break;
            default:
                printUsage();
                return;
        }
        List<String> words = getListOfWords(fileName);
        Method method;
        try {
            method = clazz.getMethod("work", List.class);
            method.invoke(clazz, words);
        } catch (ReflectiveOperationException e) {
            Logger.getGlobal().severe(e.getMessage());
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
