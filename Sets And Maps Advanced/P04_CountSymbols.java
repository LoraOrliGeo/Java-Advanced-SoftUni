package a031_SetsAndMaps_Advanced_Ex;

import java.util.*;

public class P04_CountSymbols {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		Map<Character, Integer> symbols = new TreeMap<>();
		
		String input = sc.nextLine();
		
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			symbols.putIfAbsent(symbol, 0);
			symbols.put(symbol, symbols.get(symbol) + 1);
		}
		
		symbols.entrySet().stream().forEach(kvp -> {
			System.out.println(String.format("%c: %d time/s", kvp.getKey(), kvp.getValue()));
		});
	}
}
