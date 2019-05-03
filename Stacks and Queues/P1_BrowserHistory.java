import java.util.ArrayDeque;
import java.util.Scanner;

public class P1_BrowserHistory {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);

		ArrayDeque<String> urls = new ArrayDeque<>();

		String input = "";
		
		while (!"Home".equals(input = sc.nextLine())) {
			if (input.equals("back")) {
				if (urls.size() > 1) {
					urls.pop();
					System.out.println(urls.peek());
				} else {
					System.out.println("no previous URLs");
				}
			} else {
				System.out.println(input);
				urls.push(input);
			}
		}
	}
}
