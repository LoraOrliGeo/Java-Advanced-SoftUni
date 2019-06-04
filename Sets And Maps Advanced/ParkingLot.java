import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Set<String> carNumbers = new HashSet<>();

		String line = "";

		while (!"END".equals(line = sc.nextLine())) {
			String[] tokens = line.split(",\\s+");
			String option = tokens[0];
			String carNumber = tokens[1];

			switch (option) {
			case "IN":
				carNumbers.add(carNumber);
				break;
			case "OUT":
				carNumbers.remove(carNumber);
				break;
			}
		}

		if (!carNumbers.isEmpty()) {
			for (String carNumber : carNumbers) {
				System.out.println(carNumber);
			}
		} else {
			System.out.println("Parking Lot is Empty");
		}
	}
}
