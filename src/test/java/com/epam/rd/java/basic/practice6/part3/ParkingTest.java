package com.epam.rd.java.basic.practice6.part3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingTest {

    Parking p = new Parking(4);

    @Test
    public void shouldReturnTrueIfArrivedAtEmpty() {
        p.depart(1);
        assertTrue(p.arrive(1));
    }

    @Test
    public void shouldReturnFalseIfDepartedAtEmpty() {
        p.depart(1);
        p.arrive(1);
        p.depart(1);
        assertFalse(p.depart(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfKIsOutOfBounds() {
        p.depart(127);
        p.arrive(255);
    }

}