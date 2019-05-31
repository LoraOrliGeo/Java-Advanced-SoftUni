package a021_MultidimentionalArrays_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int rows = dimensions[0];
		int cols = dimensions[1];

		String[][] matrix = new String[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			matrix[row] = sc.nextLine().split("\\s+");
		}
		
		String line = "";
		
		while(!"END".equals(line = sc.nextLine())) {
			String[] tokens = line.split("\\s+");
			
			if (tokens.length == 5) {
				if (tokens[0].equals("swap")) {
					int row1 = Integer.parseInt(tokens[1]);
					int col1 = Integer.parseInt(tokens[2]);
					int row2 = Integer.parseInt(tokens[3]);
					int col2 = Integer.parseInt(tokens[4]);
					
					boolean validRows = row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows;
					boolean validCols = col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;
					
					if (validRows && validCols) {
						String temp = matrix[row1][col1];
						matrix[row1][col1] = matrix[row2][col2];
						matrix[row2][col2] = temp;
						
						printMatrix(matrix);
					} else {
						System.out.println("Invalid input!");
					}
				}
			} else {
				System.out.println("Invalid input!");
			}
		}
	}
	
	public static void printMatrix (String[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}
