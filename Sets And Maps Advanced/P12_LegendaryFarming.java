package a031_SetsAndMaps_Advanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P12_LegendaryFarming {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> materials = new LinkedHashMap<>();

		materials.put("motes", 0);
		materials.put("shards", 0);
		materials.put("fragments", 0);

		Map<String, Integer> junk = new TreeMap<>();

		boolean isObtained = false;

		String winnerMaterial = "";

		while (!isObtained) {
			String[] line = sc.nextLine().split("\\s+");

			for (int i = 0; i < line.length - 1; i += 2) {
				int quantity = Integer.parseInt(line[i]);
				String material = line[i + 1].toLowerCase();

				if (materials.containsKey(material)) {
					materials.put(material, materials.get(material) + quantity);

					if (materials.get(material) >= 250) {
						materials.put(material, materials.get(material) - 250);

						winnerMaterial = material;
						isObtained = true;
						break;
					}
				} else {
					junk.putIfAbsent(material, 0);
					junk.put(material, junk.get(material) + quantity);
				}
			}
		}

		if (winnerMaterial.equals("motes")) {
			System.out.println("Dragonwrath obtained!");
		} else if (winnerMaterial.equals("shards")) {
			System.out.println("Shadowmourne obtained!");
		} else {
			System.out.println("Valanyr obtained!");
		}

		materials.entrySet().stream().sorted((e1, e2) -> {
			int sort = Integer.compare(e2.getValue(), e1.getValue());

			if (sort == 0) {
				sort = e1.getKey().compareTo(e2.getKey());
			}

			return sort;
		}).forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));

		for (Map.Entry<String, Integer> kvp : junk.entrySet()) {
			System.out.println(String.format("%s: %d", kvp.getKey(), kvp.getValue()));
		}
	}
}
