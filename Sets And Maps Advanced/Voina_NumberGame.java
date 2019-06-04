package a03_SetsAndMaps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina_NumberGame {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		List<Integer> firstCards = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> secondCards = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		
		Set<Integer> firstPlayer = new LinkedHashSet<>(firstCards);

		Set<Integer> secondPlayer = new LinkedHashSet<>(secondCards);

		for (int i = 1; i <= 50; i++) {
			if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
				break;
			}

			int firstCard = firstPlayer.iterator().next();
			int secondCard = secondPlayer.iterator().next();
			
			firstPlayer.remove(firstCard);
			secondPlayer.remove(secondCard);

			if (firstCard == secondCard) {
				firstPlayer.add(firstCard);
				secondPlayer.add(secondCard);
			} else {
				biggerNumber(firstCard, secondCard, firstPlayer, secondPlayer);
			}
		}

		if (firstPlayer.size() > secondPlayer.size()) {
			System.out.println("First player win!");
		} else if (secondPlayer.size() > firstPlayer.size()) {
			System.out.println("Second player win!");
		} else {
			System.out.println("Draw!");
		}
	}
	
	public static void biggerNumber (int firstNumber, int secondNumber, Set<Integer> firstPlayer, Set<Integer> secondPlayer) {

		if (firstNumber > secondNumber) {
			firstPlayer.add(firstNumber);
			firstPlayer.add(secondNumber);
		} else {
			secondPlayer.add(firstNumber);
			secondPlayer.add(secondNumber);
		}
	}
}
