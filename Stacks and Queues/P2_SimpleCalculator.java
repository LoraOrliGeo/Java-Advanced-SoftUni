package a01_StacksAndQueues_Lab_14May2019;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P2_SimpleCalculator {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		
		Scanner sc = new Scanner(System.in);
		
		String[] tokens = sc.nextLine().split("\\s+");
		ArrayDeque<String> stack = new ArrayDeque<>();
		
		// to fill the stack - 2 ways: reversed for loop OR Collections.addAll (faster):
		
//		for (int i = tokens.length - 1; i >= 0 ; i--) {
//			stack.push(tokens[i]);
//		}
		
		Collections.addAll(stack, tokens);
		
		while (stack.size() > 1) {
			int first = Integer.parseInt(stack.pop());
			String operator = stack.pop();
			int second = Integer.parseInt(stack.pop());
			
			switch (operator) {
			case "+":
				stack.push(String.valueOf(first + second));
				break;
			case "-":
				stack.push(first - second + "");
				break;
			}
		}
		
		System.out.println(stack.peek());
	}
}
