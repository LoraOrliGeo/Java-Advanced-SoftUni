package a031_SetsAndMaps_Advanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13_SrabskoUnleashed {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Map<String, Integer>> concertStats = new LinkedHashMap<>();

		String regex = "(?<singer>[A-Za-z ]+)\\s@(?<venue>[A-Za-z ]+)\\s(?<price>[0-9]+)\\s(?<tickets>[0-9]+)";
		Pattern pattern = Pattern.compile(regex);

		String line = "";

		while (!"End".equals(line = sc.nextLine())) {
			Matcher matcher = pattern.matcher(line);

			if (matcher.find()) {
				String singer = matcher.group("singer");
				String venue = matcher.group("venue");
				int priceTicket = Integer.parseInt(matcher.group("price"));
				int tickets = Integer.parseInt(matcher.group("tickets"));

				concertStats.putIfAbsent(venue, new LinkedHashMap<>());

				if (!concertStats.get(venue).containsKey(singer)) {
					concertStats.get(venue).put(singer, priceTicket * tickets);
				} else {
					concertStats.get(venue).put(singer, concertStats.get(venue).get(singer) + priceTicket * tickets);
				}
			}
		}

		concertStats.entrySet().stream().forEach(e -> {
			System.out.println(e.getKey());
			e.getValue().entrySet().stream().sorted((s1, s2) -> {
				return s2.getValue() - s1.getValue();
			}).forEach(s -> {
				System.out.println(String.format("#  %s -> %d", s.getKey(), s.getValue()));
			});
		});

	}
}