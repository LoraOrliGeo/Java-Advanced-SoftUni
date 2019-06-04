package a031_SetsAndMaps_Advanced_Ex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P14_DragonArmy {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Map<String, List<Integer>>> dragons = new LinkedHashMap<>();

		int healthDef = 250;
		int damageDef = 45;
		int armorDef = 10;

		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split("\\s+");

			String type = input[0];
			String name = input[1];

			int damage = 0;
			int health = 0;
			int armor = 0;

			// double damage = input[0].equals("null") ? 45 : Double.parseDouble(input[0]);

			if (!input[2].equals("null")) {
				damage = Integer.parseInt(input[2]);
			} else {
				damage = damageDef;
			}

			if (!input[3].equals("null")) {
				health = Integer.parseInt(input[3]);
			} else {
				health = healthDef;
			}

			if (!input[4].equals("null")) {
				armor = Integer.parseInt(input[4]);
			} else {
				armor = armorDef;
			}

			dragons.putIfAbsent(type, new TreeMap<>());

			if (!dragons.get(type).containsKey(name)) {
				dragons.get(type).put(name, new ArrayList<>());
				dragons.get(type).get(name).add(damage);
				dragons.get(type).get(name).add(health);
				dragons.get(type).get(name).add(armor);
			} else {
				dragons.get(type).get(name).set(0, damage);
				dragons.get(type).get(name).set(1, health);
				dragons.get(type).get(name).set(2, armor);
			}
		}

		dragons.forEach((k, v) -> {
			double damageSum = 0;
			double healthSum = 0;
			double armorSum = 0;
			
			Map<String, List<Integer>> dragonsNames = v;

			for (List<Integer> stats : dragonsNames.values()) {
				damageSum += stats.get(0);
				healthSum += stats.get(1);
				armorSum += stats.get(2);
			}

			System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", k, damageSum / v.size(), healthSum / v.size(),
					armorSum / v.size()));

			v.entrySet().stream().sorted((d1, d2) -> {
				int sort = d1.getKey().compareTo(d2.getKey());
				return sort;
			}).forEach(e -> System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
					e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2))));
		});

	}
}
