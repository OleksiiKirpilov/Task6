package com.epam.rd.java.basic.practice6.part1;

import java.util.Scanner;
import java.util.TreeSet;

public class WordContainer extends TreeSet<Word> {

    public WordContainer() {
        super(Word::compareByFrequencyThenContent);
    }

    public static void main(String[] args) {
        WordContainer wc = new WordContainer();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String word = in.next();
            if (word.equalsIgnoreCase("stop")) {
                break;
            }
            wc.add(new Word(word));
        }
        for (Word w : wc) {
            System.out.println(w);
        }
    }

    @Override
    public boolean add(Word word) {
        for (Word w : this) {
            if (w.equals(word)) {
                remove(w);
                w.increaseFrequency();
                super.add(new Word(w));
                return true;
            }
        }
        super.add(word);
        return false;
    }
}
