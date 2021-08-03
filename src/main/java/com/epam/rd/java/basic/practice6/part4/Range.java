package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private final int first;
    private final int last;
    private final int step;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        if (firstBound >= secBound) {
            throw new IllegalArgumentException();
        }
        if (reversedOrder) {
            this.first = secBound;
            this.last = firstBound;
            step = -1;
        } else {
            this.first = firstBound;
            this.last = secBound;
            step = 1;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {

        int index = first;

        @Override
        public boolean hasNext() {
            return (step == 1) ? index <= last : index >= last;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int out = index;
            index = index + step;
            return out;
        }

    }

}
