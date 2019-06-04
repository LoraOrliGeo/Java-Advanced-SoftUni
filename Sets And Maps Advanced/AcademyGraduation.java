package a03_SetsAndMaps_Advanced_Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		Map<String, List<Double>> studentsGrades = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String name = sc.nextLine();
			List<Double> grades = Arrays.stream(sc.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
			
			studentsGrades.putIfAbsent(name, new ArrayList<>());
			studentsGrades.put(name, grades);
		}
		
		DecimalFormat df  = new DecimalFormat("###.################");
		
		studentsGrades.entrySet().stream().forEach(kvp -> {
			double sum = 0;
			for (Double grade : kvp.getValue()) {
				sum += grade;
			}
			double avg = sum / kvp.getValue().size();
			System.out.println(String.format("%s is graduated with %s", kvp.getKey(), df.format(avg)));
		});
	}
}
