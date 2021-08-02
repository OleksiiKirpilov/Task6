package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

    private static int sizeOfList;
    private static int step;

    public static void main(String[] args) {
        sizeOfList = 10_000;
        step = 4;
        processList(new LinkedList<>(), "LinkedList");
        processList(new ArrayList<>(sizeOfList), "ArrayList");
    }

    private static void processList(List<Integer> l, String listType) {
        //ArrayList#Index: 13 ms
        fillList(l, sizeOfList);
        System.out.printf("%s#Index: %d ms%n", listType, removeByIndex(l, step));
        System.out.printf("%s#Iterator: %d ms%n", listType, removeByIterator(l, step));
    }

    public static void fillList(List<Integer> list, int sizeOfList) {
        for (int i = 0; i < sizeOfList; i++) {
            list.add(i);
        }
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long time1 = System.nanoTime();
        List<Integer> l = list.stream().collect(Collectors.toList());
        int index = -1;
        while (l.size() != 1) {
            index = (index + k) % l.size();
            l.remove(index--);
        }
        return (System.nanoTime() - time1) / 1_000_000;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long time1 = System.nanoTime();
        List<Integer> l = list.stream().collect(Collectors.toList());
        Iterator<Integer> it = l.iterator();
        while (l.size() != 1) {
            int s = step;
            while (s != 0) {
                if (!it.hasNext()) {
                    it = l.iterator();
                }
                it.next();
                --s;
            }
            it.remove();
        }
        return (System.nanoTime() - time1) / 1_000_000;
    }
}
