package a011_StacksAndQueues_Ex_16May2019;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_BalancedParentheses {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		String sequance = sc.nextLine();

		ArrayDeque<Character> parentheses = new ArrayDeque<>();

		boolean isBallanced = true;

		for (int i = 0; i < sequance.length(); i++) {
			char parenthese = sequance.charAt(i);

			if (parenthese == '[' || parenthese == '{' || parenthese == '(') {
				parentheses.push(parenthese);
			} else {
				if (parentheses.isEmpty()) {
					isBallanced = false;
					break;
				}
				char top = parentheses.pop();

				if (parenthese == ']' && top != '[') {
					isBallanced = false;
					break;
				} else if (parenthese == '{' && top != '}') {
					isBallanced = false;
					break;
				} else if (parenthese == '(' && top != ')') {
					isBallanced = false;
					break;
				}
			}
		}

		if (isBallanced) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
