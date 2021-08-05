package com.epam.rd.java.basic.practice6.part5;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    Tree<Integer> t = new Tree<>();

    @Test
    public void shouldReturnTrueIfAddedOneTime() {
        assertTrue(t.add(1));
    }

    @Test
    public void shouldReturnFalseIfAddedTwoTimes() {
        t.add(1);
        assertFalse(t.add(1));
    }

    @Test
    public void shouldReturnFalseIfRemovedNonExisted() {
        t.remove(1);
        assertFalse(t.remove(1));
    }

    @Test
    public void shouldRemoveAllReturningTrue() {
        Integer[] data = {1, 9, 4, 434, 23, 6, -43, 0 ,34, -665};
        t.add(data);
        for (Integer i : data) {
            assertTrue(t.remove(i));
        }
    }


}
