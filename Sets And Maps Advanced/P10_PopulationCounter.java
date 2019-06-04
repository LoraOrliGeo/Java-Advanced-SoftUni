package a031_SetsAndMaps_Advanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_PopulationCounter {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		Map<String, Map<String, Long>> statistics = new LinkedHashMap<>();
		
		String input = "";
		
		while (!"report".equals(input = sc.nextLine())) {
			String[] tokens = input.split("\\|");
			String city = tokens[0];
			String country = tokens[1];
			long population = Integer.parseInt(tokens[2]);
			
			statistics.putIfAbsent(country, new LinkedHashMap<>());
			statistics.get(country).putIfAbsent(city, population);
		}
		
		 statistics.entrySet().stream().sorted((c1, c2) -> {
			 long p1 = c1.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum();
			 long p2 = c2.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum();
			 
			 return Long.compare(p2, p1);
		 }).forEach(c -> {
			 Long totalPopulation = c.getValue().values().stream().mapToLong(v -> v).sum();
			 System.out.println(String.format("%s (total population: %d)", c.getKey(), totalPopulation));
			 
			 Map<String, Long> childMap = c.getValue();
			 
			 childMap.entrySet().stream().sorted((e1, e2) -> {
				 return Long.compare(e2.getValue(), e1.getValue());
			 }).forEach(s -> {
				 System.out.println(String.format("=>%s: %d", s.getKey(), s.getValue()));
			 });
		 });
	}
}
