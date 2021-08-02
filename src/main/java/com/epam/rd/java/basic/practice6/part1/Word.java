package com.epam.rd.java.basic.practice6.part1;

import java.util.Objects;

public class Word implements Comparable<Word> {

	private final String content;

	private int frequency;

    public Word(String word) {
        this(word, 1);
    }

    public Word(String word, int freq) {
        content = word;
        frequency = freq;
    }

    public Word(Word w) {
        this(w.content, w.frequency);
    }

    public void increaseFrequency() {
        ++frequency;
    }

    @Override
    public int compareTo(Word o) {
        return compareByFrequencyThenContent(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return content.equals(word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }

    public static int compareByFrequencyThenContent(Word w1, Word w2) {
        int cmp;
        if (w1.frequency != w2.frequency) {
            cmp = (w1.frequency > w2.frequency) ? -1 : 1;
        } else {
            cmp = w1.content.compareTo(w2.content);
        }
        return cmp;
    }

}
