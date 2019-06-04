package a03_SetsAndMaps_Advanced_Lab;

import java.util.*;

public class AverageStudentsGrades {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		Map<String, List<Double>> studentGrades = new TreeMap<>();

		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split("\\s+");
			String name = tokens[0];
			double grade = Double.parseDouble(tokens[1]);

			if (!studentGrades.containsKey(name)) {
				studentGrades.put(name, new ArrayList<>());
			}

			studentGrades.get(name).add(grade);
		}

		studentGrades.entrySet().stream().forEach(kvp -> {
			double sum = 0;
			
			System.out.printf("%s -> ", kvp.getKey());
			
			for (double grade : kvp.getValue()) {
				System.out.printf("%.2f ", grade);
				sum += grade;
			}
			double avg = sum / kvp.getValue().size();

			System.out.println(String.format("(avg: %.2f)", avg));
			
		});
	}
}
