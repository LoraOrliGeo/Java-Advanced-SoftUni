package a011_StacksAndQueues_Ex_16May2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_ReverseNumbersWithAStack {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < numbers.length; i++) {
			stack.push(numbers[i]);
		}
		
		stack.stream().forEach(e -> System.out.print(stack.pop() + " "));
	}
}
