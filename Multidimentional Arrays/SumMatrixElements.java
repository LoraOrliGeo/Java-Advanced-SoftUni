package a02_MuldimentionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int[] dimensions = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int rows = dimensions[0];
		int cols = dimensions[1];
		
		int[][] multiArray = new int[rows][cols];
		
		int sum = 0;
		
		for (int row = 0; row < rows; row++) {
			int[] lineNumbers = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
			for (int col = 0; col < cols; col++) {
				multiArray[row][col] = lineNumbers[col];
				sum += multiArray[row][col];
			}
		}
		
		System.out.println(rows);
		System.out.println(cols);
		System.out.println(sum);
	}
}
