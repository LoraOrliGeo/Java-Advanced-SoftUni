package a011_StacksAndQueues_Ex_16May2019;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MaximumElement {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			int[] line = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
		
			if (line.length > 1) {
				int x = line[1];
				stack.push(x);
			} else {
				if (line[0] == 2) {
					stack.pop();
				} else {
					
//					System.out.println(stack.stream().max(Integer::compareTo).get());
					
					List<Integer> max = new ArrayList<>();
					for (Integer num : stack) {
						max.add(num);
					}
					max = max.stream().sorted().collect(Collectors.toList());
					System.out.println(max.get(max.size() - 1));
					
//					System.out.println(Collections.max(stack));
				}
			}
		}
	}
}
