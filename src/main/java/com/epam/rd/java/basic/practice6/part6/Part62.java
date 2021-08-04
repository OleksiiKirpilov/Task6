package com.epam.rd.java.basic.practice6.part6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part62 {

    private static final String ARROW = " ==> ";

    public static void work(List<String>  words) {

        Map<String, Integer> wordPositions = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (wordPositions.containsKey(word)) {
                continue;
            }
            wordPositions.put(word, i);
        }

        List<String> l = words.stream()
                .sorted((s1, s2) -> s2.length() - s1.length()).limit(3)
                .collect(Collectors.toList());
        for (String w : l) {
            System.out.println(w + ARROW + w.length());
        }

    }


}
