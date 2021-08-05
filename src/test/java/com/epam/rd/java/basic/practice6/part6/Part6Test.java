package com.epam.rd.java.basic.practice6.part6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part6Test {

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
    public void getListOfWordsShouldReturnListOfWords() {
        List<String> words = Part6.getListOfWords("part6.txt");
        Assert.assertTrue(words.size() > 0);
    }

    @Test
    public void shouldPrintUsageInfoWhenRunWithoutArgs() {
        Part6.main(new String[]{""});
        String output = baos.toString();
        Assert.assertTrue(output.contains("Usage:"));
        Assert.assertTrue(output.split(" ").length >= 6);
    }

    @Test
    public void shouldPrintUsageInfoWhenRunWithoutSomeArgs() {
        Part6.main(new String[]{"-i", "--task", "duplicates"});
        String output = baos.toString();
        Assert.assertTrue(output.contains("Usage:"));
        Assert.assertTrue(output.split(" ").length >= 6);
    }

    @Test
    public void shouldPrintUsageWhenCalled() {
        Part6.main(new String[0]);
        String output = baos.toString();
        Assert.assertTrue(output.contains("Usage:"));
        Assert.assertTrue(output.split(" ").length >= 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRunWithoutSomeMoreArgs() {
        Part6.main(new String[]{"--task", "duplicates", "-i"});
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

    @Test
    public void part62ShouldPrintCorrectData() {
        Part62.work(Arrays.asList("a", "bb", "z", "z", "ccc", "bb"));
        String output = baos.toString();
        try (Scanner sc = new Scanner(output)) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String line3 = sc.nextLine();
            Assert.assertEquals("ccc ==> 3", line1);
            Assert.assertEquals("bb ==> 2", line2);
            Assert.assertEquals("a ==> 1", line3);
        }
    }

    @Test
    public void part63ShouldPrintCorrectData() {
        Part63.work(Arrays.asList("a", "bb", "z", "z", "ccc", "bb", "ccc"));
        String output = baos.toString();
        try (Scanner sc = new Scanner(output)) {
            String line1 = sc.next();
            String line2 = sc.next();
            String line3 = sc.next();
            Assert.assertEquals("BB", line1);
            Assert.assertEquals("Z", line2);
            Assert.assertEquals("CCC", line3);
        }
    }
}
