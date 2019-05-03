package a01_StacksAndQueues_Lab_14May2019;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P3_DecimalToBinary {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int decimal = Integer.parseInt(sc.nextLine());

//		if (decimal != 0) {
//			System.out.println(Integer.toBinaryString(decimal));
//		} else {
//			System.out.println("0");
//		}

		// now with stack :D

		ArrayDeque<Integer> binary = new ArrayDeque<>();

		if (decimal == 0) {
			System.out.println("0");
			return;
		}
		
		while (decimal != 0) {
			binary.push(decimal % 2);
			decimal /= 2;
		}

		for (Integer zeroOrOne : binary) {
			System.out.print(zeroOrOne);
		}
	}
}
