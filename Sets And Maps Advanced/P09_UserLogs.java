package a031_SetsAndMaps_Advanced_Ex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_UserLogs {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, Map<String, List<String>>> userLogs = new TreeMap<>();

		String line = "";

		String regex = "IP=(?<ip>[\\w.:]+)\\smessage=(?<mess>.+)\\suser=(?<user>\\w+)";
		Pattern pattern = Pattern.compile(regex);

		while (!"end".equals(line = sc.nextLine())) {
			Matcher matcher = pattern.matcher(line);

			if (matcher.find()) {
				String user = matcher.group("user");
				String ip = matcher.group("ip");
				String message = matcher.group("mess");

				userLogs.putIfAbsent(user, new LinkedHashMap<>());
				userLogs.get(user).putIfAbsent(ip, new ArrayList<>());
				userLogs.get(user).get(ip).add(message);
			}
		}
		
		userLogs.entrySet().stream().forEach(user -> {
			List<String> output = new ArrayList<>();
			System.out.println(user.getKey() + ":");
			user.getValue().entrySet().stream().forEach(ip -> {
				output.add((String.format("%s => %d", ip.getKey(), ip.getValue().size())));
			});
			
			System.out.println(output.toString().replaceAll("\\]|\\[", "") + ".");
		});
		
		
	}
}
