package a031_SetsAndMaps_Advanced_Ex;

import java.util.*;

public class P03_PeriodicTable {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		TreeSet<String> chemicalCompounds = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			String[] elements = sc.nextLine().split("\\s+");
			for (int j = 0; j < elements.length; j++) {
				chemicalCompounds.add(elements[j]);
			}
		}
		
		chemicalCompounds.forEach(e -> System.out.print(e + " "));
	}
}
