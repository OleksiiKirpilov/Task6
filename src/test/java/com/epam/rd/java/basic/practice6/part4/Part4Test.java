package com.epam.rd.java.basic.practice6.part4;

import com.epam.rd.java.basic.practice6.part4.Part4;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part4Test {

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
    public void mainShouldPrint2Lines() {
        Part4.main(new String[0]);
        String[] output = baos.toString().split(System.lineSeparator());
        Assert.assertEquals(2, output.length);
    }
}
