package a031_SetsAndMaps_Advanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_FixEmails {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		String regex = ".[us|com|uk]+$";
		Pattern pattern = Pattern.compile(regex);

		Map<String, String> userAndEmail = new LinkedHashMap<>();

		String name = "";

		while (!"stop".equals(name = sc.nextLine())) {
			String email = sc.nextLine();

			Matcher matcher = pattern.matcher(email);

			if (!matcher.find()) {
				userAndEmail.putIfAbsent(name, email);
			}
		}

		userAndEmail.entrySet().stream().forEach(kvp -> {
			System.out.println(String.format("%s -> %s", kvp.getKey(), kvp.getValue()));
		});
	}
}
