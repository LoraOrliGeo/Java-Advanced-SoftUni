package a021_MultidimentionalArrays_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximumSumOf3x3SquareMatrix {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int rows = dimensions[0];
		int cols = dimensions[1];
		
		int[][] matrix = new int[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			matrix[row] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		
		int maxSum = Integer.MIN_VALUE;
		int bestRow = 0;
		int bestCol = 0;
		
		for (int row = 1; row < rows - 1; row++) {
			for (int col = 1; col < cols - 1; col++) {
				int sum = 0;
				
				int centerEl = matrix[row][col];
				int two = matrix[row - 1][col];
				int three = matrix[row + 1][col];
				int four = matrix[row][col - 1];
				int five = matrix[row][col + 1];
				int six = matrix[row + 1][col - 1];
				int seven = matrix[row + 1][col + 1];
				int eight = matrix[row - 1][col - 1];
				int nine = matrix[row - 1][col + 1];
				
				sum += centerEl + two + three + four + five + six + seven + eight + nine;
				
				if (sum > maxSum) {
					maxSum = sum;
					bestRow = row - 1;
					bestCol = col - 1;
				}
			}
		}
		
		System.out.printf("Sum = %d%n", maxSum);
		
		for (int row = bestRow; row < bestRow + 3; row++) {
			for (int col = bestCol; col < bestCol + 3; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}
