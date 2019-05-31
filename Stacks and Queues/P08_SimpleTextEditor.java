package a011_StacksAndQueues_Ex_16May2019;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_SimpleTextEditor {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		String output = "";

		ArrayDeque<String> memory = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split("\\s+");
			String operation = tokens[0];
			String argument = "";

			if (tokens.length > 1) {
				argument = tokens[1];
			}

			switch (operation) {
			case "1":
				memory.push(output);
				output += argument;
				break;
			case "2":
				memory.push(output);
				int count = Integer.parseInt(argument);
				for (int j = 0; j < count; j++) {
					output = output.substring(0, output.length() - 1);
				}
				break;
			case "3":
				int index = Integer.parseInt(argument);
				System.out.println(output.charAt(index - 1));
				break;
			case "4":
				output = memory.pop();
				break;
			}
		}
	}
}
