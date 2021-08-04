package com.epam.rd.java.basic.practice6.part1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordTest {

    private final Word w1 = new Word("word");
    private final Word w2 = new Word("word");
    private final Word w3 = new Word("word2", 2);
    private final Word w4 = new Word("java", 4);

    @Test
    public void equalsShouldReturnTrueIfSameContent() {
        assertEquals(w1, w2);
    }

    @Test
    public void compareToShouldReturn1IfFrequencyIsLower() {
        Word w3 = new Word("word2");
        w3.increaseFrequency();
        assertEquals(1, w1.compareTo(w3));
    }

    @Test
    public void toStringShouldReturnInCorrectFormat() {
        Word w = new Word("qwe");
        w.increaseFrequency();
        assertEquals("qwe : 2", w.toString());
    }

    public void compareToShouldReturn1IfContentHigher() {
        assertEquals(1, w3.compareTo(w4));
    }

}
