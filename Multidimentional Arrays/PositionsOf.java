package a02_MuldimentionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
//		int[][] multiArray = CompareMatrices.getMatrix(sc);
		
		int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = dimensions[0];
		int cols = dimensions[1];
		
		int[][] multiArray = new int[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			int[] lineNumbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			for (int col = 0; col < cols; col++) {
				multiArray[row][col] = lineNumbers[col];
			}
		}
		
		int number = Integer.parseInt(sc.nextLine());
		
		boolean isNotFound = true;
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (multiArray[row][col] == number) {
					isNotFound = false;
					System.out.println(row + " " + col);
				} 
			}
		}
		
		if(isNotFound) {
			System.out.println("not found");
		}
	}
}
