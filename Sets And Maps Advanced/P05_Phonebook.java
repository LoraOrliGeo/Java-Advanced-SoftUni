package a031_SetsAndMaps_Advanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_Phonebook {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, String> phonebook = new LinkedHashMap<>();

		String line = "";

		while (!"search".equals(line = sc.nextLine())) {
			String[] tokens = line.split("-");
			String name = tokens[0];
			String phoneNumber = tokens[1];

			phonebook.put(name, phoneNumber);
		}

		String name = "";
		
		while (!"stop".equals(name = sc.nextLine())) {
			if (phonebook.containsKey(name)) {
				System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
			} else {
				System.out.printf("Contact %s does not exist.%n", name);
			}
		}
	}
}
