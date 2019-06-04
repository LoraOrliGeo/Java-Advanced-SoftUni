package a031_SetsAndMaps_Advanced_Ex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P08_HandsOfCards {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Set<String>> playersCards = new LinkedHashMap<>();

		String line = "";

		while (!"JOKER".equals(line = sc.nextLine())) {
			String[] tokens = line.split(":\\s+");
			String name = tokens[0];
			String[] cards = tokens[1].split(", ");

			if (!playersCards.containsKey(name)) {
				playersCards.put(name, new LinkedHashSet<>());
			}

			for (int i = 0; i < cards.length; i++) {
				playersCards.get(name).add(cards[i]);
			}
		}
		
		String regex = "([0-9]+|[JQKA])([SHDC]{1})";
		Pattern pattern = Pattern.compile(regex);
		
		playersCards.entrySet().stream().forEach(kvp -> {
			
			List<Integer> valuesOfCards = new ArrayList<>();
			
			kvp.getValue().forEach(card -> {
				Matcher matcher = pattern.matcher(card);
				int value = 0;
				int multiplier = 0;
				
				if (matcher.find()) {
					String power = matcher.group(1);
					String type = matcher.group(2);

					switch (power) {
					case "J":
						value = 11;
						break;
					case "Q":
						value = 12;
						break;
					case "K":
						value = 13;
						break;
					case "A":
						value = 14;
						break;
					default:
						value = Integer.parseInt(power);
						break;
					}

					switch (type) {
					case "S":
						multiplier = 4;
						break;
					case "H":
						multiplier = 3;
						break;
					case "D":
						multiplier = 2;
						break;
					case "C":
						multiplier = 1;
						break;
					}
					
					valuesOfCards.add(value * multiplier);
				}
			});
			
			int sum = valuesOfCards.stream().mapToInt(Integer::intValue).sum();
			System.out.print(kvp.getKey() + ": " + sum);
			System.out.println();
		});
	}
}
