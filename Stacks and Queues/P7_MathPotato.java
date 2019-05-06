package a01_StacksAndQueues_Lab_14May2019;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P7_MathPotato {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		ArrayDeque<String> kids = new ArrayDeque<>();

		String[] names = sc.nextLine().split("\\s+");

		Collections.addAll(kids, names);

//		for (String name : names) {
//			kids.offer(name);
//		}

		int n = Integer.parseInt(sc.nextLine());
		int count = 1;

		while (kids.size() > 1) {
			for (int i = 1; i < n; i++) {
				String rearrangeKid = kids.poll();
				kids.offer(rearrangeKid);
			}

			if (isPrime(count)) {
				System.out.println("Prime " + kids.peek());
			} else {
				System.out.println("Removed " + kids.poll());
			}
			
			count++;
		}

		System.out.println("Last is " + kids.peek());
	}

	public static boolean isPrime(int count) {
		if (count <= 1) {
		return false;
		} 
		
		for (int i = 2; i <= Math.sqrt(count); i++) {
			if (count % i == 0)  {
				return false;
			}
		}
		
		return true;
	}
}
