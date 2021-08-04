package com.epam.rd.java.basic.practice6.part3;


public class Parking {

    private final boolean[] lot;

    public Parking(int capacity) {
        lot = new boolean[capacity];
    }

    public boolean arrive(int k) {
        checkPlace(k);
        int counter = 0;
        for (int index = k; counter++ < lot.length; index = (index + 1) % lot.length) {
            if (!lot[index]) {
                lot[index] = true;
                return true;
            }
        }
        return false;
    }

    public boolean depart(int k) {
        checkPlace(k);
        if (!lot[k]) {
            return false;
        }
        lot[k] = false;
        return true;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : lot) {
            sb.append(b ? '1' : '0');
        }
        System.out.print(sb);
    }

    private void checkPlace(int k) {
        if ((k > lot.length - 1) || k < 0) {
            throw new IllegalArgumentException();
        }
    }
}
