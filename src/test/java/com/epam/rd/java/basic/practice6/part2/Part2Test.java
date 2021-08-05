package com.epam.rd.java.basic.practice6.part2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Part2Test {

    private final List<Integer> ll1 = new LinkedList<>();
    private final List<Integer> ll2 = new LinkedList<>();
    private final List<Integer> al1 = new ArrayList<>();
    private final List<Integer> al2 = new ArrayList<>();
    private final int k = 4;
    private final int n = 10_000;

    @Before
    public void setUpList() {
        Part2.fillList(ll1, n);
        Part2.fillList(ll2, n);
        Part2.fillList(al1, n);
        Part2.fillList(al2, n);
    }

    @Test
    public void arrayListRemoveByIndexShouldBeFasterThanLinkedList() {
        assertTrue(Part2.removeByIndex(al1, k) < Part2.removeByIndex(ll1, k));
    }

    @Test
    public void linkedListRemoveByIndexShouldBeSlowerThanByIterator() {
        assertTrue(Part2.removeByIterator(ll2, k) < Part2.removeByIndex(al2, k));
    }

}