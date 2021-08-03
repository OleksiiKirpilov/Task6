package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

	private static final String SEPARATOR = "--------------------";

	public static void main(String[] args) {
		System.out.println("Part 1 demo:");
		Part1.main(args);
		printHeader(2);
		Part2.main(args);
		printHeader(3);
		Part3.main(args);
		printHeader(4);
		Part4.main(args);
		printHeader(5);
		Part5.main(args);
		printHeader(6);
		String[] params = {"--input", "part6.txt", "--task", "frequency"};
		Part6.main(params);
		params[3] = "length";
		Part6.main(params);
		params[3] = "duplicates";
		Part6.main(params);
	}

	private static void printHeader(int n) {
		System.out.println(SEPARATOR);
		System.out.printf("Part %d demo:%n", n);
	}

}
