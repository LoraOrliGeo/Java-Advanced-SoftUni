package a031_SetsAndMaps_Advanced_Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P11_LogsAggregator {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		Map<String, Map<String, Integer>> logsAggregator = new TreeMap<>();
		
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split("\\s+");
			String ip = line[0];
			String user = line[1];
			int duration = Integer.parseInt(line[2]);
			
			logsAggregator.putIfAbsent(user, new TreeMap<>());
			logsAggregator.get(user).putIfAbsent(ip, 0);
			logsAggregator.get(user).put(ip, logsAggregator.get(user).get(ip) + duration);
		}
		
		logsAggregator.entrySet().stream().forEach(user -> {
			int sum = user.getValue().values().stream().mapToInt(v -> v).sum();
			System.out.print(String.format("%s: %d ", user.getKey(), sum));
			System.out.println(user.getValue().keySet().toString());
		});
	}
}
