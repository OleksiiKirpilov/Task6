package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

    private static final InputStream STD_IN = System.in;

    private static ByteArrayInputStream getMockStream() {
        return new ByteArrayInputStream(
                "asd 43 asdf asd 43^434 asdf^kasdf asdf stop asdf^stop"
                        .replace("^", System.lineSeparator())
                        .getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        System.setIn(getMockStream());
        WordContainer.main(args);
        System.setIn(STD_IN);
    }

}

