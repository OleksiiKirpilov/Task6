package com.epam.rd.java.basic.practice6.part4;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class RangeTest {

    private final Range direct = new Range(3, 10);
    private final Range reverse = new Range(3, 10, true);

    @Test
    public void lastReturnedValueShouldBe10() {
        Iterator<Integer> i = direct.iterator();
        int n = 0;
        while (i.hasNext()) {
            n = i.next();
        }
        assertEquals(10, n);
    }

    @Test
    public void reverseShouldReturn109876543() {
        StringBuilder sb = new StringBuilder();
        for (int n : reverse) {
            sb.append(n);
        }
        assertEquals("109876543", sb.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        Range r = new Range(1, 2);
        Iterator<Integer> it = r.iterator();
        while (it.hasNext()) {
            it.next();
        }
        it.next();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        Range r = new Range(10, 1);
    }

}
