package com.epam.rd.java.basic.practice6.part6;

import java.util.List;
import java.util.stream.Collectors;

public class Part62 {

    private static final String ARROW = " ==> ";

    private Part62() {
    }

    public static void work(List<String> words) {
        List<String> list = words.stream()
                .sorted((s1, s2) -> s2.length() - s1.length()).limit(3)
                .collect(Collectors.toList());
        for (String word : list) {
            System.out.println(word + ARROW + word.length());
        }

    }

}
