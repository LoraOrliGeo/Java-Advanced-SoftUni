package a03_SetsAndMaps_Advanced_Lab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SoftUniParty {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		Set<String> guestList = new HashSet<>();
		
		String guest = "";
		
		while (!"PARTY".equals(guest = sc.nextLine())) {
			guestList.add(guest);
		}
		
		while (!"END".equals(guest = sc.nextLine())) {
			if (guestList.contains(guest)) {
				guestList.remove(guest);
			}
		}
		
		System.out.println(guestList.size());
		
		List<String> vip = new ArrayList<>();
		List<String> regular = new ArrayList<>();
		
		for (String number : guestList) {
			if (Character.isDigit(number.charAt(0))) {
				vip.add(number);
			} else {
				regular.add(number);
			}
		}
		
		vip.stream().sorted().forEach(e -> System.out.println(e));
		regular.stream().sorted().forEach(e -> System.out.println(e));
	} 
}
