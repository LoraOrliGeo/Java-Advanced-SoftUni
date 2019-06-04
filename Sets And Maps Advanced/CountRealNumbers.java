package a03_SetsAndMaps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CountRealNumbers {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		List<Double> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
		
		Map<Double, Integer> valuesCount = new LinkedHashMap<>();
		
		for (int i = 0; i < numbers.size(); i++) {
			double number = numbers.get(i);
			if (!valuesCount.containsKey(number)) {
				valuesCount.put(number, 0);
			}
			
			valuesCount.put(number, valuesCount.get(number) + 1);
		}
		
		for (Entry<Double, Integer> kvp : valuesCount.entrySet()) {
			System.out.println(String.format("%.1f -> %d", kvp.getKey(), kvp.getValue()));
		}
	}
}
