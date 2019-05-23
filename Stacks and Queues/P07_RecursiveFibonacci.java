package a011_StacksAndQueues_Ex_16May2019;

import java.util.Scanner;

public class P07_RecursiveFibonacci {

	private static long[] memory;

	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		memory = new long[n + 1];

		long res = getFibonacci(n);

		System.out.println(res);
	}

	private static long getFibonacci(int n) {
		if (n < 2) {
			return 1;
		}

		if (memory[n] != 0) {
			return memory[n];
		}
		return memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
	}
}
