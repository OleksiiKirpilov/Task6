package com.epam.rd.java.basic.practice6.part1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordTest {

    private final Word w1 = new Word("word");
    private final Word w2 = new Word("word");

    @Test
    public void equalsShouldReturnTrueIfSameContent() {
        assertEquals(w1, w2);
    }

    @Test
    public void compareToShouldReturn1IfFrequencyIsLower() {
        Word w3 = new Word("word");
        w3.increaseFrequency();
        assertEquals(-1, w1.compareTo(w3));
    }

}
