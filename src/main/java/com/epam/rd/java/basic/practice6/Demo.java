package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;

public class Demo {

	public static void main(String[] args) {
		String separator = "--------------------";
		System.out.println("Part 1 demo:");
		Part1.main(args);
		System.out.println(separator);
		System.out.println("Part 2 demo:");
		Part2.main(args);
		System.out.println(separator);
		System.out.println("Part 3 demo:");
		Part3.main(args);
		System.out.println(separator);
		System.out.println("Part 4 demo:");
		Part4.main(args);
		System.out.println(separator);
	}

}
