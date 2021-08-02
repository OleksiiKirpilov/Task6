package com.epam.rd.java.basic.practice6.part1;

import static org.junit.Assert.*;
import org.junit.Test;

public class WordContainerTest {

    @Test
    public void addDifferentWordsShouldIncreaseSize() {
        WordContainer wc = new WordContainer();
        wc.add(new Word("word"));
        wc.add(new Word("word2"));
        assertEquals(wc.size(), 2);
    }

    @Test
    public void addSameWordsShouldNotIncreaseSize() {
        WordContainer wc = new WordContainer();
        wc.add(new Word("word"));
        wc.add(new Word("word"));
        assertEquals(wc.size(), 1);
    }

}
