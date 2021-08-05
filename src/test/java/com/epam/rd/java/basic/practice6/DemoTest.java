package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part5.Part5;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DemoTest {

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
    public void shouldPrintPartXDemo() {
        Demo.main(new String[0]);
        String output = baos.toString();
        StringBuilder sb = new StringBuilder("Part 0 demo:");
        int pos = sb.indexOf("0");
        for (int i = 1; i < 7; i++) {
            sb.setCharAt(pos, (char)('0' + i));
            Assert.assertTrue(output.contains(sb));
        }
    }
}
