package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Part61{

    private static final String ARROW = " ==> ";

    public static void work(List<String> words) {
        Map<String, Integer> wordPositions = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (wordPositions.containsKey(word)) {
                continue;
            }
            wordPositions.put(word, i);
        }
        Map<String, Integer> wordFreqs = words
                .stream()
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        List<Map.Entry<String, Integer>> wf =
                wordFreqs.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());
        Collections.reverse(wf);
        for (int i = 0; i < 3; i++) {
            String key = wf.get(i).getKey();
            Integer value = wf.get(i).getValue();
            System.out.println(key + ARROW + value);
        }

    }
    
}
