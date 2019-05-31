import java.util.Arrays;
import java.util.Scanner;

public class P02_MatrixOfPalindromes {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int rows = dimensions[0];
		int cols = dimensions[1];
		
		char startSymbol = 'a';
		
		for (int i = 0; i < rows; i++) {
			int nextSymbol = 0;
			for (int j = 0; j < cols; j++) {
				System.out.print(startSymbol + "" + (char)(startSymbol + nextSymbol) + startSymbol + " ");
				nextSymbol++;
			}
			startSymbol++;
			System.out.println();
		}
	}
}
