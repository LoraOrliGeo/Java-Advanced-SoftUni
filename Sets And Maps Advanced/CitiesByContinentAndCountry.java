package a03_SetsAndMaps_Advanced_Lab;

import java.util.*;
import java.util.Map.Entry;

public class CitiesByContinentAndCountry {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split("\\s+");
			String cintinent = tokens[0];
			String country = tokens[1];
			String city = tokens[2];

			if (!map.containsKey(cintinent)) {
				map.put(cintinent, new LinkedHashMap<>());
				if (!map.get(cintinent).containsKey(country)) {
					map.get(cintinent).put(country, new ArrayList<>());
				}
				map.get(cintinent).get(country).add(city);
			} else {
				if (!map.get(cintinent).containsKey(country)) {
					map.get(cintinent).put(country, new ArrayList<>());
				}
				map.get(cintinent).get(country).add(city);
			}
		}

		map.entrySet().stream().forEach(kvp -> {
			System.out.println(kvp.getKey() + ":");

			for (Entry<String, List<String>> country : kvp.getValue().entrySet()) {
				System.out.println("  " + country.getKey() + " -> " + country.getValue().toString().replaceAll("\\]|\\[", ""));
			}
		});
	}
}
