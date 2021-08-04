package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Part61{

    private static final String ARROW = " ==> ";

    private static Map<String, Integer> wordPositions;

    private Part61() {}

    public static void work(List<String> words) {
        wordPositions = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (wordPositions.containsKey(word)) {
                continue;
            }
            wordPositions.put(word, i);
        }
        Map<String, Integer> wordsCount = words
                .stream()
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        List<Map.Entry<String, Integer>> list =
                wordsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        Collections.sort(list, (e1, e2) -> {
            int cmp = e2.getValue() - e1.getValue();
            if (cmp < 0) {
                return -1;
            }
            if (cmp > 1) {
                return 1;
            }
            cmp = wordPositions.get(e1.getKey()) - wordPositions.get(e2.getKey());
            return (cmp < 1) ? -1 : 1;
        });

        for (int i = 0; i < 3; i++) {
            String key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            System.out.println(key + ARROW + value);
        }

    }
    
}
