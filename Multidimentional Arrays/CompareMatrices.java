import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[][] firstMatrix = getMatrix(sc);
		
		int[][] secondMatrix = getMatrix(sc);
		
		if (areEqualMatrices(firstMatrix, secondMatrix)) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}

	public static int[][] getMatrix(Scanner sc) {
		int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int rows = dimensions[0];
		int cols = dimensions[1];
		
		int[][] matrix = new int[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			int[] lineNumbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = lineNumbers[col];
			}
		}
		return matrix;
	}
	
	public static boolean areEqualMatrices (int[][]  firstMatrix, int[][] secondMatrix) {
		if (firstMatrix.length != secondMatrix.length) {
			return false;
		}
		
		for (int row = 0; row < firstMatrix.length; row++) {
			if (firstMatrix[row].length != secondMatrix[row].length) {
				return false;
			}
			for (int col = 0; col < firstMatrix[row].length; col++) {
				if (firstMatrix[row][col] != secondMatrix[row][col]) {
					return false;
				}
			}
		}
		return true;
	}
}
