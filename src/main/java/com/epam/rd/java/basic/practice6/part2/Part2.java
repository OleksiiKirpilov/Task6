package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        int sizeOfList = 10_000;
        int step = 4;
        List<Integer> al1 = new ArrayList<>(sizeOfList);
        List<Integer> al2 = new ArrayList<>(sizeOfList);
        List<Integer> ll1 = new LinkedList<>();
        List<Integer> ll2 = new LinkedList<>();
        fillList(al1, sizeOfList);
        System.out.printf("ArrayList#Index: %d ms%n", removeByIndex(al1, step));
        fillList(ll1, sizeOfList);
        System.out.printf("LinkedList#Index: %d ms%n", removeByIndex(ll1, step));
        fillList(al2, sizeOfList);
        System.out.printf("ArrayList#Iterator: %d ms%n", removeByIterator(al2, step));
        fillList(ll2, sizeOfList);
        System.out.printf("LinkedList#Iterator: %d ms%n", removeByIterator(ll2, step));
    }

    public static void fillList(List<Integer> list, int sizeOfList) {
        list.clear();
        for (int i = 0; i < sizeOfList; i++) {
            list.add(i);
        }
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long time1 = System.nanoTime();
        int index = -1;
        while (list.size() > 1) {
            index = (index + k) % list.size();
            list.remove(index--);
        }
        return (System.nanoTime() - time1) / 1_000_000;
    }

    /*
    ArrayList#Index: 13 ms
    LinkedList#Index: 93 ms
    ArrayList#Iterator: 20 ms
    LinkedList#Iterator: 15 ms
     */

    public static long removeByIterator(final List<Integer> list, int k) {
        long time1 = System.nanoTime();
        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            for (int s = k; s != 0; --s) {
                if (!it.hasNext()) {
                    it = list.iterator();
                }
                it.next();
            }
            it.remove();
        }
        return (System.nanoTime() - time1) / 1_000_000;
    }

}

