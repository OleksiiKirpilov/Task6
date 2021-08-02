package com.epam.rd.java.basic.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private final List<Boolean> lot;

    public Parking(int capacity) {
        lot = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            lot.add(false);
        }
    }

    public boolean arrive(int k) {
        checkPlace(k);
        int counter = 0;
        for (int index = k; counter++ < lot.size(); index = (index + 1) % lot.size()) {
            if (Boolean.FALSE.equals(lot.get(index))) {
                lot.set(index, true);
                return true;
            }
        }
        return false;
    }

    public boolean depart(int k) {
        checkPlace(k);
        return lot.set(k, false);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : lot) {
            sb.append(b ? '1' : '0');
        }
        System.out.print(sb);
    }

    private void checkPlace(int k) {
        if ((k > lot.size() - 1) || k < 0) {
            throw new IllegalArgumentException();
        }
    }
}
