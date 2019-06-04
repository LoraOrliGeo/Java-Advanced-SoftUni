package a031_SetsAndMaps_Advanced_Ex;

import java.util.*;
import java.util.Scanner;

public class P02_SetsOfElements {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
		LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
		LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
		
		int[] sizes = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int n = sizes[0];
		int m = sizes[1];
		
		for (int i = 0; i < n + m; i++) {
			int num = Integer.parseInt(sc.nextLine());
			
			if (i < n) {
				firstSet.add(num);
			} else {
				secondSet.add(num);
			}
			
			numbers.add(num);
		}
		
		for (int number : numbers) {
			if (firstSet.contains(number) && secondSet.contains(number)) {
				System.out.print(number + " ");
			}
		}
	}
}
