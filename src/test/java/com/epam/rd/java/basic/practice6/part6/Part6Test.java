package com.epam.rd.java.basic.practice6.part6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        //System.out.flush();
        //rollback();
        String output = baos.toString();
        Assert.assertTrue(output.contains("Usage:"));
        Assert.assertTrue(output.split(" ").length >= 6);
    }

    @Test
    public void PartsShouldPrint3Lines(){
        String[][] params = new String[][] {
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

}
