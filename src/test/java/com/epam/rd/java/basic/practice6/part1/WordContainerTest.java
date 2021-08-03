package com.epam.rd.java.basic.practice6.part1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordContainerTest {

    @Test
    public void addDifferentWordsShouldIncreaseSize() {
        WordContainer wc = new WordContainer();
        wc.add(new Word("word"));
        wc.add(new Word("word2"));
        assertEquals(2, wc.size());
    }

    @Test
    public void addSameWordsShouldNotIncreaseSize() {
        WordContainer wc = new WordContainer();
        wc.add(new Word("word"));
        wc.add(new Word("word"));
        assertEquals(1, wc.size());
    }

}
