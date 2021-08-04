package com.epam.rd.java.basic.practice6.part6;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Part63{

    private Part63() {}

    public static void work(List<String>  words) {
        Map<String, Integer> wordFreqs = words
                .stream()
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        List<String> l = words.stream()
                .filter(s -> wordFreqs.get(s) > 1)
                .limit(3)
                .map(String::toUpperCase)
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
        for (String w : l) {
            System.out.println(w);
        }
    }


}
