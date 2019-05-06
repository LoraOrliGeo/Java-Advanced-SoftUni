package a01_StacksAndQueues_Lab_14May2019;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P6_HotPotato {
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

		while (kids.size() > 1) {
			for (int i = 1; i < n ; i++) {
				String rearrangeKid = kids.poll();
				kids.offer(rearrangeKid);
			}
			
			System.out.println("Removed " + kids.pop());
		}

		System.out.println("Last is " + kids.peek());
	}
}
