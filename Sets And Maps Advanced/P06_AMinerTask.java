package a031_SetsAndMaps_Advanced_Ex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P06_AMinerTask {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		Map<String, List<Integer>> resources = new LinkedHashMap<>();
		
		String line = "";
		
		while(!"stop".equals(line = sc.nextLine())) {
			String resource = line;
			int quantity = Integer.parseInt(sc.nextLine());
			
			if (!resources.containsKey(resource)) {
				resources.put(resource, new ArrayList<>());
			}
			
			resources.get(resource).add(quantity);
		}
		
		resources.entrySet().stream().forEach(kvp -> {
			int sum = kvp.getValue().stream().mapToInt(Integer::intValue).sum();
			System.out.println(String.format("%s -> %d", kvp.getKey(), sum));
		});
	}
}
