package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> l = getListCopy(list);
        long time1 = System.nanoTime();
        int index = -1;
        while (l.size() > 1) {
            index = (index + k) % l.size();
            l.remove(index--);
        }
        return (System.nanoTime() - time1) / 1_000_000;
    }

    private static List<Integer> getListCopy(List<Integer> list) {
        List<Integer> l;
        if (list instanceof ArrayList) {
            l = new ArrayList<>(list);
        } else {
            l = new LinkedList<>(list);
        }
        return l;
    }

    /*
    LinkedList#Index: 26 ms
    LinkedList#Iterator: 2 ms
    ArrayList#Index: 3 ms
    ArrayList#Iterator: 3 ms
     */

    /*
    ArrayList#Index: 13 ms
    LinkedList#Index: 93 ms
    ArrayList#Iterator: 20 ms
    LinkedList#Iterator: 15 ms
     */

    public static long removeByIterator(final List<Integer> list, int k) {
        List<Integer> l = getListCopy(list);
        long time1 = System.nanoTime();
        Iterator<Integer> it = l.iterator();
        while (l.size() > 1) {
            for (int s = k; s != 0; --s) {
                if (!it.hasNext()) {
                    it = l.iterator();
                }
                it.next();
            }
            it.remove();
        }
        return (System.nanoTime() - time1) / 1_000_000;
    }

}

