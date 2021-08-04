package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Part61 {

    private Part61() {
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList("a", "b", "z", "z", "c", "b");
        work(l);
    }

    public static void work(List<String> words) {
        Map<String, Integer> wordPositions = new HashMap<>();
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
        list = list.stream().sorted((e1, e2) -> {
            int cmp = e2.getValue() - e1.getValue();
            if (cmp < 0) {
                return -1;
            }
            if (cmp > 1) {
                return 1;
            }
            cmp = wordPositions.get(e1.getKey()) - wordPositions.get(e2.getKey());
            return (cmp < 1) ? -1 : 1;
        }).limit(3).sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            String key = list.get(i).getKey();
            int value = list.get(i).getValue();
            System.out.printf("%s ==> %d%n", key, value);
        }

    }

}
