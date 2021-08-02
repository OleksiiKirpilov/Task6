package com.epam.rd.java.basic.practice6.part3;

public class Part3 {

    public static void main(String[] args) {
        Parking p = new Parking(4);
        printArrive(p, 2);
        printArrive(p, 3);
        printArrive(p, 2);
        printArrive(p, 2);
        printArrive(p, 2);
        printDepart(p, 1);
        printArrive(p, 1);
    }

    private static void printArrive(Parking p, int i) {
        boolean b;
        System.out.printf("arrive(%d)%n", i);
        b = p.arrive(i);
        p.print();
        System.out.printf(", %b%n", b);
    }

    private static void printDepart(Parking p, int i) {
        boolean b;
        System.out.printf("depart(%d)%n", i);
        b = p.depart(i);
        p.print();
        System.out.printf(", %b%n", b);
    }


}
