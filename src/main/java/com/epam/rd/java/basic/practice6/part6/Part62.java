package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part62 {

    private Part62() {
    }

    public static void work(List<String> words) {
        List<String> list = removeDuplicates(words);
        list = list.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .limit(3)
                .collect(Collectors.toList());
        for (String word : list) {
            System.out.printf("%s ==> %d%n", word, word.length());
        }

    }

    public static List<String> removeDuplicates(List<String> words) {
        List<String> list = new ArrayList<>(words);
        int i = 0;
        while (i < list.size()) {
            String word = list.get(i);
            if (list.indexOf(word) < i) {
                list.remove(i);
            } else {
                ++i;
            }
        }
        return list;
    }

}
