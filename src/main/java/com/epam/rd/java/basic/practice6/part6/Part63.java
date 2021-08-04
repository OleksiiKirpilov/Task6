package com.epam.rd.java.basic.practice6.part6;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Part63 {

    private Part63() {
    }

    public static void work(List<String> words) {
        Map<String, Integer> wordsCount = words
                .stream()
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        Part62.removeDuplicates(words)
                .stream()
                .filter(s -> wordsCount.get(s) > 1)
                .limit(3)
                .map(String::toUpperCase)
                .map(s -> new StringBuilder(s).reverse().toString())
                .forEach(System.out::println);
    }

}
