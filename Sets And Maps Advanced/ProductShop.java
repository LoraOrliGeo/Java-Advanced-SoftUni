package a03_SetsAndMaps_Advanced_Lab;

import java.util.*;
import java.util.Map.Entry;

public class ProductShop {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Map<String, Double>> markets = new TreeMap<>();

		String line = "";

		while (!"Revision".equals(line = sc.nextLine())) {
			String[] tokens = line.split(",\\s+");
			String market = tokens[0];
			String product = tokens[1];
			double price = Double.parseDouble(tokens[2]);

			if (!markets.containsKey(market)) {
				markets.put(market, new LinkedHashMap<>());
				if (!markets.get(market).containsKey(product)) {
					markets.get(market).put(product, price);
				}
				markets.get(market).put(product, price);
			} else {
				if (!markets.get(market).containsKey(product)) {
					markets.get(market).put(product, price);
				}
				markets.get(market).put(product, price);
			}
		}
		
		markets.entrySet().stream().forEach(kvp -> {
			System.out.println(kvp.getKey() + "->");
			for (Entry<String, Double> product : kvp.getValue().entrySet()) {
				System.out.println(String.format("Product: %s, Price: %.1f", product.getKey(), product.getValue()));
			}
		});
	}
}
