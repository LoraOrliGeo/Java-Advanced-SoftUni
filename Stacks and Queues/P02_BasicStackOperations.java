package a011_StacksAndQueues_Ex_16May2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_BasicStackOperations {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int[] nsx = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
		int n = nsx[0];
		int s = nsx[1];
		int x = nsx[2];

		int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();

		ArrayDeque<Integer> numbers = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			numbers.push(input[i]);
		}

		for (int i = 0; i < s; i++) {
			numbers.pop();
		}

		if (numbers.isEmpty()) {
			System.out.println("0");
		} else if (numbers.contains(x)) {
			System.out.println("true");
		} else {

			// Collections.min()

			int min = Integer.MAX_VALUE;

			while (!numbers.isEmpty()) {
				int num = numbers.pop();

				if (num < min) {
					min = num;
				}
			}

			System.out.println(min);
		}
	}
}
