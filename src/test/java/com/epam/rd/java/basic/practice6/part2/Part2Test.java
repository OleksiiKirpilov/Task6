package com.epam.rd.java.basic.practice6.part2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Part2Test {

    private final List<Integer> l1 = new LinkedList<>();
    private final List<Integer> l2 = new ArrayList<>();
    private final int k = 4;
    private final int n = 10_000;

    @Before
    public void setUpList() {
        Part2.fillList(l1, n);
        Part2.fillList(l2, n);
    }

    @Test
    public void arrayListRemoveByIndexShouldBeFasterThanLinkedList() {
        assertTrue(Part2.removeByIndex(l2, k) < Part2.removeByIndex(l1, k));
    }

    @Test
    public void linkedListRemoveByIndexShouldBeSlowerThanByIterator() {
        assertTrue(Part2.removeByIterator(l1, k) < Part2.removeByIndex(l1, k));
    }

}