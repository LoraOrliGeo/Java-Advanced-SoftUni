package a02_MuldimentionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int[] dimensions = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

		int rows = dimensions[0];
		int cols = dimensions[1];

		int[][] multiArray = new int[rows][cols];

		int sum = 0;
		int bestSum = Integer.MIN_VALUE;
		int bestRowIndex = 0;
		int bestColIndex = 0;

		for (int row = 0; row < rows; row++) {
			int[] lineNumbers = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
			for (int col = 0; col < cols; col++) {
				multiArray[row][col] = lineNumbers[col];
			}
		}

		for (int row = 0; row < rows - 1; row++) {
			for (int col = 0; col < cols - 1; col++) {
				int first = multiArray[row][col];
				int second = multiArray[row][col + 1];
				int third = multiArray[row + 1][col];
				int fourth = multiArray[row + 1][col + 1];

				sum = first + second + third + fourth;

				if (sum > bestSum) {
					bestSum = sum;
					bestRowIndex = row;
					bestColIndex = col;
				}
			}
		}

		for (int row = bestRowIndex; row < bestRowIndex + 2; row++) {
			for (int col = bestColIndex; col < bestColIndex + 2; col++) {
				System.out.print(multiArray[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println(bestSum);
	}
}
