package a011_StacksAndQueues_Ex_16May2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
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
			numbers.offer(input[i]);
		}

		for (int i = 0; i < s; i++) {
			numbers.poll();
		}

		if (numbers.isEmpty()) {
			System.out.println("0");
		} else if (numbers.contains(x)) {
			System.out.println("true");
		} else {
			
			//Collections.min()
			
			System.out.println(Collections.min(numbers));
			
//			List<Integer> nums = new ArrayList<>();
//			for (Integer num : numbers) {
//				nums.add(num);
//			}
//			nums = nums.stream().sorted().limit(1).collect(Collectors.toList());
//			System.out.println(nums.get(0));
		}
	}
}
