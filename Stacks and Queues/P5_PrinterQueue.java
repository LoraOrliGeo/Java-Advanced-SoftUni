package a01_StacksAndQueues_Lab_14May2019;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P5_PrinterQueue {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		
		ArrayDeque<String> printer = new ArrayDeque<>();
		
		String line = "";
		
		while (!"print".equals(line = sc.nextLine())) {
			if (line.equals("cancel")) {
				if (!printer.isEmpty()) {
					String canceled = printer.poll();
					System.out.println("Canceled " + canceled);
				} else {
					System.out.println("Printer is on standby");
				}
			} else {
				printer.offer(line);
			}
		}
		
		printer.stream().forEach(e -> System.out.println(e));
	}
}
