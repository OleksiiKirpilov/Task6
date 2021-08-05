package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.List;

public class Part62 {

    private Part62() {
    }

    public static void work(List<String> words) {
        removeDuplicates(words)
                .stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .limit(3)
                .forEach(w -> System.out.printf("%s ==> %d%n", w, w.length()));
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
