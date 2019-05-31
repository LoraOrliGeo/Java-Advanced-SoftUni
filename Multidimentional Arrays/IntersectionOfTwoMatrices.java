package a02_MuldimentionalArrays_Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int rows = Integer.parseInt(sc.nextLine());
		int cols = Integer.parseInt(sc.nextLine());

		char[][] first = new char[rows][cols];
		char[][] second = new char[rows][cols];

		char[][] resultMatrix = new char[rows][cols];

		for (int row = 0; row < rows * 2; row++) {
			String[] inputLine = sc.nextLine().split("\\s+");
			
			if (row < rows) {
				for (int col = 0; col < cols; col++) {
					first[row][col] = inputLine[col].charAt(0);
				}
			} else {
				for (int col = 0; col < cols; col++) {
					second[row - rows][col] = inputLine[col].charAt(0);;
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (first[row][col] == second[row][col]) {
					resultMatrix[row][col] = first[row][col];
				} else {
					resultMatrix[row][col] = '*';
				}
			}
		}

		for (char[] row : resultMatrix) {
			for (char symbol : row) {
				System.out.print(symbol + " ");
			}
			System.out.println();
		}
	}
}
