package a01_StacksAndQueues_Lab_14May2019;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P4_MatchingBrackets {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		String equation = sc.nextLine();

		ArrayDeque<Integer> bracketsIndecies = new ArrayDeque<>();

		for (int i = 0; i < equation.length(); i++) {
			char symbol = equation.charAt(i);
			
			if (symbol == '(') {
				bracketsIndecies.push(i);
			} else if (symbol == ')') {
				int startIndex = bracketsIndecies.pop();
				System.out.println(equation.substring(startIndex, i + 1));
			}
		}
	}
}
