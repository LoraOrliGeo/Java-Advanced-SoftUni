package a031_SetsAndMaps_Advanced_Ex;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		Set<String> uniqueUsernames = new LinkedHashSet<>();
		
		for (int i = 0; i < n; i++) {
			String username = sc.nextLine();
			uniqueUsernames.add(username);
		}
		
		uniqueUsernames.forEach(e -> System.out.println(e));
	}
}
