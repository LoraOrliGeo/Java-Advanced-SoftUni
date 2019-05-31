import java.util.Scanner;

public class P03_DiagonalDifference {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		int[][] matrix = new int[n][n];

		for (int row = 0; row < n; row++) {
			String[] lineNumbers = sc.nextLine().split("\\s+");
			for (int col = 0; col < n; col++) {
				matrix[row][col] = Integer.parseInt(lineNumbers[col]);
			}
		}

		int primarySum = 0;

		for (int i = 0; i < n; i++) {
			primarySum += matrix[i][i];
		}

		int secondarySum = 0;

		for (int i = 0; i < n; i++) {
			secondarySum += matrix[i][n - 1 - i];
		}

		System.out.println(Math.abs(primarySum - secondarySum));
	}
}
