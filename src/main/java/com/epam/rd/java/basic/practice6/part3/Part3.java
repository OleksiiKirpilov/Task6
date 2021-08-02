package com.epam.rd.java.basic.practice6.part3;

public class Part3 {

    public static void main(String[] args) {
        Parking p = new Parking(4);
        boolean b;
        System.out.println("arrive(2)");
        b = p.arrive(2); // 0010, true
        p.print();
        System.out.printf(", %b%n", b);

        System.out.println("arrive(3)");
        b = p.arrive(3); // 0011, true
        p.print();
        System.out.printf(", %b%n", b);

        System.out.println("arrive(2)");
        b = p.arrive(2); // 1011, true
        p.print();
        System.out.printf(", %b%n", b);

        System.out.println("arrive(2)");
        b = p.arrive(2); // 1111, true
        p.print();
        System.out.printf(", %b%n", b);

        System.out.println("arrive(2)");
        b = p.arrive(2); // 1111, false
        p.print();
        System.out.printf(", %b%n", b);

        System.out.println("depart(1)");
        b = p.depart(1); // 1011, true
        p.print();
        System.out.printf(", %b%n", b);

        System.out.println("depart(1)");
        b = p.depart(1); // 1011, false
        p.print();
        System.out.printf(", %b%n", b);
    }

}
