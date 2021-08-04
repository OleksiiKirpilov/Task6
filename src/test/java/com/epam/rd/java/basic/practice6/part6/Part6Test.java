package com.epam.rd.java.basic.practice6.part6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Part6Test {

    private PrintStream std_out;

    private ByteArrayOutputStream baos;
    private PrintStream ps;

    @Before
    public void prepare() {
        std_out = System.out;
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @After
    public void rollback() {
        System.out.flush();
        System.setOut(std_out);
    }

    @Test
    public void shouldPrintUsageInfoWhenRunWithoutArgs() {
        Part6.main(new String[]{""});
        String output = baos.toString();
        Assert.assertTrue(output.contains("Usage:"));
        Assert.assertTrue(output.split(" ").length >= 6);
    }

    @Test
    public void partsShouldPrint3Lines() {
        String[][] params = new String[][]{
                {"-i", "part6.txt", "-t", "frequency"},
                {"--task", "length", "-i", "part6.txt"},
                {"-i", "part6.txt", "-task", "duplicates"}
        };
        for (String[] args : params) {
            Part6.main(args);
            String output = baos.toString();
            Assert.assertTrue(output.split(" ").length >= 3);
        }
    }

    @Test
    public void part61ShouldPrintCorrectData() {
        Part61.work(Arrays.asList("a", "b", "z", "z", "c", "b"));
        String output = baos.toString();
        try (Scanner sc = new Scanner(output)) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String line3 = sc.nextLine();
            Assert.assertEquals("z ==> 2", line1);
            Assert.assertEquals("b ==> 2", line2);
            Assert.assertEquals("a ==> 1", line3);
        }
    }

}
