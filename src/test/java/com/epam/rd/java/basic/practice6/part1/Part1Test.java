package com.epam.rd.java.basic.practice6.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Part1Test {

    private PrintStream std_out;
    private ByteArrayOutputStream baos;

    @Before
    public void prepare() {
        std_out = System.out;
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @After
    public void rollback() {
        System.out.flush();
        System.setOut(std_out);
    }

    @Test
    public void mainShouldPrintTestData() {
        Part1.main(new String[0]);
        String output = baos.toString();
        String[] data = {"asdf : 3", "43 : 2", "asd : 2", "434 : 1", "kasdf : 1"};
        try (Scanner sc = new Scanner(output)) {
            for (String datum : data) {
                String line = sc.nextLine();
                Assert.assertEquals(datum, line);
            }
        }

    }

}
